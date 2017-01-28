package com.example.android.wifilocator;

import java.util.List;

//Class of the objects that will be stored to and retrieved from the Firebase
public class SSID {

    private String ssid;
    private String security;
    private List<BSSID> bssidList;
    private String region;

    //Constructors
    //Constructor 1
    public SSID(){

    }

    //Constructor 2
    public SSID(String ssid){
        this.ssid = ssid;
    }

    //Constructor 3
    public SSID(String ssid, String security){

        this.ssid = ssid;
        this.security = security;
    }

    //Constructor 4
    public SSID(String ssid, String security, List<BSSID> bssidList){
        this.ssid = ssid;
        this.security = security;
        this.bssidList = bssidList;
    }

    //Constructor 5
    public SSID(String ssid, String security, List<BSSID> bssidList, String region){
        this.ssid = ssid;
        this.security = security;
        this.bssidList = bssidList;
        this.region = region;
    }

    //Getters
    public String getSSID() {
        return ssid;
    }

    public List<BSSID> getBssidList() {
        return bssidList;
    }

    public String getSecurity() {
        return security;
    }

    public String getRegion(){ return region; }

    //Setters
    public void setSSID(String ssid) {
        this.ssid = ssid;
    }

    public void setBssidList(List<BSSID> bssidList) {
        this.bssidList = bssidList;
    }

    public void setRegion(String region){ this.region = region; }
}
