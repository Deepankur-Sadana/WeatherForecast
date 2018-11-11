package com.deepankur.example.weatherhistory;

import com.deepankur.example.weatherhistory.data.WeatherData;

public class WeatherPresenter implements WeatherInteractor.OnWeatherApiCallFinishedListener {

    private WeatherView weatherView;
    private WeatherInteractor weatherInteractor;

    WeatherPresenter(WeatherView weatherView, WeatherInteractor weatherInteractor) {
        this.weatherView = weatherView;
        this.weatherInteractor = weatherInteractor;
    }

    void fetchWeatherData() {
        if (weatherView != null) {
            weatherView.showProgress();
        }
        weatherInteractor.fecthData( this);
    }

    public void onDestroy() {
        weatherView = null;
    }


    @Override
    public void onError() {
        if (weatherView != null) {
            weatherView.hideProgress();
            weatherView.onDataError();
        }
    }

    @Override
    public void onSuccess(WeatherData weatherData) {
        if (weatherView != null) {
            weatherView.hideProgress();
            weatherView.onWeatherDataFetched(weatherData);
        }
    }
}
