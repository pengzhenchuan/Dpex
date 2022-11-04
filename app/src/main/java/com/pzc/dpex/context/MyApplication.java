package com.pzc.dpex.context;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    //全局Context
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
