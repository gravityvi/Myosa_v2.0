package com.example.ravi.myosa;

/**
 * Created by Pratik on 04-04-2018.
 */

public class sensor {
    private String senosrName;
    private int ttlNumVlaues;
    private int ttlStringVal;
    private int ttlTriVal;
    private String[] numValues;
    private String[] stringValues;
    private String[][] Trinum;

    public sensor(String name, String[] allNumValues, String[] allStringValues, String[][] allTriValues) {
        this.senosrName = name;

        if (allNumValues == null) {
            this.ttlNumVlaues = 0;
        } else {
            this.numValues = allNumValues.clone();
            this.ttlNumVlaues = numValues.length;
        }

        if (allStringValues == null) {
            this.ttlStringVal = 0;
        } else {
            this.stringValues = allStringValues.clone();
            this.ttlStringVal = stringValues.length;
        }

        if (allStringValues == null) {
            this.ttlTriVal = 0;
        } else {
            this.Trinum = allTriValues.clone();
            this.ttlTriVal = Trinum.length;
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
        return senosrName;
    }

    public void setSenosrName(String senosrName) {
        this.senosrName = senosrName;
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
