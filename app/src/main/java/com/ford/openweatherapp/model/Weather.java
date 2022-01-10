package com.ford.openweatherapp.model;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("id")
    private int id;
    @SerializedName("main")
    private String main;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

    public Weather(int id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return "Weather{" +"\n"+
                "id=" + id +"\n"+
                "main='" + main + '\'' +"\n"+
                "description='" + description + '\'' +"\n"+
                "icon='" + icon + '\'' +"\n"+
                '}';
    }
}
