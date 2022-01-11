package com.ford.openweatherapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.ford.openweatherapp.R;

public class DetailsScreenActivity extends AppCompatActivity {

    public TextView detailsText;
    String data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);

        detailsText = findViewById(R.id.details_Text);

        getData();
        setData();

    }

    public void getData(){
        if(getIntent().hasExtra("weatherInfo"))
        {
            data1 = getIntent().getStringExtra("weatherInfo");
        }
        else {
            Toast.makeText(this,"No data",Toast.LENGTH_LONG).show();
        }
    }

    public void setData()
    {
        detailsText.setText(data1);
    }


}