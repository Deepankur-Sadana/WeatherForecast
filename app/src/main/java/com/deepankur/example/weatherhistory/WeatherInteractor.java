package com.deepankur.example.weatherhistory;

import android.os.Handler;

import com.deepankur.example.weatherhistory.network.FetchWeatherTask;
import com.deepankur.example.weatherhistory.network.RequestManager;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class WeatherInteractor {

    interface OnWeatherApiCallFinishedListener {

        void onError();

        void onSuccess();
    }

    public void fecthData(final String location, final int days,final int cursorID, final OnWeatherApiCallFinishedListener listener) {

        FetchWeatherTask weatherTask = new FetchWeatherTask(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });
        weatherTask.execute();



//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                //noinspection ConstantConditions
//                if (data.equals("mockin .. ")) {
//                    listener.onError();
//                    return;
//                }
//                listener.onSuccess();
//            }
//        }, 400);
    }
}
