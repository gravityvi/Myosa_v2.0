package com.example.ravi.myosa;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

/**
 * Created by ravi on 04-04-2018.
 */

public class EventManagement extends DialogFragment {
    private RecyclerView recyclerView;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());

        //Get Layout Inflator
        LayoutInflater inflater = getActivity().getLayoutInflater();
        //Pass null as the parent view because its goinf in the dialogue layout
        View dialogview=inflater.inflate(R.layout.event_management,null);
        recyclerView=dialogview.findViewById(R.id.rSesnsors);

        DialogRecyclerAdapter dialogRecyclerAdapter =new DialogRecyclerAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(dialogRecyclerAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL ));
        builder.setTitle("Event Management");
        builder.setView(dialogview);
        //Add  action Buttons
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(builder.getContext(),"It really works",Toast.LENGTH_SHORT);
            }
        });
        return builder.create();
    }
}
