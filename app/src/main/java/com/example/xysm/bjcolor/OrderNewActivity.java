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
    }


    private void initData() {
        fragments.add(new ParentTabFragment("新消息"));
        fragments.add(new ParentTabFragment("朋友圈"));
        fragments.add(new ParentTabFragment("公众号"));
    }

    private void initView() {

        //tab可滚动
        parentTabLayout.setTabMode(TabLayout.MODE_FIXED);
        //tab居中显示
        parentTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabAdapter = new ParentTabAdapter(getSupportFragmentManager(), fragments);
        parentViewPager.setAdapter(tabAdapter);
        //关联ViewPager和TabLayout
        parentTabLayout.setupWithViewPager(parentViewPager);
        parentTabLayout.getTabAt(0).setText("新消息");
        parentTabLayout.getTabAt(1).setText("朋友圈");
        parentTabLayout.getTabAt(2).setText("公众号");
//        parentTabLayout.addTab(parentTabLayout.newTab().setText("新消息"));
//        parentTabLayout.addTab(parentTabLayout.newTab().setText("朋友圈"));
//        parentTabLayout.addTab(parentTabLayout.newTab().setText("公众号"));
    }

    private void findId() {
        parentTabLayout = findViewById(R.id.parentTabLayout);
        parentViewPager = findViewById(R.id.parentViewPager);
    }
}
