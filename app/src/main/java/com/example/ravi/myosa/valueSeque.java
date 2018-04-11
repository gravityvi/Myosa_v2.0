package com.example.ravi.myosa;

import android.util.Log;


import java.util.ArrayList;

/**
 * Created by Pratik on 27-02-2018.
 */

public class valueSeque {
    public static int data_read=0;
    private static ArrayList<String[]> values=new ArrayList<>();


    public static void addRecord(String[] rcved){
        //valueRecord.add(new DataRecord(rcved));
        values.add(rcved);
        data_read++;
    }


    public static ArrayList<String[]> getValues(){return values;}
}