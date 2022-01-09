package com.ford.openweatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Json {

    @SerializedName("coord")
    private Coordinates coordinates;
    @SerializedName("weather")
    private List<Weather> weather;
    @SerializedName("base")
    private String base;
    @SerializedName("main")
    private Main main;
    @SerializedName("visibility")
    private int visibility;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("dt")
    private int dt;
    @SerializedName("sys")
    private System system;
    @SerializedName("timezone")
    private int timeZone;
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("cod")
    private int cod;

    public Json(Coordinates coordinates, List<Weather> weather, String base, Main main, int visibility, Wind wind, Clouds clouds, int dt, System system, int timeZone, int id, String name, int cod) {
        this.coordinates = coordinates;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.system = system;
        this.timeZone = timeZone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public int getDt() {
        return dt;
    }

    public System getSys() {
        return system;
    }

    public int getTimeZone() {
        return timeZone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }

    @Override
    public String toString() {
        return
                "coordinates=" + coordinates +"\n"+
                " weather=" + weather +"\n"+
                " base='" + base + '\'' +"\n"+
                " main=" + main +"\n"+
                " visibility=" + visibility +"\n"+
                " wind=" + wind +"\n"+
                " clouds=" + clouds +"\n"+
                " dt=" + dt +"\n"+
                " system=" + system +"\n"+
                " timeZone=" + timeZone +"\n"+
                " id=" + id +"\n"+
                " name='" + name + '\'' +"\n"+
                " cod=" + cod +"\n";
    }
}
