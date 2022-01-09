package com.ford.openweatherapp.model;

import com.google.gson.annotations.SerializedName;

public class System {

    @SerializedName("type")
    private int type;
    @SerializedName("id")
    private int id;
    @SerializedName("country")
    private String country;
    @SerializedName("sunrise")
    private int sunrise;
    @SerializedName("sunset")
    private int sunset;

    public System(int type, int id, String country, int sunrise, int sunset) {
        this.type = type;
        this.id = id;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    @Override
    public String toString() {
        return "System{" +"\n"+
                "type=" + type +"\n"+
                ", id=" + id +"\n"+
                ", country='" + country + '\'' +"\n"+
                ", sunrise=" + sunrise +"\n"+
                ", sunset=" + sunset +"\n"+
                '}';
    }
}
