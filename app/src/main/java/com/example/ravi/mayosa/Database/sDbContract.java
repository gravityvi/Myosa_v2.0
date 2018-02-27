package com.example.ravi.mayosa.Database;

import android.provider.BaseColumns;

/**
 * Created by Pratik on 27-02-2018.
 */

public class sDbContract {
    static final String SQL_CREATE_BTP_TABLE =
            "CREATE TABLE IF NOT EXISTS " + BtpEntry.TABLE_NAME
                    + " ("
                    + BtpEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + BtpEntry.COLUMN_TIME + " VARCHAR (30) ,"
                    + BtpEntry.COLUMN_TEMPERATURE + " REAL , "
                    + BtpEntry.COLUMN_PRESSURE_MB + " REAL , "
                    + BtpEntry.COLUMN_PRESSURE_MMH + " REAL , "
                    + BtpEntry.COLUMN_HUMIDITY + " REAL "
                    + BtpEntry.COLUMN_LUX + "REAL , "
                    + BtpEntry.COLUMN_INFRARED + "REAL , "
                    + BtpEntry.COLUMN_VISIBILITY + "REAL , "
                    + BtpEntry.COLUMN_GYROX + "REAL , "
                    + BtpEntry.COLUMN_GYROY + "REAL , "
                    + BtpEntry.COLUMN_GYROZ + "REAL , "
                    + BtpEntry.COLUMN_MAGNX + "REAL , "
                    + BtpEntry.COLUMN_MAGNY + "REAL , "
                    + BtpEntry.COLUMN_MAGNZ + "REAL , "
                    + ")";

    static final String SQL_DELETE_BTP_TABLE = "DROP TABLE IF EXISTS " + BtpEntry.TABLE_NAME;

    private sDbContract() {}

    public static class BtpEntry implements BaseColumns {
        public static final String TABLE_NAME = "MTable";
        public static final String COLUMN_TIME = "Time";
        public static final String COLUMN_TEMPERATURE = "Temperature";
        public static final String COLUMN_PRESSURE_MB = "Pressurembar";
        public static final String COLUMN_PRESSURE_MMH = "Pressuremmh";
        public static final String COLUMN_HUMIDITY = "Humidity";
        public static final String COLUMN_LUX = "Lux";
        public static final String COLUMN_INFRARED = "Infrared";
        public static final String COLUMN_VISIBILITY = "Visibility";
        public static final String COLUMN_GYROX = "GyroX";
        public static final String COLUMN_GYROY = "GyroY";
        public static final String COLUMN_GYROZ = "GyroZ";
        public static final String COLUMN_MAGNX = "GyroX";
        public static final String COLUMN_MAGNY = "GyroY";
        public static final String COLUMN_MAGNZ = "GyroZ";
    }
}
