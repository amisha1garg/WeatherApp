package com.ford.openweatherapp.models;

import com.google.gson.annotations.SerializedName;

public class Coordinates {
    @SerializedName("lon")
    private double longitude;
    @SerializedName("lat")
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public Coordinates(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Coordinates{" +"\n"+
                "longitude=" + longitude +"\n"+
                "latitude=" + latitude +"\n"+
                '}';
    }
}
