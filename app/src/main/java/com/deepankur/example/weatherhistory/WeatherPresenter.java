package com.deepankur.example.weatherhistory;

public class WeatherPresenter implements WeatherInteractor.OnWeatherApiCallFinishedListener {

    private WeatherView weatherView;
    private WeatherInteractor weatherInteractor;

    WeatherPresenter(WeatherView weatherView, WeatherInteractor weatherInteractor) {
        this.weatherView = weatherView;
        this.weatherInteractor = weatherInteractor;
    }

    public void fetchWeatherData(String city, int days, int previousIndex) {
        if (weatherView != null) {
            weatherView.showProgress();
        }

        weatherInteractor.fecthData(city, days, previousIndex, this);
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
