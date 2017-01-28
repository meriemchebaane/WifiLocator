package com.example.android.wifilocator;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by lenovo on 1/25/2017.
 */

public class AccessPoint {

    private String level;
    private LatLng location;

    //Constructors
    //Constructor 1
    public AccessPoint(){

    }

    //Constructor 2
    public AccessPoint(String level){

        this.level = level;
    }

    //Constructor 3
    public AccessPoint(String level, LatLng location){

        this.level = level;
        this.location = location;
    }

    //Getters
    public String getLevel() {
        return level;
    }

    public LatLng getLocation() {
        return location;
    }

    //Setters

    public void setLevel(String level) {
        this.level = level;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "AccessPoint{" +
                "level='" + level + '\'' +
                ", location=" + location +
                '}';
    }
}
