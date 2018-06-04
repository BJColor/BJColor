package com.bjcolor.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;


public class SplshActivity extends Activity implements View.OnClickListener {
    /**
     * 加载图片ViewPager
     */
//    布局设置
    private Integer[] Layouts = {R.layout.splash_activity_lay1, R.layout.splash_activity_lay2, R.layout.splash_activity_lay3, R.layout.splash_activity_lay4};
    private Integer[] strings = {R.mipmap.guid1, R.mipmap.guid2, R.mipmap.guid3, R.mipmap.guid4};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_splash_index);
        AlphaView alphaview = findViewById(R.id.alphaview);
        alphaview.setPointGravity(Gravity.RIGHT);
        alphaview.setData(strings, Layouts);
        alphaview.setPoint(R.mipmap.new_press_dian, R.mipmap.new_normal_dian, 50, 50, 30, 40, 30, 1);
        alphaview.setSplashItemOnClick(this, R.layout.splash_activity_lay4, R.id.login, R.id.regist);

    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.login) {
            Toast.makeText(this, "登录", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.regist) {
            Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show();
        }
    }
}