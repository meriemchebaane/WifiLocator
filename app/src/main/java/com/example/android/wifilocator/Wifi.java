package com.example.android.wifilocator;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class Wifi implements Serializable{
    private String user;
    private String SSID;
    private String BSSID;
    private String security;
    private String level;
    private LatLng location;


    //Constructors
    //Constructor 1
    public Wifi(){

    }

    //Constructor 2
    public Wifi(String SSID, String security, String level) {
        this.SSID = SSID;
        this.security = security;
        this.level = level;
    }

    //Constructor 3
    public Wifi(String SSID, String security, String level, String BSSID) {
        this.SSID = SSID;
        this.security = security;
        this.level = level;
        this.BSSID = BSSID;
    }


    //Getters
    public String getSSID() {
        return SSID;
    }

    public String getSecurity() {
        return security;
    }

    public String getLevel() {
        return level;
    }

    public String getBSSID(){ return BSSID; }

    public LatLng getLocation() {
        return location;
    }

    //Setters
    public void setUser(String user) {
        this.user = user;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public void setBSSID(String BSSID) {
        this.BSSID = BSSID;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setLocation(LatLng position) {
        this.location = position;
    }

    @Override
    public String toString() {
        return "Wifi{" +
                "user='" + user + '\'' +
                ", SSID='" + SSID + '\'' +
                ", BSSID='" + BSSID + '\'' +
                ", security='" + security + '\'' +
                ", level='" + level + '\'' +
                ", location=" + location +
                '}';
    }
}