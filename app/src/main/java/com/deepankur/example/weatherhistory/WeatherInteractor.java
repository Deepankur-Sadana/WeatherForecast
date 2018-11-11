package com.deepankur.example.weatherhistory;


import com.deepankur.example.weatherhistory.data.WeatherData;
import com.deepankur.example.weatherhistory.network.FetchWeatherTask;


public class WeatherInteractor {

    public interface OnWeatherApiCallFinishedListener {

        void onError();

        void onSuccess(WeatherData weatherData);
    }

    void fecthData(final OnWeatherApiCallFinishedListener listener) {

        FetchWeatherTask weatherTask = new FetchWeatherTask(new OnWeatherApiCallFinishedListener() {
            @Override
            public void onError() {
                listener.onError();
            }

            @Override
            public void onSuccess(WeatherData weatherData) {
                listener.onSuccess(weatherData);
            }
        });
        weatherTask.execute();
    }
}
