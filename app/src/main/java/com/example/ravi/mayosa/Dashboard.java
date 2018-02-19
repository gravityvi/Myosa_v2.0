package com.example.ravi.mayosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    private static RecyclerView SensorsView;
    private static ArrayList<SensorObject> SensorList;
    private static SensorListAdapter sensorListAdapter;
    private static Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        SensorsView=(RecyclerView)findViewById(R.id.SensorsView);
        SensorList=new ArrayList<SensorObject>();
        sensorListAdapter=new SensorListAdapter(this,SensorList);
        SensorsView.setLayoutManager(new LinearLayoutManager(this));

        //after putting all the values in array list set the recycler view adapter
        button = (Button) findViewById(R.id.bBluetooth);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Dashboard.this, com.example.ravi.mayosa.bluetooth_connectivity.BluetoothTerm.class);
                startActivity(i);
            }
        });

        for(int i=0;i<=10;i++)
        {
            SensorObject sensorObject=new SensorObject();
            sensorObject.setAttribute("Attr "+i);
            sensorObject.setSensorHead("Sensor "+i);
            SensorList.add(sensorObject);
        }

        SensorsView.setAdapter(sensorListAdapter);

    }
}
