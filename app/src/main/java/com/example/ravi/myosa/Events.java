package com.example.ravi.myosa;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

public class Events extends DialogFragment {
    private RecyclerView rSections;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        Get Layout Inflator
        rSections = new RecyclerView(getContext());
        LayoutInflater inflater =  getActivity().getLayoutInflater();
        rSections.setLayoutManager(new LinearLayoutManager(getActivity()));
        rSections.setAdapter(new sectionRecyclerAdapter(getContext()));
        //Pass null as the parent view because its goinf in the dialogue layout
        builder.setView(rSections);
        builder.setTitle("Events Created");
        return builder.create();
    }
}
