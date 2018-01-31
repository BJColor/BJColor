//package com.example.xysm.bjcolor;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.design.widget.TabLayout;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v4.util.SparseArrayCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.text.TextUtils;
//
//import com.example.xysm.bjcolor.fragment.BaseFragment;
//import com.example.xysm.bjcolor.fragment.LineOrderFragment;
//import com.example.xysm.bjcolor.fragment.OnLineOrderFragment;
//import com.example.xysm.bjcolor.fragment.OrderListFragment;
//
///**
// * Created by XYSM on 2018/1/25.
// */
//
//public class OrderNewActivity extends AppCompatActivity {
//
//    private TabLayout parentTabLayout;
//    private String[] tabTitle = {"第一页面", "第二页面", "第三页面"};//每个页面顶部标签的名字
//    private FragmentManager mFragmentManager;
//    private SparseArrayCompat<Fragment> arrayCompat;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_order_new);
//        mFragmentManager = getSupportFragmentManager();
//        arrayCompat = new SparseArrayCompat<>();
//        arrayCompat.put(FragmentItemIndex.index1, new OnLineOrderFragment());
//        arrayCompat.put(FragmentItemIndex.index2, new LineOrderFragment());
//        arrayCompat.put(FragmentItemIndex.index3, new OrderListFragment());
//        findId();
//        initView();
//        tabOnClick();
//        showFragment(tabTitle[FragmentItemIndex.index1]);
//
//    }
//
//    private void tabOnClick() {
//        parentTabLayout.addOnTabSelectedListener(new TabSelectAdapter() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                String tag = (String) tab.getTag();
//                if (TextUtils.isEmpty(tag)) {
//                    return;
//                }
//                showFragment(tag);
//            }
//
//        });
//    }
//
////    private void sendToParent(CharSequence text, String tag) {
////        callFragment( text, tag);
////    }
//
//    Fragment onlineFragment, lineFragmetn, orderListFragment;
//
//    private void showFragment(String tag) {
//        FragmentTransaction transaction = mFragmentManager.beginTransaction();
//        hideFragments(transaction);
//
//        if (tag.equalsIgnoreCase(tabTitle[FragmentItemIndex.index1])) {
//            if (onlineFragment == null) {
//                onlineFragment = arrayCompat.get(FragmentItemIndex.index1);
//                transaction.add(R.id.container, onlineFragment, onlineFragment.getClass().getName());
//            } else {
//                transaction.show(onlineFragment);
//            }
//        } else if (tag.equalsIgnoreCase(tabTitle[FragmentItemIndex.index2])) {
//            if (lineFragmetn == null) {
//                lineFragmetn = arrayCompat.get(FragmentItemIndex.index2);
//                transaction.add(R.id.container, lineFragmetn, lineFragmetn.getClass().getName());
//            } else {
//                transaction.show(lineFragmetn);
//            }
//        } else if (tag.equalsIgnoreCase(tabTitle[FragmentItemIndex.index3])) {
//            if (orderListFragment == null) {
//                orderListFragment = arrayCompat.get(FragmentItemIndex.index3);
//                transaction.add(R.id.container, orderListFragment, orderListFragment.getClass().getName());
//            } else {
//                transaction.show(orderListFragment);
//            }
//        }
////        if (array == null) {
////            array = OrderFragmentFactory.get();
////        }
////        if (tag.equalsIgnoreCase(tabTitle[FragmentItemIndex.index1])) {
////            if (onlineFragment == null) {
////                onlineFragment = ComFragmentHelper.newFragment(array.valueAt(FragmentItemIndex.index1), null);
////                transaction.add(onlineFragment, onlineFragment.getClass().getName());
////            } else {
////                transaction.show(onlineFragment);
////            }
////        } else if (tag.equalsIgnoreCase(tabTitle[FragmentItemIndex.index2])) {
////            if (lineFragmetn == null) {
////                lineFragmetn = ComFragmentHelper.newFragment(array.valueAt(FragmentItemIndex.index2), null);
////                transaction.add(lineFragmetn, lineFragmetn.getClass().getName());
////            } else {
////                transaction.show(lineFragmetn);
////            }
////        } else if (tag.equalsIgnoreCase(tabTitle[FragmentItemIndex.index3])) {
////            if (orderListFragment == null) {
////                orderListFragment = ComFragmentHelper.newFragment(array.valueAt(FragmentItemIndex.index3), null);
////                transaction.add(orderListFragment, orderListFragment.getClass().getName());
////            } else {
////                transaction.show(orderListFragment);
////            }
////        }
//
//        transaction.commitAllowingStateLoss();
////        if (tag.equalsIgnoreCase(tabTitle[FragmentItemIndex.index1])) {
////            sendToParent(tag, OnLineOrderFragment.class.getName());
////        } else if (tag.equalsIgnoreCase(tabTitle[FragmentItemIndex.index2])) {
////            sendToParent(tag, LineOrderFragment.class.getName());
////        } else if (tag.equalsIgnoreCase(tabTitle[FragmentItemIndex.index3])) {
////            sendToParent(tag, OrderListFragment.class.getName());
////        }
//    }
//
//    private void hideFragments(FragmentTransaction transaction) {
//        if (onlineFragment != null) {
//            transaction.hide(onlineFragment);
//        }
//        if (lineFragmetn != null) {
//            transaction.hide(lineFragmetn);
//        }
//        if (orderListFragment != null) {
//            transaction.hide(orderListFragment);
//        }
//    }
//
//    private void initView() {
//        parentTabLayout.setTabMode(TabLayout.MODE_FIXED);
//        for (int i = 0; i < tabTitle.length; i++) {
//            parentTabLayout.addTab(parentTabLayout.newTab().setTag(tabTitle[i]).setText(tabTitle[i]));
//        }
//        parentTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        //设置顶部标签指示条的颜色和选中页面时标签字体颜色
//        parentTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#7CCD7C"));
//        parentTabLayout.setTabTextColors(Color.GRAY, Color.parseColor("#FF4081"));
//    }
//
//    private void findId() {
//        parentTabLayout = findViewById(R.id.parentTabLayout);
//    }
//
//    public void callFragment( Object t, String... tag) {
//        FragmentManager fm = getSupportFragmentManager();
//        Fragment fragment;
//        for (String item : tag) {
//            if (TextUtils.isEmpty(item)) {
//                continue;
//            }
//
//            fragment = fm.findFragmentByTag(item);
//            if (fragment != null && fragment instanceof BaseFragment) {
//                ((BaseFragment) fragment).call(t);
//            }
//        }
//    }
//
//}
//
//
////package com.example.xysm.bjcolor;
////
////import android.graphics.Color;
////import android.os.Bundle;
////import android.support.annotation.Nullable;
////import android.support.design.widget.TabLayout;
////import android.support.v4.app.Fragment;
////import android.support.v4.view.ViewPager;
////import android.support.v7.app.AppCompatActivity;
////
////import com.example.xysm.bjcolor.adapter.ParentTabAdapter;
////import com.example.xysm.bjcolor.fragment.ParentTabFragment;
////
////import java.util.ArrayList;
////import java.util.List;
////
/////**
//// * Created by XYSM on 2018/1/25.
//// */
////
////public class OrderNewActivity extends AppCompatActivity {
////
////    private TabLayout parentTabLayout;
//
//
//////    private ViewPager parentViewPager;
////    private List<Fragment> fragments = new ArrayList<>();
////    private ParentTabAdapter tabAdapter;
////    private String[] tabTitle = {"第一页面","第二页面","第三页面"};//每个页面顶部标签的名字
////    @Override
////    protected void onCreate(@Nullable Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_order_new);
////        findId();
////        initData();
////        initView();
////
////    }
////
////
////
////
////    private void initData() {
////        fragments.add(new ParentTabFragment());
////        fragments.add(new ParentTabFragment());
////        fragments.add(new ParentTabFragment());
////    }
////
////    private void initView() {
//////        //tab可滚动
////        parentTabLayout.setTabMode(TabLayout.MODE_FIXED);
//////        //tab居中显示
//////        parentTabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);
////        for (int i=0; i<tabTitle.length; i++) {
////            parentTabLayout.addTab(parentTabLayout.newTab().setText(tabTitle[i]));
////        }
////        parentTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
////        //设置顶部标签指示条的颜色和选中页面时标签字体颜色
////        parentTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#7CCD7C"));
////        parentTabLayout.setTabTextColors(Color.GRAY,Color.parseColor("#FF4081"));
////
////        //这里注意的是，因为我是在fragment中创建MyFragmentStatePagerAdapter，所以要传getChildFragmentManager()
////
////        parentViewPager.setAdapter(new ParentTabAdapter(getSupportFragmentManager(),fragments));
////        //在设置viewpager页面滑动监听时，创建TabLayout的滑动监听
////        parentViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(parentTabLayout));
////
////        parentTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
////            @Override
////            public void onTabSelected(TabLayout.Tab tab) {
////                //在选中的顶部标签时，为viewpager设置currentitem
////                parentViewPager.setCurrentItem(tab.getPosition());
////            }
////
////            @Override
////            public void onTabUnselected(TabLayout.Tab tab) {
////
////            }
////
////            @Override
////            public void onTabReselected(TabLayout.Tab tab) {
////
////            }
////        });
////
////
////
//////        //tab可滚动
//////        parentTabLayout.setTabMode(TabLayout.MODE_FIXED);
//////        //tab居中显示
//////        parentTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
//////        tabAdapter = new ParentTabAdapter(getSupportFragmentManager(), fragments);
//////        parentViewPager.setAdapter(tabAdapter);
//////        //关联ViewPager和TabLayout
//////        parentTabLayout.setupWithViewPager(parentViewPager);
//////        parentTabLayout.getTabAt(0).setText("新消息");
//////        parentTabLayout.getTabAt(1).setText("朋友圈");
//////        parentTabLayout.getTabAt(2).setText("公众号");
////    }
////
////    private void findId() {
////        parentTabLayout = findViewById(R.id.parentTabLayout);
////        parentViewPager = findViewById(R.id.parentViewPager);
////    }
////
////}
