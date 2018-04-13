package com.example.obserandservice;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ObserService extends Service {

    private int dayT;
    private int horT;
    private int minT;
    private int secT;
    private int totalT;
    private MyBind myBind;
    private ObserTest obserTest;
    private ScheduledExecutorService scheduledExecutorService;
    private int day = 86400;
    private int hour = 3600;
    private int min = 60;
    private int sec = 1;
    private int time;
    private int myTotal;
    public static final int NOTIFICATION_ID = 1008611112;
    private OpenMusic openMusic;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        getCurrentTime();
    }

    private void init() {
        myBind = new MyBind();
        obserTest = new ObserTest();
        openMusic = new OpenMusic(this);

    }

    private void getCurrentTime() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                obserTest.setCuttentTime(refFormatNowDate());
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public String refFormatNowDate() {
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        String retStrFormatNowDate = sdFormatter.format(nowTime);

        return retStrFormatNowDate;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(NOTIFICATION_ID, new Notification());
        Intent it = new Intent(this, ObserInnerService.class);
        startService(it);
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBind;
    }

    public class MyBind extends Binder implements TimeInterface {

        //获取obserTest实例
        public Observable getObservable() {
            return obserTest;
        }

        //获取obserTest实例
        @Override
        public void startTime(int d, int h, int m, int s) {
            countTime(countTotal(d, h, m, s));
        }

        @Override
        public void stop() {
            scheduledExecutorServiceIsAlive();
        }

        @Override
        public void reset() {
            scheduledExecutorServiceIsAlive();
            if (myTotal != 0)
                countTime(myTotal);
        }

        @Override
        public void goon() {
            if (totalT != 0)
                countTime(totalT);

        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        scheduledExecutorServiceIsAlive();
        stopSelf(NOTIFICATION_ID);
        openMusic.MusicDestory();
    }


    /**
     * @param d 天数
     * @param h 时间
     * @param m 分钟
     * @param s 秒
     *          <p>
     *          加起来的总秒数
     */
    private int countTotal(int d, int h, int m, int s) {
        if (d > 0) {
            if ((d * day) < (Integer.MAX_VALUE)) {
                dayT = d * day;
            }
        }
        if (h > 0) {
            horT = h * hour;
        }
        if (m > 0) {
            minT = m * min;
        }
        if (s > 0) {
            secT = s * sec;
        }
        totalT = dayT + horT + minT + secT;
        myTotal = this.totalT;
        return this.totalT;
    }

    private void countTime(int t) {
        time = t;
//            线程池实现时间倒计时
        if (scheduledExecutorService == null) {
            scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    Log.e("BJCOLOR:", "运行中.");
                    if (totalT == -1) {
                        scheduledExecutorServiceIsAlive();
                        openMusic.playMusic();
                        return;
                    }
                    obserTest.start(time--);
                    totalT = time;

                }
            }, 0, 1, TimeUnit.SECONDS);
        }
    }

    private void scheduledExecutorServiceIsAlive() {
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            scheduledExecutorService = null;
        }
    }
}
