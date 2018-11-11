package com.deepankur.example.weatherhistory;

import com.deepankur.example.weatherhistory.network.RequestManager;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RequestManagerTest {

    @Test
    public void urlIsCorrect() {
        HttpUrl.Builder builder = RequestManager.builWeatherRequest("Delhi",4);
        assertEquals("http://api.apixu.com/v1/forecast.json?&key=63bf5624a4654f61bc5205856180811&q=Delhi&days=4",
                builder.build().toString());
    }


    @Test
    public void singleTonCreatedOnce() {

        RequestManager requestManager = RequestManager.getInstance();
        assertEquals(requestManager,RequestManager.getInstance());
    }

}
