package com.ford.openweatherapp.recyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ford.openweatherapp.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView temperatureText;
    public TextView cityText;
    public TextView countryText;
    public ImageView imageIcon;
    public ConstraintLayout cardLayout;
    public TextView detailsText;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        temperatureText = itemView.findViewById(R.id.temperature_textView);
        cityText = itemView.findViewById(R.id.cityName_textView);
        countryText = itemView.findViewById(R.id.countryName_textView);
        imageIcon = itemView.findViewById(R.id.icon_imageView);
        cardLayout = itemView.findViewById(R.id.card_layout);
        detailsText=itemView.findViewById(R.id.details_Text);
    }
}
