package com.example.ravi.mayosa;

/**
 * Created by ravi on 14-02-2018.
 */

public class SensorObject {

    public String getSensorHead() {
        return SensorHead;
    }

    public void setSensorHead(String sensorHead) {
        SensorHead = sensorHead;
    }

    public String getAttribute() {
        return Attribute;
    }

    public void setAttribute(String attribute) {
        Attribute = attribute;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    private String SensorHead;
    private String Attribute;
    private String Value;

}
