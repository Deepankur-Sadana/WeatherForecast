package com.deepankur.example.weatherhistory.network;

import android.os.AsyncTask;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;

import org.json.JSONObject;

import java.io.IOException;

public class FetchWeatherTask extends AsyncTask<Void, Void, JSONObject> {
    Callback callback;

    public FetchWeatherTask(Callback callback) {
        this.callback = callback;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected JSONObject doInBackground(Void... voids) {
        RequestManager requestManager = RequestManager.getInstance();
        try {
            requestManager.fetchWeatherData(callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
    }
}
