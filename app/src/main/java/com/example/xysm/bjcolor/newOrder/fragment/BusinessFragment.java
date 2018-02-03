package com.example.xysm.bjcolor.newOrder.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.xysm.bjcolor.newOrder.other.BusinessUiView;
import com.example.xysm.bjcolor.newOrder.other.ChildOrderUtils;
import com.example.xysm.bjcolor.newOrder.other.OrderEnum;
import com.example.xysm.bjcolor.newOrder.base.BaseUIFragment;


/**
 * Created by XYSM on 2018/1/31.
 */

public class BusinessFragment extends BaseUIFragment {

    private OrderEnum mType;

    @Override
    protected void setup(View rootView, @Nullable Bundle savedInstanceState) {
        super.setup(rootView, savedInstanceState);
        setFragment();
    }

    private void setFragment() {
        if (mType == OrderEnum.line) {
            new BusinessUiView(getChildFragmentManager(), childTabLayout, childViewPager, ChildOrderUtils.getLine());
        } else if (mType == OrderEnum.online) {
            new BusinessUiView(getChildFragmentManager(), childTabLayout, childViewPager, ChildOrderUtils.getOline());
        }
    }

    public Fragment initconfig(OrderEnum type) {
        mType = type;
        return this;
    }
}
