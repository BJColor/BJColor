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
    private List<String> tabs = new ArrayList<>();
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
        tabs.add("新消息");
        tabs.add("朋友圈");
        tabs.add("公众号");
        fragments.add(new ParentTabFragment());
        fragments.add(new ParentTabFragment());
        fragments.add(new ParentTabFragment());
    }

    private void initView() {
        //设置TabLayout的模式
        parentTabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabAdapter = new ParentTabAdapter(getSupportFragmentManager(),fragments);
        parentViewPager.setAdapter(tabAdapter);
        //关联ViewPager和TabLayout
        parentTabLayout.setupWithViewPager(parentViewPager);
    }

    private void findId() {
        parentTabLayout = findViewById(R.id.parentTabLayout);
        parentViewPager = findViewById(R.id.parentViewPager);
    }
}
