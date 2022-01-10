package com.ford.openweatherapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ford.openweatherapp.R;
import com.ford.openweatherapp.model.WeatherData;
import com.ford.openweatherapp.recyclerView.MyAdapter;
import com.ford.openweatherapp.retrofit.MyRetrofit;
import com.ford.openweatherapp.service.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeScreenActivity extends AppCompatActivity {

    ApiService apiService;
    RecyclerView recyclerView;
    MyRetrofit myRetrofit = new MyRetrofit();
    Retrofit retrofit;
    MyAdapter adapter;
    ArrayList<WeatherData> weatherDataList;
    ArrayList<String> placesList = new ArrayList<String>();
    public Button addButton;
    public EditText addCityEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.addButton);
        addCityEditText = findViewById(R.id.editTextCityName);

        retrofit = myRetrofit.getRetrofit();
        apiService = retrofit.create(ApiService.class);
        populatePlacesList(placesList);
        populateWeatherDataList(placesList);


    }

    public void populatePlacesList(ArrayList<String> placesList) {
        placesList.add("Jind");
        placesList.add("Delhi");
        placesList.add("Chennai");
        placesList.add("Mumbai");
        placesList.add("Kolkata");
        placesList.add("London");
        placesList.add("Sydney");
        placesList.add("Melbourne");
        placesList.add("Seattle");
        placesList.add("Boston");
        placesList.add("Toronto");
        placesList.add("Berlin");
        placesList.add("Paris");
        placesList.add("New York");
        placesList.add("Bangkok");
        placesList.add("Hong Kong");
        placesList.add("Dubai");
        placesList.add("Rome");
        placesList.add("Singapore");
        placesList.add("SEOUL");
        placesList.add("Jakarta");
        placesList.add("Karachi");
        placesList.add("Moscow");
        placesList.add("Istanbul");
        placesList.add("MEXICO");
        placesList.add("TOKYO");
        placesList.add("Shanghai");
        placesList.add("BANGKOK");
        placesList.add("BEIJING");
        placesList.add("CAIRO");
        placesList.add("TEHRAN");
        placesList.add("BOGOTA");
        placesList.add("Bandung");
        placesList.add("Tianjin");
        placesList.add("LIMA");
        placesList.add("Lahore");
        placesList.add("Bogor");
        placesList.add("SANTIAGO");
        placesList.add("St Petersburg");
        placesList.add("Shenyang");
        placesList.add("Wuhan");
        placesList.add("Guangzhou");
        placesList.add("BAGHDAD");
        placesList.add("Pusan");
        placesList.add("Rio de Janeiro");
        placesList.add("Los Angeles");
        placesList.add("Yokohama");
        placesList.add("DHAKA");
        placesList.add("Alexandria");
        placesList.add("Bangalore");
        placesList.add("Malang");
        placesList.add("Hyderabad");
        placesList.add("Ho Chi Minh");
        placesList.add("Chongqing");
        placesList.add("BUENOS AIRES");
        placesList.add("Chengdu");
        placesList.add("Ahmedabad");
        placesList.add("Jinan");
        placesList.add("ADDIS ABABA");
        placesList.add("Taegu");
        placesList.add("Dalian");
        placesList.add("Zibo");
        placesList.add("YANGON");
        placesList.add("KIEV");
        placesList.add("Osaka");
        placesList.add("Taipei");
        placesList.add("ROMA");
        placesList.add("KINSHASA");
        placesList.add("Nanjing");
        placesList.add("PYONGYANG");
        placesList.add("Surabaya");
        placesList.add("MADRID");
        placesList.add("Xian");
        placesList.add("Chicago");
        placesList.add("Casablanca");
        placesList.add("Salvador");
        placesList.add("Inchon");
        placesList.add("Giza");
        placesList.add("Nagoya");
        placesList.add("Belo Horizonte");
        placesList.add("TASHKENT");
        placesList.add("Fortaleza");
        placesList.add("Sukabumi");
        placesList.add("Cali");
        placesList.add("Guayaquil");
        placesList.add("Qingdao");
        placesList.add("Izmir");
        placesList.add("Izmir");
        placesList.add("Cirebon");
        placesList.add("Taiyuan");
        placesList.add("BRASILIA");
        placesList.add("Faisalabad");
        placesList.add("Quezon City");
        placesList.add("Medan");
        placesList.add("Houston");
        placesList.add("Abidjan");
        placesList.add("Mashhad");
        placesList.add("Medellín");
        placesList.add("Kanpur");
        placesList.add("BUDAPEST");
    }

    public void populateWeatherDataList(ArrayList<String> placesList) {

        weatherDataList = new ArrayList<>();

        for (int i = 0; i < placesList.size(); i++) {
            Call<WeatherData> call = apiService.getInfo(placesList.get(i), "metric", "b07692ef67b682cb09800867a6639aee");

            call.enqueue(new Callback<WeatherData>() {
                @Override
                public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                    WeatherData data = response.body();
                    weatherDataList.add(data);
                }

                @Override
                public void onFailure(Call<WeatherData> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Invalid city name", Toast.LENGTH_LONG).show();
                }
            });
        }

        createRecyclerView();

    }

    private void createRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        adapter = new MyAdapter(this, weatherDataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void onClickAddButton(View view) {

        placesList.add(0, addCityEditText.getText().toString());
        populateWeatherDataList(placesList);
    }


}