package com.example.xysm.bjcolor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.xysm.bjcolor.adapter.ParentTabAdapter;
import com.example.xysm.bjcolor.fragment.ParentTabFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYSM on 2018/1/25.
 */

public class OrderNewActivity extends AppCompatActivity {

    private TabLayout parentTabLayout;
    private ViewPager parentViewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private ParentTabAdapter tabAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_new);
        findId();
        initData();
        initView();

//        findViewById(R.id.tv_touch).setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    Log.i("bjcolor", "--down");
//                }
//                if (event.getAction() == MotionEvent.ACTION_MOVE) {
//                    Log.i("bjcolor", "--move");
//                }
//                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    Log.i("bjcolor", "--up");
//                }
//                if (event.getAction() == MotionEvent.ACTION_CANCEL) {
//                    Log.i("bjcolor", "--cancel");
//                }
//                return true;
//            }
//        });
    }


    private void initData() {
        fragments.add(new ParentTabFragment());
        fragments.add(new ParentTabFragment());
        fragments.add(new ParentTabFragment());
    }

    private void initView() {
        //tab可滚动
        parentTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //tab居中显示
        parentTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabAdapter = new ParentTabAdapter(getSupportFragmentManager(), fragments);
        parentViewPager.setAdapter(tabAdapter);
        //关联ViewPager和TabLayout
        parentTabLayout.setupWithViewPager(parentViewPager);
        parentTabLayout.addTab(parentTabLayout.newTab().setText("新消息"));
        parentTabLayout.addTab(parentTabLayout.newTab().setText("朋友圈"));
        parentTabLayout.addTab(parentTabLayout.newTab().setText("公众号"));
    }

    private void findId() {
        parentTabLayout = findViewById(R.id.parentTabLayout);
        parentViewPager = findViewById(R.id.parentViewPager);
    }
}
