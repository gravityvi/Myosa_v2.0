package com.example.ravi.myosa;

import java.util.ArrayList;

/**
 * Created by Pratik on 03-04-2018.
 */

public class sensorDetails {

    static int TOTAL_SENSORS = 0;
    ArrayList<Attributes> tiles;

    public sensorDetails(){
        this.tiles=new ArrayList<>();

        tiles.add(new Attributes("Real Time Clock", "Date","Time","Day",4));

        tiles.add(new Attributes("Luminousity Sensor","Visibility(Raw Data)", 1));
        tiles.add(new Attributes("Luminousity Sensor","Infrared (Raw Data)", 1));
        tiles.add(new Attributes("Luminousity Sensor","Illuminance(LUX)", 1));

        tiles.add(new Attributes("Berometric Pressure sensor","Temprature (\u00B0 C)", 1));
        tiles.add(new Attributes("Berometric Pressure sensor","Pressure (mbar)", 1));
        tiles.add(new Attributes("Berometric Pressure sensor","Pressure (mmHg)", 1));
        tiles.add(new Attributes("Berometric Pressure sensor","Altitude (meter)", 1));

        tiles.add(new Attributes("Air Quality Snensor","CO2 (ppm)", 1));
        tiles.add(new Attributes("Air Quality Snensor","TVOC (ppb)", 1));

        tiles.add(new Attributes("Particle Sensor","Heart Rate (BPM)", 1));
        tiles.add(new Attributes("Particle Sensor","Avg Heart Rate (BPM)", 1));
        tiles.add(new Attributes("Particle Sensor","Oxygenated blood (%)", 1));
        tiles.add(new Attributes("Particle Sensor","Presence Detection", 2));

        tiles.add(new Attributes("Magnetometer", "X (mgauss)", "Y (mgauss)", "Z (mgauss)", 3));

        tiles.add(new Attributes("RGB and Gesture Sensor", "Ambient Light (Raw data)",1));
        tiles.add(new Attributes("RGB and Gesture Sensor", "Gesture",2));
        tiles.add(new Attributes("RGB and Gesture Sensor", "Red (Raw data)", "Green (Raw data)", "Blue (Raw data)",3));

        tiles.add(new Attributes("MPU6050", "Gx (degree)","Gy (degree)","Gz (degree)",3));
        tiles.add(new Attributes("MPU6050", "Ax (m/(s)Square)","Ay (m/(s)Square)","Az (m/(s)Square)",3));

        tiles.add(new Attributes("Temperature and Pressure Sensor", "Temperature (\u00B0C)",1));
        tiles.add(new Attributes("Temperature and Pressure Sensor", "Temperature (\u00B0F)",1));
        tiles.add(new Attributes("Temperature and Pressure Sensor", "Humidity (%)",1));
    }
}
