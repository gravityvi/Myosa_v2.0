package com.example.ravi.mayosa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by ravi on 14-02-2018.
 */

public class SensorListAdapter extends RecyclerView.Adapter<SensorListAdapter.ViewHolder> {

    private static Context context;
    private static ArrayList<SensorObject> SensorList;
    private static LayoutInflater inflator;


    public SensorListAdapter(Context context, ArrayList<SensorObject> arrayList ) {
        this.context=context;
        this.SensorList=arrayList;
        inflator=LayoutInflater.from(context);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflator.inflate(R.layout.sensor_row,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

       SensorObject  sensorObject= SensorList.get(position);
       holder.Attribute.setText(sensorObject.getAttribute());
       holder.SensorHeading.setText(sensorObject.getSensorHead());
       holder.Value.setText(sensorObject.getValue());

    }

    @Override
    public int getItemCount() {
        return SensorList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView SensorHeading;
        TextView Attribute;
        TextView Value;
        Button bSet;
        EditText MinValue;
        EditText MaxValue;


        public ViewHolder(View itemView) {
            super(itemView);
            Value=itemView.findViewById(R.id.tValue);
            SensorHeading=itemView.findViewById(R.id.tSensorHead);
            Attribute=itemView.findViewById(R.id.tAttribute);
            bSet= itemView.findViewById(R.id.bSet);
            MinValue=itemView.findViewById(R.id.eMinValue);
            MaxValue=itemView.findViewById(R.id.eMaxValue);


        }
    }
}
