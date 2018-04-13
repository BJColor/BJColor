package com.example.obserandservice;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import static com.example.obserandservice.ObserService.NOTIFICATION_ID;

public class ObserInnerService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(NOTIFICATION_ID, new Notification());
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
}
