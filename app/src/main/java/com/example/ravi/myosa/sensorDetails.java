package com.example.ravi.myosa;

import java.util.ArrayList;

/**
 * Created by Pratik on 03-04-2018.
 */

public class sensorDetails {
    

    static int TOTAL_SENSORS=9;
    static sensor[] allSensor;
    private String[] AllSensors;
    static ArrayList<Attributes> ttlAttributes = new ArrayList<>();

    public static void sensorInit(){
        allSensor=new sensor[TOTAL_SENSORS];
        String[] numOne = {"Visibility(Raw Data)","Infrared (Raw Data)","Illuminance(LUX)"};
        allSensor[0]=new sensor("Luminousity Sensor", numOne,null,null);
        numOne=null;

        String[] numTwo = {"Temprature (\u00B0 C)", "Pressure (mbar)", "Pressure (mmHg)", "Altitude (meter)"};
        allSensor[1]=(new sensor("Berometric Pressure sensor", numTwo, null,null));
        numTwo=null;

        String[] numThree = {"CO2 (ppm)", "TVOC (ppb)"};
        allSensor[2]=(new sensor("Air Quality Snensor", numThree, null,null));
        numThree=null;

        String[] numFour = {"Heart Rate (BPM)", "Avg Heart Rate (BPM)", "Oxygenated blood (%)"};
        String[] strFour = {"Presence Detection"};
        allSensor[3]=(new sensor("Particle Sensor", numFour, strFour,null));
        numFour=null;
        strFour=null;

        String[][] triFive = {{"X (mgauss)", "Y (mgauss)", "Z (mgauss)"}};
        allSensor[4]=(new sensor("Magnetometer", null,null, triFive));
        triFive=null;


        String[] numSix = {"Ambient Light (Raw data)"};
        String[] strSix = {"Gesture"};
        String[][] triSix = {{"Red (Raw data)", "Green (Raw data)", "Blue (Raw data)"}};
        allSensor[5]=(new sensor("RGB and Gesture Sensor", numSix, strSix, triSix));
        numSix=null;
        strSix=null;
        triSix=null;

        String[][] triSvn = {{"Gx (degree)","Gy (degree)","Gz (degree)"},{"Ax (m/(s)Square)","Ay (m/(s)Square)","Az (m/(s)Square)"}};
        allSensor[6]=(new sensor("MPU6050", null,null,triSvn));
        triSvn=null;

        String[] strEight = {"Date","Time","Day"};
        allSensor[7]=(new sensor("Real Time Clock",null,strEight,null));
        strEight=null;

        String[] strNine = {"Temperature (\u00B0C)", "Temperature (\u00B0F)", "Humidity (%)"};
        allSensor[8]=(new sensor("Temperature and Pressure Sensor", strNine,null,null));
        strNine=null;

        ///***********************************************/////


        for(int i=0;i<sensorDetails.TOTAL_SENSORS;i++){
            sensor curr_sensor = sensorDetails.allSensor[i];
            String[] numvalues = curr_sensor.getNumValues();
            String[] strvalues = curr_sensor.getStringValues();
            String[][] trivalues = curr_sensor.getTrinum();
            String head = curr_sensor.getSenosrName();

            if(curr_sensor.getTtlNumVlaues()!=0){
                for(int _i=0;_i<numvalues.length;i++){
                    ttlAttributes.add(new Attributes(head,numvalues[_i], true));
                }
            }
            if(curr_sensor.getTtlStringVal()!=0){
                for(int _i=0;_i<strvalues.length;i++){
                    ttlAttributes.add(new Attributes(head,strvalues[_i], false));
                }
            }
            if(curr_sensor.getTtlTriVal()!=0){
                for(int _i=0;_i<trivalues.length;i++){
                    for(int k=0;k<trivalues[_i].length;k++){
                        ttlAttributes.add(new Attributes(head,trivalues[_i][k], true));
                    }
                }
            }
        }
    }
}
