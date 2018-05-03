package com.haier.jiuzhidao.md_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class AppBarLayoutMActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appbarlayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("这里是Title");
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
    }
}
