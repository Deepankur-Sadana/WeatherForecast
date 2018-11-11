package com.deepankur.example.weatherhistory.network;


import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.deepankur.example.weatherhistory.WeatherInteractor;
import com.deepankur.example.weatherhistory.data.WeatherData;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import java.io.IOException;

public class RequestManager {


    private RequestManager() {
        Log.d(TAG, "RequestManager: ................iiiiiii...");
        client = new OkHttpClient();
        mainHandler = new Handler(Looper.getMainLooper());
    }

    // avoid creating several instances, should be singleon
    private OkHttpClient client;


    private static Request builWeatherRequest() {
        String url = builWeatherRequest("Bangalore", 4).build().toString();
        return new Request.Builder()
                .url(url).get()
                .build();
    }

    public static HttpUrl.Builder builWeatherRequest(String region, int days) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(ApiConstants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("key", ApiConstants.APIKEY);
        urlBuilder.addQueryParameter("q", region);
        urlBuilder.addQueryParameter("days", String.valueOf(days));

        return urlBuilder;

    }

    private static RequestManager sRequestManager;


    public static RequestManager getInstance() {
        if (sRequestManager == null) {
            synchronized (RequestManager.class) {
                if (sRequestManager == null) {
                    synchronized (RequestManager.class) {
                        sRequestManager = new RequestManager();
                    }
                }
            }
        }
        return sRequestManager;
    }


    private final String TAG = RequestManager.class.getSimpleName();

    void fetchWeatherData(final WeatherInteractor.OnWeatherApiCallFinishedListener callback) throws IOException {
        Request request = builWeatherRequest();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onError();
            }

            @Override
            public void onResponse(Response response) {
                String mMessage = null;
                try {
                    mMessage = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                    onError(callback);
                    return;
                }
                if (response.isSuccessful()) {
                    try {
                        JSONObject serverResponse = new JSONObject(mMessage);
                        Gson gson = new Gson();
                        String jsonInString = String.valueOf(serverResponse);
                        WeatherData weatherData = gson.fromJson(jsonInString, WeatherData.class);
                        onSuccess(weatherData, callback);
                    } catch (Exception e) {
                        e.printStackTrace();
                        onError(callback);
                    }
                } else {
                    onError(callback);
                }
            }
        });
    }


    private void onSuccess(final WeatherData weatherData, final WeatherInteractor.OnWeatherApiCallFinishedListener callFinishedListener) {

        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                callFinishedListener.onSuccess(weatherData);
            }
        });
    }

    private void onError(final WeatherInteractor.OnWeatherApiCallFinishedListener callFinishedListener) {
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                callFinishedListener.onError();
            }
        });
    }

    private Handler mainHandler ;


}
