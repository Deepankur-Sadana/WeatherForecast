package com.deepankur.example.weatherhistory.network;

import android.util.Pair;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class RequestManager {


    private RequestManager() {
        client = new OkHttpClient();
    }

    // avoid creating several instances, should be singleon
    private OkHttpClient client;

//    Request request = new Request.Builder()
//            .url("http://www.vogella.com/index.html")
//            .build();

    Request builWeatherRequest() {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(ApiConstants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("key", "63bf5624a4654f61bc5205856180811");
        urlBuilder.addQueryParameter("q", "delhi");
        urlBuilder.addQueryParameter("days", "3");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        return request;
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


    public void fetchWeatherData() throws IOException {
        Request request = builWeatherRequest();
        Response response = client.newCall(request).execute();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    // do something wih the result
                }
            }


        });
    }
}
