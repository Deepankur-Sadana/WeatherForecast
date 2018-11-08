package com.deepankur.example.weatherhistory;

import android.os.Handler;

public class WeatherInteractor {

    interface OnWeatherApiCallFinishedListener {

        void onError();

        void onSuccess();
    }

    public void fecthData(final String location, final int days,final int cursorID, final OnWeatherApiCallFinishedListener listener) {

        final String data = "some data";
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
