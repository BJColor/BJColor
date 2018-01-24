package com.example.xysm.bjcolor;

import android.app.Application;

import com.example.libhttp.RetrofitNet;

/**
 * Created by XYSM on 2018/1/22.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
      RetrofitNet.getInstance();
    }
}
