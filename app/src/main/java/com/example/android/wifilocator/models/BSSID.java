package com.example.android.wifilocator.models;

/**
 * Created by Sherif Meimari on 1/25/2017.
 */

import java.util.List;

public class BSSID {

    private String bssid;
    private List<AccessPoint> accessPoints;

    //Constructors
    //Constructor 1
    public BSSID(){

    }

    //Constructor 2
    public BSSID(String bssid, List<AccessPoint> accessPoints){
        this.bssid = bssid;
        this.accessPoints = accessPoints;
    }

    //Getters
    public String getBSSID() {
        return bssid;
    }

    public List<AccessPoint> getAccessPoints() {
        return accessPoints;
    }

    //Setters
    public void setBSSID(String bssid) {
        this.bssid = bssid;
    }

    public void setAccessPoints(List<AccessPoint> accessPoints) {
        this.accessPoints = accessPoints;
    }
}
