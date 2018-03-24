package com.example.ravi.mayosa;

import android.util.Log;

import com.example.ravi.mayosa.Database.DataRecord;
import java.util.ArrayList;

/**
 * Created by Pratik on 27-02-2018.
 */

public class
valueSeque {
    public static int data_read=0;
    private static ArrayList<String[]> values=new ArrayList<>();
    private static ArrayList<DataRecord> valueRecord = new ArrayList<DataRecord>();
    public static void addRecord(DataRecord record,String[] array){
        valueRecord.add(record);
        values.add(array);
        Log.e("Warn",Integer.toString(valueRecord.size()));

    }

    public static ArrayList<DataRecord> getValueRecord(){
        return valueRecord;
    }
    public static ArrayList<String[]> getValues(){return values;}
}