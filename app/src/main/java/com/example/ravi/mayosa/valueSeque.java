package com.example.ravi.mayosa;

import android.util.Log;

import com.example.ravi.mayosa.Database.DataRecord;
import java.util.ArrayList;

/**
 * Created by Pratik on 27-02-2018.
 */

public class
valueSeque {
    private static ArrayList<DataRecord> valueRecord = new ArrayList<DataRecord>();
    public static void addRecord(DataRecord record){
        valueRecord.add(record);
<<<<<<< HEAD

=======
        Log.e("Warn",Integer.toString(valueRecord.size()));
>>>>>>> d932d42f40ccf5053fc7e538b324d85f9dd1c35b
    }

    public static ArrayList<DataRecord> getValueRecord(){
        return valueRecord;
    }
}