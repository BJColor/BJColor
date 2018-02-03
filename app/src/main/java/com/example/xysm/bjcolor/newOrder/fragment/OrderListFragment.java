package com.example.xysm.bjcolor.newOrder.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.xysm.bjcolor.R;
import com.example.xysm.bjcolor.fragment.BaseFragment;

/**
 * Created by XYSM on 2018/1/31.
 */

public class OrderListFragment extends BaseFragment{
    @Override
    protected void setup(View rootView, @Nullable Bundle savedInstanceState) {
        super.setup(rootView, savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_list;
    }
}
