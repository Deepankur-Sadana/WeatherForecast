
package com.deepankur.example.weatherhistory;

import com.deepankur.example.weatherhistory.data.WeatherData;

public interface WeatherView {

    void showProgress();

    void hideProgress();

    void onDataError();

    void onWeatherDataFetched(WeatherData weatherData);
}
