package com.example.ravi.myosa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

/**
 * Created by ravi on 05-04-2018.
 */

public class DialogRecyclerAdapter extends RecyclerView.Adapter<DialogRecyclerAdapter.ViewHolder> {

    private LayoutInflater inflator;
    private Context context;
    private sensorDetails sd;

    public DialogRecyclerAdapter(Context context) {
        this.context=context;
        inflator=LayoutInflater.from(context);
        sd= new sensorDetails();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.dialog_recycler,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.cSensor.setText(sd.SensorAttributes.get(position));
        holder.cSensor.setOnCheckedChangeListener(null);
        holder.rg.setOnCheckedChangeListener(null);
        holder.cSensor.setChecked(sensorDetails.eventAttributes[position].selected);
        if(sensorDetails.eventAttributes[position].selected)
        {
            holder.LinearGone.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.LinearGone.setVisibility(View.GONE);
        }
        //i f condition for radio button selection.
        if(sensorDetails.eventAttributes[position].inclusive)
        {
            holder.rg.check(holder.inc.getId());
        }
        else
        {
            holder.rg.check(holder.exc.getId());
        }
        holder.cSensor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    sensorDetails.eventAttributes[position].selected=true;
                    holder.LinearGone.setVisibility(View.VISIBLE);
                }
                else {
                    sensorDetails.eventAttributes[position].selected=false;
                    holder.LinearGone.setVisibility(View.GONE);
                }

            }
        });
        holder.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                holder.rbId=checkedId;
                if(holder.exc.getId()==holder.rbId)
                {

                    sensorDetails.eventAttributes[position].inclusive=false;
                }
                else
                {

                    sensorDetails.eventAttributes[position].inclusive=true;
                }
            }
        });
        holder.bsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.emax.getText().toString().trim().equals(""))
                {
                    sensorDetails.eventAttributes[position].max=-1;
                }
                else
                {
                    sensorDetails.eventAttributes[position].max=Integer.parseInt(holder.emax.getText().toString());
                }
                if(holder.emin.getText().toString().trim().equals(""))
                {
                    sensorDetails.eventAttributes[position].min=-1;
                }
                else
                {
                    sensorDetails.eventAttributes[position].min=Integer.parseInt(holder.emin.getText().toString());
                }
                sensorDetails.eventAttributes[position].s=holder.estring.getText().toString();
            }
        });


    }



    @Override
    public int getItemCount() {
        return sd.SensorAttributes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout LinearGone;
        CheckBox cSensor;
        EditText emax;
        EditText emin;
        EditText estring;
        int rbId;
        RadioButton inc;
        RadioButton exc;
        RadioGroup rg;
        Button bsave;

        public ViewHolder(View itemView) {
            super(itemView);
            bsave=itemView.findViewById(R.id.bsave);
            inc= itemView.findViewById(R.id.cInclusive);
            exc=itemView.findViewById(R.id.cExclusive);
            estring=itemView.findViewById(R.id.estring);
            emin=itemView.findViewById(R.id.emin);
            emax=itemView.findViewById(R.id.emax);
            LinearGone=itemView.findViewById(R.id.LinearGone);
            cSensor=itemView.findViewById(R.id.cSensor);
            rg=itemView.findViewById(R.id.Rg);
        }
    }
}
