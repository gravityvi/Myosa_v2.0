package com.example.ravi.mayosa;

import java.util.ArrayList;

/**
 * Created by Pratik on 03-04-2018.
 */

public class sensorDetails {
    static int TOTAL_SENSORS=8;
    static ArrayList<sensor> allSensor = new ArrayList<sensor>();

    public static void sensorInit(){
        String[] numOne = {"Visibility(Raw Data)","Infrared (Raw Data)","Illuminance(LUX)"};
        allSensor.add(new sensor("Luminousity Sensor", numOne,null,null));

        String[] numTwo = {"Temprature (\u00B0 C)", "Pressure (mbar)", "Pressure (mmHg)", "Altitude (meter)"};
        allSensor.add(new sensor("Berometric Pressure sensor", numTwo, null,null));

        String[] numThree = {"CO2 (ppm)", "TVOC (ppb)"};
        allSensor.add(new sensor("Air Quality Snensor", numThree, null,null));

        String[] numFour = {"Heart Rate (BPM)", "Avg Heart Rate (BPM)", "Oxygenated blood (%)"};
        String[] strFour = {"Presence Detection"};
        allSensor.add(new sensor("Particle Sensor", numFour, strFour,null));

        String[][] triFive = {{"X (mgauss)", "Y (mgauss)", "Z (mgauss)"}};
        allSensor.add(new sensor("Magnetometer", null,null, triFive));

        String[] numSix = {"Ambient Light (Raw data)"};
        String[] strSix = {"Gesture"};
        String[][] triSix = {{"Red (Raw data)", "Green (Raw data)", "Blue (Raw data)"}};
        allSensor.add(new sensor("RGB and Gesture Sensor", numSix, strSix, triSix));

        String[][] triSvn = {{"Gx (degree)","Gy (degree)","Gz (degree)"},{"Ax (m/(s)Square)","Ay (m/(s)Square)","Az (m/(s)Square)"}};
        allSensor.add(new sensor("MPU6050", null,null,triSvn));

        String[] strEight = {"Date","Time","Day"};
        allSensor.add(new sensor("Real Time Clock",null,strEight,null));

        String[] strNine = {"Temperature (\u00B0C)", "Temperature (\u00B0F)", "Humidity (%)"};
        allSensor.add(new sensor("Temperature and Pressure Sensor", strNine,null,null));
    }
}
