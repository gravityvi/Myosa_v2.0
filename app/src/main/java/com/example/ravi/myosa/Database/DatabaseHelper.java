package com.example.ravi.myosa.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.widget.Switch;

import com.ajts.androidmads.library.SQLiteToExcel;
import com.example.ravi.myosa.Attributes;
import com.example.ravi.myosa.sensorDetails;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by ravi on 04-04-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="SensorData.db";
    private static final String TABLE_NAME="Sensors";
    private static final String COL_1="_id";
    private static final sensorDetails sd=new sensorDetails();
    private static final ArrayList<String> SensorAttributes=new ArrayList<>();

    private static Context context;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME+ "("+COL_1+"INTEGER PRIMARY KEY AUTOINCREMENT )");
        int n;
        for(int i=0;i<sd.tiles.size();i++)
        {
            n=sd.tiles.get(i).getType();
            switch(n)
            {
                case 1: n=1;
                    db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+sd.tiles.get(i).getAttName()+" VARCHAR(250) ");
                    SensorAttributes.add(sd.tiles.get(i).getAttName());
                    break;
                case 2: n=1;
                    db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+sd.tiles.get(i).getAttName()+" VARCHAR(250) ");
                    SensorAttributes.add(sd.tiles.get(i).getAttName());
                    break;
                case 3: n=3;
                    db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+sd.tiles.get(i).getAtt1()+" VARCHAR(250) ");
                    db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+sd.tiles.get(i).getAtt2()+" VARCHAR(250) ");
                    db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+sd.tiles.get(i).getAtt3()+" VARCHAR(250) ");
                    SensorAttributes.add(sd.tiles.get(i).getAtt1());
                    SensorAttributes.add(sd.tiles.get(i).getAtt2());
                    SensorAttributes.add(sd.tiles.get(i).getAtt3());
                    break;
                case 4: n=3;
                    db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+sd.tiles.get(i).getAtt1()+" VARCHAR(250) ");
                    db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+sd.tiles.get(i).getAtt2()+" VARCHAR(250) ");
                    db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+sd.tiles.get(i).getAtt3()+" VARCHAR(250) ");
                    SensorAttributes.add(sd.tiles.get(i).getAtt1());
                    SensorAttributes.add(sd.tiles.get(i).getAtt2());
                    SensorAttributes.add(sd.tiles.get(i).getAtt3());
                        break;
            }

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public boolean InsertData(String s[])
    {
        ContentValues contentValues=new ContentValues();
        SQLiteDatabase db=getWritableDatabase();
        for(int i=0;i<s.length;i++)
        {
            if(s[i].equals("*"))
            {
                contentValues.put(SensorAttributes.get(i),"-1");
            }
            else
            {
                contentValues.put(SensorAttributes.get(i),s[i]);
            }

        }
        return true;
    }

    public void Export()
    {
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Backup/";

        File file = new File(directory_path);

        if (!file.exists()) {

            file.mkdirs();

        }

        SQLiteToExcel sqLiteToExcel=new SQLiteToExcel(context.getApplicationContext(),DATABASE_NAME,directory_path);

        sqLiteToExcel.exportAllTables("MyosaDatabase.xls", new SQLiteToExcel.ExportListener() {

            @Override
            public void onStart() {

            }

            @Override
            public void onCompleted(String filePath) {




            }



            @Override
            public void onError(Exception e) {

            }

        });

    }

}
