package com.deepankur.example.weatherhistory;

import android.os.Handler;

import com.deepankur.example.weatherhistory.network.RequestManager;

import java.io.IOException;

public class WeatherInteractor {

    interface OnWeatherApiCallFinishedListener {

        void onError();

        void onSuccess();
    }

    public void fecthData(final String location, final int days,final int cursorID, final OnWeatherApiCallFinishedListener listener) {

        final String data = "some data";
        RequestManager requestManager = RequestManager.getInstance();
        try {
            requestManager.fetchWeatherData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //noinspection ConstantConditions
                if (data.equals("mockin .. ")) {
                    listener.onError();
                    return;
                }
                listener.onSuccess();
            }
        }, 400);
    }
}
