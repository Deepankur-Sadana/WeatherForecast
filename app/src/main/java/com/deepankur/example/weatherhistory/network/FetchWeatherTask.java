package com.deepankur.example.weatherhistory.network;

import android.os.AsyncTask;

import org.json.JSONObject;

public class FetchWeatherTask extends AsyncTask<Void, Void, JSONObject> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected JSONObject doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
    }
}
