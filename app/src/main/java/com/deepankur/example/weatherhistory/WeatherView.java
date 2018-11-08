
package com.deepankur.example.weatherhistory;

public interface WeatherView {

    void showProgress();

    void hideProgress();

    void onDataError();

    void onWeatherDataFetched();
}
