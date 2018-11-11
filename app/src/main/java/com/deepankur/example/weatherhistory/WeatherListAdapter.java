package com.deepankur.example.weatherhistory;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deepankur.example.weatherhistory.data.Forecastday;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.MainViewHolder> {

    private Forecastday[] forecastdays;

    WeatherListAdapter(Forecastday[] forecastdays) {
        this.forecastdays = forecastdays;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_forecast, parent, false);
        return new MainViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        Forecastday forecastday = forecastdays[i];
        mainViewHolder.day.setText(formatDateToDay(Long.valueOf(forecastday.getDate_epoch())));
        mainViewHolder.temp.setText(forecastday.getDay().getAvgtemp_c() + " C");

    }

    private String formatDateToDay(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        Date dateFormat = new java.util.Date(date * 1000);
        return sdf.format(dateFormat);
    }

    @Override
    public int getItemCount() {
        return forecastdays.length;
    }

    public void setList(Forecastday[] forecastday) {
        this.forecastdays = forecastday;
        notifyDataSetChanged();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {
        View root;
        TextView day, temp;

        MainViewHolder(View view) {
            super(view);
            this.root = view;
            day = root.findViewById(R.id.day);
            temp = root.findViewById(R.id.temp);
            day.setTypeface(FontPicker.getRobotoRegular());
            temp.setTypeface(FontPicker.getRobotoRegular());
        }
    }
}
