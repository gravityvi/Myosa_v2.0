package com.example.ravi.mayosa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    private static RecyclerView SensorsView;
    private static ArrayList<SensorObject> SensorList;
    private static SensorListAdapter sensorListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        SensorsView=(RecyclerView)findViewById(R.id.SensorsView);
        SensorList=new ArrayList<SensorObject>();
         sensorListAdapter=new SensorListAdapter(this,SensorList);
        SensorsView.setLayoutManager(new LinearLayoutManager(this));

        //after putting all the values in array list set the recycler view adapter

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
