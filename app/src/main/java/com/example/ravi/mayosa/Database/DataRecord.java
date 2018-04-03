package com.example.ravi.mayosa.Database;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Pratik on 26-02-2018.
 */

public class DataRecord {
    private long id;
    private String time;
    private String temp;
    private String press_mmhg;
    private String press_mbar;
    private String humidity;
    private String lux;
    private String infrared;
    private String visibility;
    private String gyroX;
    private String gyroY;
    private String gyroZ;
    private String magnX;
    private String magnY;
    private String magnZ;

    public DataRecord(String[] s){
        Date currentTime = Calendar.getInstance().getTime();
        time=currentTime.toString();
        temp = s[0];
        press_mmhg=s[1];
        press_mbar=s[2];
        humidity=s[3];
        lux=s[4];
        infrared = s[5];
        visibility = s[6];
        gyroX = s[7];
        gyroY = s[8];
        gyroZ = s[9];
        magnX = s[10];
        magnY = s[11];
        magnZ = s[12];
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPress_mmhg() {
        return press_mmhg;
    }

    public void setPress_mmhg(String press_mmhg) {
        this.press_mmhg = press_mmhg;
    }

    public String getPress_mbar() {
        return press_mbar;
    }

    public void setPress_mbar(String press_mbar) {
        this.press_mbar = press_mbar;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getLux() {
        return lux;
    }

    public void setLux(String lux) {
        this.lux = lux;
    }

    public String getInfrared() {
        return infrared;
    }

    public void setInfrared(String infrared) {
        this.infrared = infrared;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getGyroX() {
        return gyroX;
    }

    public void setGyroX(String gyroX) {
        this.gyroX = gyroX;
    }

    public String getGyroY() {
        return gyroY;
    }

    public void setGyroY(String gyroY) {
        this.gyroY = gyroY;
    }

    public String getGyroZ() {
        return gyroZ;
    }

    public void setGyroZ(String gyroZ) {
        this.gyroZ = gyroZ;
    }

    public String getMagnX() {
        return magnX;
    }

    public void setMagnX(String magnX) {
        this.magnX = magnX;
    }

    public String getMagnY() {
        return magnY;
    }

    public void setMagnY(String magnY) {
        this.magnY = magnY;
    }

    public String getMagnZ() {
        return magnZ;
    }

    public void setMagnZ(String magnZ) {
        this.magnZ = magnZ;
    }
}