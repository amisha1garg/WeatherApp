package com.ford.openweatherapp.models;

import com.google.gson.annotations.SerializedName;

public class Clouds {
    @SerializedName("all")
    private int all;

    public Clouds(int all) {
        this.all = all;
    }

    public int getAll() {
        return all;
    }

    @Override
    public String toString() {
        return "Clouds" +"\n"+
                "all=" + all +"\n"
                ;
    }
}
