package com.example.ravi.myosa;

/**
 * Created by Pratik on 04-04-2018.
 */

public class sensor {
    private String sensorName;
    private int ttlNumVlaues;
    private int ttlStringVal;
    private int ttlTriVal;
    private String[] numValues;
    private String[] stringValues;
    private String[][] Trinum;

    public sensor(String name, String[] allNumValues, String[] allStringValues, String[][] allTriValues) {
        this.sensorName = name;
        try {
            this.numValues = allNumValues.clone();
            this.ttlNumVlaues = numValues.length;
        }
        catch (Exception e){
            this.ttlNumVlaues=0;
        }

        try {
            this.stringValues = allStringValues.clone();
            this.ttlStringVal = stringValues.length;
        } catch (Exception e) {
            this.ttlNumVlaues=0;
        }


        try {
            this.Trinum = allTriValues.clone();
            this.ttlTriVal = Trinum.length;
        } catch (Exception e) {
            this.ttlNumVlaues=0;
        }


    }

    public int getTtlTriVal() {
        return ttlTriVal;
    }

    public void setTtlTriVal(int ttlTriVal) {
        this.ttlTriVal = ttlTriVal;
    }

    public String[][] getTrinum() {

        return Trinum;
    }

    public void setTrinum(String[][] trinum) {
        Trinum = trinum;
    }

    public String getSenosrName() {
        return sensorName;
    }

    public void setSenosrName(String sensorName) {
        this.sensorName = sensorName;
    }

    public int getTtlNumVlaues() {
        return ttlNumVlaues;
    }

    public void setTtlNumVlaues(int ttlNumVlaues) {
        this.ttlNumVlaues = ttlNumVlaues;
    }

    public int getTtlStringVal() {
        return ttlStringVal;
    }

    public void setTtlStringVal(int ttlStringVal) {
        this.ttlStringVal = ttlStringVal;
    }

    public String[] getNumValues() {
        return numValues;
    }

    public void setNumValues(String[] numValues) {
        this.numValues = numValues;
    }

    public String[] getStringValues() {
        return stringValues;
    }

    public void setStringValues(String[] stringValues) {
        this.stringValues = stringValues;
    }
}
