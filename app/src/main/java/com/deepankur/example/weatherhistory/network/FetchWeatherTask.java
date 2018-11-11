package com.deepankur.example.weatherhistory.network;

import android.os.AsyncTask;
import android.util.Log;

import com.deepankur.example.weatherhistory.WeatherInteractor;


import java.io.IOException;

public class FetchWeatherTask extends AsyncTask<Void, Void, Void> {
    private WeatherInteractor.OnWeatherApiCallFinishedListener callback;

    public FetchWeatherTask(WeatherInteractor.OnWeatherApiCallFinishedListener callback) {
        this.callback = callback;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        RequestManager requestManager = RequestManager.getInstance();
        try {
            requestManager.fetchWeatherData(callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void jsonObject) {
        super.onPostExecute(jsonObject);

    }
}
