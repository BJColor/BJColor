package com.haier.jiuzhidao.md_demo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    /**
     * Toolbar
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("这里是Title");
        toolbar.setSubtitle("这里是子标题");
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
    }

    /**
     *"AppBarLayout、Toolbar"
     * @param view
     */
    public void AppBarLayout(View view){
        startActivity(new Intent(this,AppBarLayoutMActivity.class));
    }
}
