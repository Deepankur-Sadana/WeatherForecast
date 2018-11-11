package com.deepankur.example.weatherhistory;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.deepankur.example.weatherhistory.data.WeatherData;

public class WeatherActivity extends AppCompatActivity implements WeatherView {

    WeatherPresenter weatherPresenter;
    RecyclerView recyclerView;
    WeatherListAdapter weatherListAdapter;
    View loader, retry, locatoionTemperatureView;
    TextView currentTemperatureTV, currentLocationTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FontPicker.init(this);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        weatherPresenter = new WeatherPresenter(this, new WeatherInteractor());
        loader = findViewById(R.id.loading);
        retry = findViewById(R.id.retry);
        currentTemperatureTV = findViewById(R.id.currentTemperatureTV);
        currentLocationTV = findViewById(R.id.currentLocation);

        currentLocationTV.setTypeface(FontPicker.getRobotoThin());
        currentTemperatureTV.setTypeface(FontPicker.getRobotoBlack());

        ((TextView) findViewById(R.id.went_wrong)).setTypeface(FontPicker.getRobotoThin());

        locatoionTemperatureView = findViewById(R.id.locatoionTemperatureView);
        findViewById(R.id.retryTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchWeatherData();
            }
        });
    }

    @Override
    public void showProgress() {
        loader.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loader.setVisibility(View.GONE);
    }


    @Override
    public void onDataError() {
        retry.setVisibility(View.VISIBLE);

    }

    @Override
    public void onWeatherDataFetched(final WeatherData weatherData) {
        refreshViews(weatherData);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchWeatherData();

    }

    private void fetchWeatherData() {
        weatherPresenter.fetchWeatherData();
    }

    final String TAG = WeatherActivity.class.getCanonicalName();


    @SuppressLint("SetTextI18n")
    void refreshViews(WeatherData weatherData) {
        Log.d(TAG, "refreshViews: " + weatherData);
        currentTemperatureTV.setText(weatherData.getCurrent().getFeelslike_c() + (char) 0x00B0);
        currentLocationTV.setText(weatherData.getLocation().getName());
        recyclerView.setTranslationY(locatoionTemperatureView.getMeasuredHeight() * 2f);
        recyclerView.animate().translationY(0).setDuration(800).start();
        retry.setVisibility(View.GONE);
        if (weatherListAdapter == null) {
            weatherListAdapter = new WeatherListAdapter(weatherData.getForecast().getForecastday());
            recyclerView.setAdapter(weatherListAdapter);
        } else {
            weatherListAdapter.setList(weatherData.getForecast().getForecastday());
        }
    }

}
