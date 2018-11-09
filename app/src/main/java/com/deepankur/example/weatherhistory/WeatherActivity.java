package com.deepankur.example.weatherhistory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WeatherActivity extends AppCompatActivity implements WeatherView {

    WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherPresenter = new WeatherPresenter(this, new WeatherInteractor());
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }


    @Override
    public void onDataError() {

    }

    @Override
    public void onWeatherDataFetched() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchWeatherData();
    }

    private void fetchWeatherData() {
        weatherPresenter.fetchWeatherData("Delhi", 6, 12323);
    }
}
