package com.example.ravi.myosa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by ravi on 05-04-2018.
 */

public class DialogRecyclerAdapter extends RecyclerView.Adapter<DialogRecyclerAdapter.ViewHolder> {

    private LayoutInflater inflator;
    private Context context;
    private ArrayList<Attributes> ttlAttributes;

    public DialogRecyclerAdapter(Context context) {
        this.context=context;
        inflator=LayoutInflater.from(context);
        ttlAttributes=sensorDetails.ttlAttributes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.dialog_recycler,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.cSensor.setText(ttlAttributes.get(position).attName+" ("+ttlAttributes.get(position).head+")");
        holder.cSensor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    holder.LinearGone.setVisibility(View.VISIBLE);
                }
                else {
                    holder.LinearGone.setVisibility(View.GONE);
                }

            }
        });
        if(ttlAttributes.get(position).num)
        {
            holder.estring.setEnabled(false);
        }
        else
        {
            holder.emin.setEnabled(false);
            holder.emin.setEnabled(false);
        }

    }



    @Override
    public int getItemCount() {
        return sensorDetails.TOTAL_SENSORS;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout LinearGone;
        CheckBox cSensor;
        EditText emax;
        EditText emin;
        EditText estring;

        public ViewHolder(View itemView) {
            super(itemView);
            estring=itemView.findViewById(R.id.estring);
            emin=itemView.findViewById(R.id.emin);
            emax=itemView.findViewById(R.id.emax);
            LinearGone=itemView.findViewById(R.id.LinearGone);
            cSensor=itemView.findViewById(R.id.cSensor);


        }
    }

}
