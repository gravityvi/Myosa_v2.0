package com.example.ravi.myosa;


import java.util.ArrayList;

public class EventAttributes {

    boolean selected;
    String Attribute;
    int max;
    int min;
    boolean inclusive;
    String s;
    public EventAttributes()
    {

    }
    public EventAttributes(boolean selected, String attribute, int max, int min, boolean inclusive, String s) {
        this.selected = selected;
        Attribute = attribute;
        this.max = max;
        this.min = min;
        this.inclusive = inclusive;
        this.s = s;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getAttribute() {
        return Attribute;
    }

    public void setAttribute(String attribute) {
        Attribute = attribute;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public boolean isInclusive() {
        return inclusive;
    }

    public void setInclusive(boolean inclusive) {
        this.inclusive = inclusive;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
