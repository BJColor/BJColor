package com.example.obserandservice;

import java.util.Observable;

public class ObserTest extends Observable {

    private int day = 86400;
    private int hour = 3600;
    private int min = 60;
    private int sec = 1;

    public void start(int totalT) {

        String format = SecondToTime(totalT);
        String[] split = format.split(":");

        setChanged();
        notifyObservers(split);
    }

    private String SecondToTime(int totalT) {
        StringBuffer mTimeStr = new StringBuffer();
        int length = mTimeStr.length();
        mTimeStr.delete(0,length);
        //1天:1时:1分:1秒

        //天
        int mDay = totalT / day;
        int mDay_ = totalT % day;
        mTimeStr.append(mDay+"天:");

        //时
        int mHour = mDay_ / hour;
        int mHour_ = mDay_ % hour;
        mTimeStr.append(mHour+"时:");

        //分
        int mMin = mHour_ / min;
        int mMin_ = mHour_ % min;
        mTimeStr.append(mMin+"分:");


        //秒
        mTimeStr.append(mMin_+"秒");

        return mTimeStr.toString();

    }


    public void setCuttentTime(String s) {
        setChanged();
        notifyObservers(s);
    }
}
