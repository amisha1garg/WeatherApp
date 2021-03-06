package com.ford.openweatherapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ford.openweatherapp.R;
import com.ford.openweatherapp.models.WeatherData;
import com.ford.openweatherapp.recyclerView.MyAdapter;
import com.ford.openweatherapp.retrofit.MyRetrofit;
import com.ford.openweatherapp.service.ApiService;

import java.util.ArrayList;

import io.github.muddz.styleabletoast.StyleableToast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeScreenActivity extends AppCompatActivity {

    private ApiService apiService;
    private RecyclerView recyclerView;
    private MyRetrofit myRetrofit = new MyRetrofit();
    private Retrofit retrofit;
    private MyAdapter adapter;
    private ArrayList<WeatherData> weatherDataList = new ArrayList<>();
    private ArrayList<String> placesList = new ArrayList<String>();
    private Button addButton;
    private EditText addCityEditText;
    private static final String appId = "b07692ef67b682cb09800867a6639aee";
    private static final String units = "metric";
    private String newCity;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.addButton);
        addCityEditText = findViewById(R.id.editTextCityName);
        context = this;

        addCityEditText.addTextChangedListener(textWatcher);

        retrofit = myRetrofit.getRetrofit();
        apiService = retrofit.create(ApiService.class);
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

        newCity = addCityEditText.getText().toString();
        if (!placesList.contains(newCity.toLowerCase())) {

            Call<WeatherData> call = apiService.getInfo(newCity, units, appId);

            call.enqueue(new Callback<WeatherData>() {
                @Override
                public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                    WeatherData data = response.body();
                    if (data != null) {
                        placesList.add(0, newCity.toLowerCase());
                        weatherDataList.add(data);
                        adapter.notifyDataSetChanged();
                        StyleableToast.makeText(context, "City added successfully !", Toast.LENGTH_SHORT,R.style.myToast).show();
                    }
                    else{
                        StyleableToast.makeText(context, "Invalid city name", Toast.LENGTH_SHORT,R.style.myToast2).show();

                    }
                }

                @Override
                public void onFailure(Call<WeatherData> call, Throwable t) {
                    Toast.makeText(context, "Invalid city name", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            StyleableToast.makeText(this, "Already there !", Toast.LENGTH_SHORT,R.style.myToast).show();
        }
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String addCityEditInput = addCityEditText.getText().toString().trim();
            addButton.setEnabled(!addCityEditInput.isEmpty() );
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


}