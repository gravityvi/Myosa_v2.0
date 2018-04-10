package com.example.ravi.myosa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

/**
 * Created by ravi on 05-04-2018.
 */

public class DialogRecyclerAdapter extends RecyclerView.Adapter<DialogRecyclerAdapter.ViewHolder> {

    private LayoutInflater inflator;
    private Context context;


    public DialogRecyclerAdapter(Context context) {

        this.context=context;
        inflator=LayoutInflater.from(context);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.dialog_recycler,parent,false);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.cSensor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    holder.LinearGone.setVisibility(View.VISIBLE);
                }
                else
                {
                    holder.LinearGone.setVisibility(View.GONE);
                }
            }
        });

    }



    @Override
    public int getItemCount() {
        return 2;
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout LinearGone;
        CheckBox cSensor;

        public ViewHolder(View itemView) {
            super(itemView);
            LinearGone=itemView.findViewById(R.id.LinearGone);
            cSensor=itemView.findViewById(R.id.cSensor);


        }
    }
}
