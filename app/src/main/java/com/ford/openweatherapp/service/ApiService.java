package com.ford.openweatherapp.service;

import com.ford.openweatherapp.models.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;

public interface ApiService {


    @GET("weather")
    Call<WeatherData> getInfo(@Query("q") String place,
                              @Query("units") String units,
                              @Query("appid") String apiKey);



}
