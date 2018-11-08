package com.deepankur.example.weatherhistory;

public class WeatherPresenter implements WeatherInteractor.OnWeatherApiCallFinishedListener {

    private WeatherView weatherView;
    private WeatherInteractor loginInteractor;

    WeatherPresenter(WeatherView weatherView, WeatherInteractor loginInteractor) {
        this.weatherView = weatherView;
        this.loginInteractor = loginInteractor;
    }

    public void validateCredentials(String city, int days,int previousIndex) {
        if (weatherView != null) {
            weatherView.showProgress();
        }

        loginInteractor.fecthData(city, days,previousIndex, this);
    }

    public void onDestroy() {
        weatherView = null;
    }


    @Override
    public void onError() {

    }

    @Override
    public void onSuccess() {
        if (weatherView != null) {
            weatherView.onWeatherDataFetched();
        }
    }
}
