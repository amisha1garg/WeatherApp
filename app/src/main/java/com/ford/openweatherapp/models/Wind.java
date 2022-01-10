package com.ford.openweatherapp.models;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    private double speed;
    @SerializedName("deg")
    private int degree;

    public Wind(double speed, int degree) {
        this.speed = speed;
        this.degree = degree;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "Wind{" +"\n"+
                "speed=" + speed +"\n"+
                "degree=" + degree +"\n"+
                '}';
    }
}
