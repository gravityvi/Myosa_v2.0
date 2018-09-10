package com.example.ravi.myosa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class sectionRecyclerAdapter extends RecyclerView.Adapter<sectionRecyclerAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<EventAttributes> sectionItems;
    private ArrayList<sensorDetails.attr> attributes;
    public sectionRecyclerAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.event_section,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tLabel.setText(sensorDetails.eventName.get(position));
        holder.ritems.setLayoutManager(new LinearLayoutManager(context));
        sectionItems = new ArrayList<>();
        attributes = new ArrayList<>();
        for(int i=0;i<sensorDetails.eventAttributes.get(position).length;i++)
        {
            if(sensorDetails.eventAttributes.get(position)[i].selected)
            {
                sectionItems.add(sensorDetails.eventAttributes.get(position)[i]);
                attributes.add(sensorDetails.SensorAttributes.get(i));
            }
        }
        holder.ritems.setAdapter(new eventItemsRecyclerAdapter(context,sectionItems,attributes));
        holder.ritems.addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));

    }

    @Override
    public int getItemCount() {
        return sensorDetails.evntCreated;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tLabel;
        RecyclerView ritems;
        public ViewHolder(View itemView) {
            super(itemView);
            tLabel = itemView.findViewById(R.id.tLabel);
            ritems=itemView.findViewById(R.id.rItems);
        }
    }
}
