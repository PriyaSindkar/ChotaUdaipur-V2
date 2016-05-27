package com.webmyne.base.base;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;


import com.webmyne.base.utils.Conts;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vaibhavirana on 23-03-2016.
 */
public class MyApplication extends Application {
    public static Retrofit retrofit;
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        retrofit = new Retrofit.Builder()
                .baseUrl(Conts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized MyApplication getInstance() {
        return sInstance;
    }
}
