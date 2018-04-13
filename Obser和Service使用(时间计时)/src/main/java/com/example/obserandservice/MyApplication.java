package com.example.obserandservice;

import android.app.Application;
import android.content.Intent;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        开启服务
//        startService(new Intent(this,ObserService.class));
    }
}
