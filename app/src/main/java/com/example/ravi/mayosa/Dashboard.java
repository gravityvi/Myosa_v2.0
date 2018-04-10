package com.example.ravi.mayosa;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ravi.mayosa.Database.DatabaseHelper;
import com.example.ravi.mayosa.bluetooth_connectivity.BluetoothComService;
import com.example.ravi.mayosa.bluetooth_connectivity.DeviceList;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.w3c.dom.Text;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    // Message types sent from the BluetoothComService Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;
    private String to_store = "";
    private static String[] SensorNames;
    private static DatabaseHelper databaseHelper;

    // Key names received from the BluetoothComService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    // Intent request codes
    private static final int REQUEST_CONNECT_DEVICE = 1;
    private static final int REQUEST_ENABLE_BT = 2;

    private RecyclerView.LayoutManager lm;
    // Name of the connected device
    private String mConnectedDeviceName = null;
    // Local Bluetooth adapter
    private BluetoothAdapter mBluetoothAdapter = null;

    // Member object for the chat services
    private BluetoothComService mChatService = null;
    View[] view = new View[18];
    GraphView[] graphViews;
    LineGraphSeries[] lineGraphSeries;
    private boolean visi[];
    private float x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        graphViews = new GraphView[18];
        lineGraphSeries = new LineGraphSeries[26];
        visi = new boolean[18];
        for(int i=0;i<18;i++){
            visi[i]=false;
        }
      databaseHelper=new DatabaseHelper(this,SensorNames); 
        //new
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        // If the adapter is null, then Bluetooth is not supported
        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth is not available", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth is not available", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menudash, menu);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        } else {
            if (mChatService == null) setupChat();
        }
    }

    @Override
    public synchronized void onResume() {
        super.onResume();
        if (mChatService != null) {
            if (mChatService.getState() == BluetoothComService.STATE_NONE) {
                mChatService.start();
            }
        }
    }

    private void setupChat() {
        mChatService = new BluetoothComService(this, mHandler);
    }

    @Override
    public synchronized void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stop the Bluetooth chat services
        if (mChatService != null) mChatService.stop();
    }

    private void ensureDiscoverable() {

        if (mBluetoothAdapter.getScanMode() != BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
            Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivity(discoverableIntent);
        }
    }


    private void sendMessage(String message) {

        // Check that we're actually connected before trying anything
        if (mChatService.getState() != BluetoothComService.STATE_CONNECTED) {
            Toast.makeText(this, R.string.not_connected, Toast.LENGTH_SHORT).show();
            return;
        }
        // Check that there's actually something to send
        if (message.length() > 0) {
            // Get the message bytes and tell the BluetoothComService to write
            byte[] send = message.getBytes();
            mChatService.write(send);
            // Reset out string buffer to zero and clear the edit text field
        }
    }

    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MESSAGE_WRITE:
                    byte[] writeBuf = (byte[]) msg.obj;
                    // construct a string from the buffer
                    String writeMessage = new String(writeBuf);
                    break;
                case MESSAGE_READ:
                    String readMessage =(String) msg.obj;
                    // construct a string from the valid bytes in the buffer
                    //String readMessage = new String(readBuf, 0, msg.arg1);

                    if(to_store.split(",").length>26){
                        to_store="";
                        break;
                    }

                    if (to_store.length()!=0){
                        to_store = to_store+readMessage;
                    }
                    else{
                        to_store = readMessage;
                    }

                    if ((to_store.split(",").length==26)){
                        to_store=to_store.trim();
                        String s[]=to_store.split(",");
                        to_store = "";
                        Log.e("msg","rcvd"+s.length);
                        addData(s);
                        valueSeque.addRecord(s);
                        databaseHelper.InsertData(s);
                    }

                    break;
                case MESSAGE_DEVICE_NAME:
                    // save the connected device's name
                    mConnectedDeviceName = msg.getData().getString(DEVICE_NAME);
                    Toast.makeText(getApplicationContext(), "Connected to " + mConnectedDeviceName, Toast.LENGTH_SHORT).show();
                    break;
                case MESSAGE_TOAST:
                    Toast.makeText(getApplicationContext(), msg.getData().getString(TOAST),
                            Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CONNECT_DEVICE:
                if (resultCode == Activity.RESULT_OK) {
                    String address = data.getExtras().getString(DeviceList.EXTRA_DEVICE_ADDRESS);
                    BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
                    mChatService.connect(device);
                }
                break;

            case REQUEST_ENABLE_BT:
                if (resultCode == Activity.RESULT_OK) {
                    setupChat();
                } else {
                    Toast.makeText(this, R.string.bt_not_enabled_leaving, Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }

    public void discoverable() {
        ensureDiscoverable();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to terminate this session?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //databaseHelper.onUpgrade();
                finish();
            }
        });
        builder.setNeutralButton("Save & Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                databaseHelper.Export();
                finish();
            }
        });
        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent serverIntent;

        switch (item.getItemId()){
            case R.id.action_connect:
                serverIntent = new Intent(this, DeviceList.class);
                startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
                return true;

            case R.id.cEvent:
                android.support.v4.app.FragmentManager fragmentManager =getSupportFragmentManager();
                EventManagement  eventManagement =new EventManagement();
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.add(eventManagement,"eventmanagement").addToBackStack("null").commit();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void addData(String[] s){
        Log.e("Graph","data added");
        for(int i=0;i<14;i++){
            if(!s[i].equals("*")){
                if(visi[i]==false){
                    view[i].setVisibility(View.VISIBLE);
                    visi[i]=true;
                }
                lineGraphSeries[i].appendData(new DataPoint(x,Integer.parseInt(s[i])),true,35);
                ((TextView)view[i].findViewById(R.id.tValue)).setText(s[i]);
            }
            else if(s[i].equals("*")){
                if(visi[i]==true){
                    view[i].setVisibility(View.GONE);
                    visi[i]=false;
                }
            }
        }

        int last=14;
        for(int j=14;j<18;j++){
            for(int i=0;i<3;i++) {
                if(s[last].equals("*")){
                    if(visi[j]==true){
                        view[j].setVisibility(View.GONE);
                        visi[j]=false;
                    }
                }
                else {
                    if (visi[j] == false) {
                        view[j].setVisibility(View.VISIBLE);
                        visi[j] = true;
                    }
                    lineGraphSeries[last].appendData(new DataPoint(x, Integer.parseInt(s[last])), true, 35);
                    if(i==0)
                        ((TextView)view[j].findViewById(R.id.tValue1)).setText(s[last]);
                    else if(i==1)
                        ((TextView)view[j].findViewById(R.id.tValue2)).setText(s[last]);
                    else
                        ((TextView)view[j].findViewById(R.id.tValue3)).setText(s[last]);
                }
                last++;
            }
        }


        x++;
    }

    void initViews(){
        Log.e("Graph","init");
        TextView attr;

        view[0] = findViewById(R.id.sValue1);
        attr = view[0].findViewById(R.id.tSensorHead); attr.setText("Luminosity Sensor"); attr = view[0].findViewById(R.id.tAttribute);attr.setText("Visibility (Raw Data)");

        view[1] = findViewById(R.id.sValue2); attr = view[1].findViewById(R.id.tSensorHead); attr.setText("Luminosity Sensor"); attr = view[1].findViewById(R.id.tAttribute); attr.setText("Infrared (Raw Data)");

        view[2] = findViewById(R.id.sValue3); attr = view[2].findViewById(R.id.tSensorHead); attr.setText("Luminosity Sensor"); attr = view[2].findViewById(R.id.tAttribute); attr.setText("Illuminace (LUX)");

        view[3] = findViewById(R.id.sValue4); attr = view[3].findViewById(R.id.tSensorHead); attr.setText("Barometric Sensor"); attr = view[3].findViewById(R.id.tAttribute); attr.setText("Pressure (mbar)");

        view[4] = findViewById(R.id.sValue5); attr = view[4].findViewById(R.id.tSensorHead); attr.setText("Barometric Sensor"); attr = view[4].findViewById(R.id.tAttribute); attr.setText("Pressure (mmHg)");

        view[5] = findViewById(R.id.sValue6); attr = view[5].findViewById(R.id.tSensorHead); attr.setText("Barometric Sensor"); attr = view[5].findViewById(R.id.tAttribute); attr.setText("Pressure (Meter)");

        view[6] = findViewById(R.id.sValue7); attr = view[6].findViewById(R.id.tSensorHead); attr.setText("Air Quality Sensor"); attr = view[6].findViewById(R.id.tAttribute); attr.setText("CO2 (ppm)");

        view[7] = findViewById(R.id.sValue8); attr = view[7].findViewById(R.id.tSensorHead); attr.setText("Air Quality Sensor"); attr = view[7].findViewById(R.id.tAttribute); attr.setText("TVOC (ppb)");

        view[8] = findViewById(R.id.sValue9); attr = view[8].findViewById(R.id.tSensorHead); attr.setText("Particle Sensor"); attr = view[8].findViewById(R.id.tAttribute); attr.setText("Heart Rate(BPM)");

        view[9] = findViewById(R.id.sValue10); attr = view[9].findViewById(R.id.tSensorHead); attr.setText("Particle Sensor"); attr = view[9].findViewById(R.id.tAttribute); attr.setText("Avg Heart Rate(BPM)");

        view[10] = findViewById(R.id.sValue11); attr = view[10].findViewById(R.id.tSensorHead); attr.setText("Particle Sensor"); attr = view[10].findViewById(R.id.tAttribute); attr.setText("Onxygenatede Blood (%)");

        view[11] = findViewById(R.id.sValue12); attr = view[11].findViewById(R.id.tSensorHead); attr.setText("Temperature & Humidity Sensor"); attr = view[11].findViewById(R.id.tAttribute); attr.setText("Temperature (\u00B0C)");

        view[12] = findViewById(R.id.sValue13); attr = view[12].findViewById(R.id.tSensorHead); attr.setText("Temperature & Humidity Sensor"); attr = view[12].findViewById(R.id.tAttribute); attr.setText("Temperature (\u00B0F)");

        view[13] = findViewById(R.id.sValue14); attr = view[13].findViewById(R.id.tSensorHead); attr.setText("Temperature & Humidity Sensor"); attr = view[13].findViewById(R.id.tAttribute); attr.setText("Humidity (%)");

        view[14] = findViewById(R.id.sValue15); attr = view[14].findViewById(R.id.tSensorHead); attr.setText("Magnetometer"); attr = view[14].findViewById(R.id.tAttribute1); attr.setText("X (mgauss)"); attr = view[14].findViewById(R.id.tAttribute2); attr.setText("Y (mgauss)"); attr = view[14].findViewById(R.id.tAttribute3); attr.setText("Z (mgauss)");

        view[15] = findViewById(R.id.sValue16); attr = view[15].findViewById(R.id.tSensorHead); attr.setText("RGB Sensor"); attr = view[15].findViewById(R.id.tAttribute1); attr.setText("Red (Raw Data)"); attr = view[15].findViewById(R.id.tAttribute2); attr.setText("Green (Raw Data)"); attr = view[15].findViewById(R.id.tAttribute3); attr.setText("Bule (Raw Data)");

        view[16] = findViewById(R.id.sValue17); attr = view[16].findViewById(R.id.tSensorHead); attr.setText("Gyroscop"); attr = view[16].findViewById(R.id.tAttribute1); attr.setText("X (\u00B0 degree)"); attr = view[16].findViewById(R.id.tAttribute2); attr.setText("Y (\u00B0 degree)"); attr = view[16].findViewById(R.id.tAttribute3); attr.setText("Z (\u00B0 degree)");

        view[17] = findViewById(R.id.sValue18); attr = view[17].findViewById(R.id.tSensorHead); attr.setText("Gyroscop"); attr = view[17].findViewById(R.id.tAttribute1); attr.setText("acc. in X (m/sec square)"); attr = view[17].findViewById(R.id.tAttribute2); attr.setText("acc. in Y (m/sec square)"); attr = view[17].findViewById(R.id.tAttribute3); attr.setText("acc. in Z (m/sec square)");


        Viewport viewport;
        for(int i=0;i<18;i++){
            graphViews[i]=view[i].findViewById(R.id.graph);
            viewport = graphViews[i].getViewport();
            viewport.setXAxisBoundsManual(true);
            viewport.setMaxX(30);
            viewport.setMinX(0);
            graphViews[i].getGridLabelRenderer().setHorizontalLabelsVisible(false);
            graphViews[i].getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
            graphViews[i].getGridLabelRenderer().setTextSize(25);
        }

        for(int i=14;i<18;i++){
            graphViews[i].getLegendRenderer().setVisible(true);
            graphViews[i].getLegendRenderer().setTextSize(25);
            graphViews[i].getLegendRenderer().setBackgroundColor(Color.argb(150,50,0,0));
            graphViews[i].getLegendRenderer().setTextColor(Color.WHITE);
            graphViews[i].getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        }
        for(int i=0;i<26;i++){
            lineGraphSeries[i] = new LineGraphSeries();
            lineGraphSeries[i].setDrawDataPoints(true);
            lineGraphSeries[i].setDataPointsRadius(6);
        }

        for(int i=0;i<14;i++){
            graphViews[i].addSeries(lineGraphSeries[i]);
        }

        for(int i=0;i<14;i++){
            lineGraphSeries[i].setColor(Color.argb(255, 246,74,138));
        }


        lineGraphSeries[14].setColor(Color.argb(255,49,140,231)); lineGraphSeries[14].setTitle("X");
        lineGraphSeries[15].setColor(Color.argb(255, 229, 43,80)); lineGraphSeries[15].setTitle("Y");
        lineGraphSeries[16].setColor(Color.argb(255,102,255,0)); lineGraphSeries[16].setTitle("Z");

        lineGraphSeries[20].setColor(Color.argb(255,49,140,231)); lineGraphSeries[20].setTitle("X");
        lineGraphSeries[21].setColor(Color.argb(255, 229, 43,80)); lineGraphSeries[21].setTitle("Y");
        lineGraphSeries[22].setColor(Color.argb(255,102,255,0)); lineGraphSeries[22].setTitle("Z");

        lineGraphSeries[23].setColor(Color.argb(255,49,140,231)); lineGraphSeries[23].setTitle("X");
        lineGraphSeries[24].setColor(Color.argb(255, 229, 43,80)); lineGraphSeries[24].setTitle("Y");
        lineGraphSeries[25].setColor(Color.argb(255,102,255,0)); lineGraphSeries[25].setTitle("Z");

        lineGraphSeries[17].setColor(Color.argb(255, 255, 0, 0)); lineGraphSeries[17].setTitle("Red");
        lineGraphSeries[18].setColor(Color.argb(255, 0, 255, 0)); lineGraphSeries[18].setTitle("Green");
        lineGraphSeries[19].setColor(Color.argb(255, 0, 0, 255)); lineGraphSeries[19].setTitle("Blue");

        int last=14;
        for(int j=14;j<18;j++){
            for(int i=0;i<3;i++) {
                graphViews[j].addSeries(lineGraphSeries[last]);
                last++;
            }
        }
    }
}