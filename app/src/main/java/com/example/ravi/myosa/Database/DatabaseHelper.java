package com.example.ravi.mayosa.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import com.ajts.androidmads.library.SQLiteToExcel;

import java.io.File;

/**
 * Created by ravi on 04-04-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="SensorData.db";
    private static final String TABLE_NAME="Sensors";
    private static final String COL_1="_id";
    private static String[] SensorNames;
    private static Context context;


    public DatabaseHelper(Context context,String[] SensorNames) {
        super(context, DATABASE_NAME, null, 1);
        this.SensorNames=SensorNames;
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME+ "("+COL_1+"INTEGER PRIMARY KEY AUTOINCREMENT )");
        for(int i=0;i<SensorNames.length;i++)
        {
            db.execSQL("ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+SensorNames[i]+" VARCHAR(250) ");
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
                contentValues.put(SensorNames[i],"-1");
            }
            else
            {
                contentValues.put(SensorNames[i],s[i]);
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
