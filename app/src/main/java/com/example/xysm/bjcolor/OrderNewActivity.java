package com.example.xysm.bjcolor;

import android.graphics.Color;
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
    private String[] tabTitle = {"第一页面","第二页面","第三页面"};//每个页面顶部标签的名字
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_new);
        findId();
        initData();
        initView();

    }




    private void initData() {
        fragments.add(new ParentTabFragment());
        fragments.add(new ParentTabFragment());
        fragments.add(new ParentTabFragment());
    }

    private void initView() {
//        //tab可滚动
        parentTabLayout.setTabMode(TabLayout.MODE_FIXED);
//        //tab居中显示
//        parentTabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);
        for (int i=0; i<tabTitle.length; i++) {
            parentTabLayout.addTab(parentTabLayout.newTab().setText(tabTitle[i]));
        }
        parentTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //设置顶部标签指示条的颜色和选中页面时标签字体颜色
        parentTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#7CCD7C"));
        parentTabLayout.setTabTextColors(Color.GRAY,Color.parseColor("#FF4081"));

        //这里注意的是，因为我是在fragment中创建MyFragmentStatePagerAdapter，所以要传getChildFragmentManager()

        parentViewPager.setAdapter(new ParentTabAdapter(getSupportFragmentManager(),fragments));
        //在设置viewpager页面滑动监听时，创建TabLayout的滑动监听
        parentViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(parentTabLayout));

        parentTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //在选中的顶部标签时，为viewpager设置currentitem
                parentViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



//        //tab可滚动
//        parentTabLayout.setTabMode(TabLayout.MODE_FIXED);
//        //tab居中显示
//        parentTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
//        tabAdapter = new ParentTabAdapter(getSupportFragmentManager(), fragments);
//        parentViewPager.setAdapter(tabAdapter);
//        //关联ViewPager和TabLayout
//        parentTabLayout.setupWithViewPager(parentViewPager);
//        parentTabLayout.getTabAt(0).setText("新消息");
//        parentTabLayout.getTabAt(1).setText("朋友圈");
//        parentTabLayout.getTabAt(2).setText("公众号");
    }
    
    private void findId() {
        parentTabLayout = findViewById(R.id.parentTabLayout);
        parentViewPager = findViewById(R.id.parentViewPager);
    }

}
