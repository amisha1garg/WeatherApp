package com.ford.openweatherapp.models;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private double temp;
    @SerializedName("feels_like")
    private double feelsLike;
    @SerializedName("temp_min")
    private double tempMin;
    @SerializedName("temp_max")
    private double tempMax;
    @SerializedName("pressure")
    private int pressure;
    @SerializedName("humidity")
    private int humidity;

    public Main(double temp, double feelsLike, double tempMin, double tempMax, int pressure, int humidity) {
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public String getTemp() {

        return Double.toString(temp)+"°C";
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "Main{" +"\n"+
                "temp=" + temp +"\n"+
                "feelsLike=" + feelsLike +"\n"+
                "tempMin=" + tempMin +"\n"+
                "tempMax=" + tempMax +"\n"+
                "pressure=" + pressure +"\n"+
                "humidity=" + humidity +"\n"+
                '}';
    }


}
