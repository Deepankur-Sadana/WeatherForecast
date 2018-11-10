package com.deepankur.example.weatherhistory.network;

import org.json.JSONObject;

public interface INetworkResponse {

    void networkResponse(boolean success, JSONObject result);
}
