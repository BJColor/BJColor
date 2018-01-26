package com.example.xysm.bjcolor;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Calendar;

/**
 * Created by XYSM on 2018/1/25.
 */

public class base extends AppCompatActivity implements View.OnClickListener {

    public static final int MIN_CLICK_DELAY_TIME = 2000;
    private long lastClickTime = 0;

    protected  void onNoDoubleClick(View v){
        onClick(v);
    }

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
        }
    }

    protected  void  setOnClickListener(){

    }

}
