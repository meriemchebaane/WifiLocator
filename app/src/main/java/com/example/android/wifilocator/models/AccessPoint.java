package com.example.android.wifilocator.models;

/**
 * Created by lenovo on 1/25/2017.
 */

public class AccessPoint {

    private String level;
    private double lat;
    private double lng;

    //Constructors
    //Constructor 1
    public AccessPoint(){

    }

    //Constructor 2
    public AccessPoint(String level){

        this.level = level;
    }

    //Constructor 3
    public AccessPoint(String level, double lat, double lng){
        this.level = level;
        this.lat = lat;
        this.lng = lng;
    }

    //Getters
    public String getLevel() {
        return level;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

//Setters

    public void setLevel(String level) {
        this.level = level;
    }


    @Override
    public String toString() {
        return "AccessPoint{" +
                "level='" + level + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
