package com.example.ravi.myosa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class eventItemsRecyclerAdapter extends RecyclerView.Adapter<eventItemsRecyclerAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<EventAttributes> sectionItems;
    private ArrayList<sensorDetails.attr> attributes;


    public eventItemsRecyclerAdapter(Context context,ArrayList<EventAttributes> sectionItems, ArrayList<sensorDetails.attr> attributes) {
        this.context = context;
        this.attributes=attributes;
        this.sectionItems = sectionItems;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = layoutInflater.inflate(R.layout.event_item,parent,false);
       ViewHolder viewHolder = new ViewHolder(view);
       return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tSensorName.setText(attributes.get(position).getAttName());
        holder.tMax.setText(Double.toString(sectionItems.get(position).max));
        holder.tMin.setText(Double.toString(sectionItems.get(position).min));
        holder.tString.setText(sectionItems.get(position).s);
        if(sectionItems.get(position).inclusive)
        {
            holder.rgDisplay.check(R.id.rbInc);
        }
        else
        {
            holder.rgDisplay.check(R.id.rbExc);
        }
        holder.rgDisplay.setEnabled(false);
    }

    @Override
    public int getItemCount() {
        return sectionItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tSensorName;
        private TextView tMax;
        private TextView tMin;
        private TextView tString;
        private RadioGroup rgDisplay;

        public ViewHolder(View itemView) {
            super(itemView);
            tString = itemView.findViewById(R.id.tString);
            tSensorName = itemView.findViewById(R.id.tSensorName);
            tMax = itemView.findViewById(R.id.tMax);
            tMin = itemView.findViewById(R.id.tMin);
            rgDisplay = itemView.findViewById(R.id.rgDisplay);
        }
    }
}
