//package com.example.xysm.bjcolor.fragment;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.design.widget.TabLayout;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.xysm.bjcolor.R;
//import com.example.xysm.bjcolor.newOrder.OrderNewActivity;
//
///**
// * Created by XYSM on 2018/1/25.
// */
//
//public abstract class ParentTabFragment extends BaseFragment {
//    private View inflate;
//    private TabLayout childTabLayout;
//    private ViewPager childViewPager;
//    private String t1;
//    private IfPositonCallBack ifPositonCallBack;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        inflate = LayoutInflater.from(getActivity()).inflate(R.layout.activity_order_parent,container,false);
//        findId();
//        initData();
//        initView();
//        return inflate;
//    }
//    protected abstract void initData() ;
//    protected abstract String[] setTitle() ;
//    protected abstract PagerAdapter setData();
//
//    private void initView() {
//        //tab可滚动
//        childTabLayout.setTabMode(TabLayout.MODE_FIXED);
////        //tab居中显示
////        childTabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);
//        for (int i=0; i<setTitle().length; i++) {
//            childTabLayout.addTab(childTabLayout.newTab().setText(setTitle()[i]));
//        }
//        childTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        //设置顶部标签指示条的颜色和选中页面时标签字体颜色
//        childTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#7CCD7C"));
//        childTabLayout.setTabTextColors(Color.GRAY,Color.parseColor("#FF4081"));
//
//        //这里注意的是，因为我是在fragment中创建MyFragmentStatePagerAdapter，所以要传getChildFragmentManager()
//
//        childViewPager.setAdapter(setData());
//        //在设置viewpager页面滑动监听时，创建TabLayout的滑动监听
//        childViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(childTabLayout));
//
//        childTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                //在选中的顶部标签时，为viewpager设置currentitem
//                childViewPager.setCurrentItem(tab.getPosition());
//                if(ifPositonCallBack!=null){
//                    ifPositonCallBack.position(tab.getPosition());
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//
////        //tab可滚动
////        childTabLayout.setTabMode(TabLayout.MODE_FIXED);
////
////        childTabLayout.addTab(childTabLayout.newTab().setText("Tab 1"));
////        childTabLayout.addTab(childTabLayout.newTab().setText("Tab 2"));
////        childTabLayout.addTab(childTabLayout.newTab().setText("Tab 3"));
////        childTabLayout.addTab(childTabLayout.newTab().setText("Tab 4"));
////
////        //tab居中显示
////        childTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
////        tabAdapter = new ChildTabAdapter(getChildFragmentManager(),fragments);
////        childViewPager.setAdapter(tabAdapter);
////        //关联ViewPager和TabLayout
////        childTabLayout.setupWithViewPager(childViewPager);
//
//    }
//
//
//
////    protected void sendToChild(Object text,String tag) {
////        if (getActivity() != null && getActivity() instanceof OrderNewActivity) {
////            ((OrderNewActivity) getActivity()).callFragment(getChildFragmentManager(),text, tag);
////        }
////    }
//
//    private void findId() {
//        childTabLayout = inflate.findViewById(R.id.childTabLayout);
//        childViewPager = inflate.findViewById(R.id.childViewPager);
//    }
//
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//    }
//
//
//    @Override
//    public void call(Object t) {
//    }
//
//    interface IfPositonCallBack{
//        void position(int position);
//    }
//
//    void setIfPositonCallBack(IfPositonCallBack i){
//        ifPositonCallBack = i;
//    }
//
//
////    protected void callFragment(FragmentManager fm, Object t, String... tag) {
////        Fragment fragment;
////        for (String item : tag) {
////            if (TextUtils.isEmpty(item)) {
////                continue;
////            }
////
////            fragment = fm.findFragmentByTag(item);
////            if (fragment != null && fragment instanceof BaseFragment) {
////                ((BaseFragment) fragment).call(t);
////            }
////        }
////    }
//
//
//    public void SendToFragment(String text,String tag) {
//        //举例
////        IndexFoodFragmentUpdateIds iff = new IndexFoodFragmentUpdateIds();
////        iff.setFood_definition_id(id1);
////        iff.setFood_name(id2);
//        if (getChildFragmentManager() != null && getActivity() instanceof OrderNewActivity) {
//            ((OrderNewActivity) getActivity()).callFragment(text, tag);
//        }
//    }
//}
