package com.deepankur.example.weatherhistory;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.Locale;

public class FontPicker {
    static Typeface robotoThin;
    static Typeface robotoBlack;
    static Typeface robotoRegular;
   public  static void init(Context context){
        AssetManager am = context.getApplicationContext().getAssets();

        robotoThin = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "Roboto_Thin.ttf"));

       robotoBlack = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "Roboto_Black.ttf"));


       robotoRegular = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "Roboto_Regular.ttf"));

    }

    public static Typeface getRobotoThin() {
        return robotoThin;
    }

    public static Typeface getRobotoBlack() {
        return robotoBlack;
    }
    public static Typeface getRobotoRegular() {
        return robotoRegular;
    }
}
