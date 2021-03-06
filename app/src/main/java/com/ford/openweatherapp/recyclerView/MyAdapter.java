package com.ford.openweatherapp.recyclerView;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ford.openweatherapp.R;
import com.ford.openweatherapp.activities.DetailsScreenActivity;
import com.ford.openweatherapp.models.WeatherData;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private View view;
    private List<WeatherData> weatherDataArrayList;
    private String imageBaseUrl= "https://openweathermap.org/img/wn/";
    private String imageUrl ;
    private String imageUrlEndPoint = "@2x.png";
    private String iconId;


    public MyAdapter(Context context, ArrayList<WeatherData> weatherDataArrayList) {
        this.context = context;
        this.weatherDataArrayList = weatherDataArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.weather_card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        WeatherData weatherData = weatherDataArrayList.get(position);
        holder.temperatureText.setText(weatherData.getMain().getTemp().toString()+"°C");
        holder.cityText.setText(weatherData.getName());
        holder.countryText.setText(weatherData.getSys().getCountry());
        iconId = weatherData.getWeather().get(0).getIcon();

        setImageIcon(holder,iconId);

        setOnClickListenerCard(holder,position);

    }

    @Override
    public int getItemCount() {
        return weatherDataArrayList.size();
    }



    public void setOnClickListenerCard(@NonNull MyViewHolder holder, int position){
        WeatherData weatherData = weatherDataArrayList.get(position);
         holder.cardLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailsScreenActivity.class);
            intent.putExtra("weatherInfo", weatherData.toString());
            context.startActivity(intent);
        });
    }

    public void setImageIcon(@NonNull MyViewHolder holder,  String iconId){
        imageUrl= imageBaseUrl+ iconId + imageUrlEndPoint;

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.mipmap.ic_launcher_round)
                .circleCrop();

        Glide.with(context)
                .load(imageUrl)
                .apply(options)
                .into(holder.imageIcon);
    }

}
