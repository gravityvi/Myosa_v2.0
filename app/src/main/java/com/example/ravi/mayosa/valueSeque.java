package com.example.ravi.mayosa;

import android.util.Log;

import com.example.ravi.mayosa.Database.DataRecord;
import java.util.ArrayList;

/**
 * Created by Pratik on 27-02-2018.
 */

public class valueSeque {
    private static ArrayList<DataRecord> valueRecord = new ArrayList<DataRecord>();
    public static void addRecord(DataRecord record){
        valueRecord.add(record);
        Log.e("Warn",Integer.toString(valueRecord.size()));
    }

    public static ArrayList<DataRecord> getValueRecord(){
        return valueRecord;
    }
}