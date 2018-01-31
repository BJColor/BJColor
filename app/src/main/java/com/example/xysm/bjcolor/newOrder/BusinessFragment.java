package com.example.xysm.bjcolor.newOrder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.View;

import java.util.List;


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
        List<Pair<String, ? extends Fragment>> oline = ChildOrderUtils.getOline();
        List<Pair<String, ? extends Fragment>> line = ChildOrderUtils.getLine();
        if (mType == OrderEnum.line) {
            new BusinessUiView(getChildFragmentManager(),childTabLayout, childViewPager, ChildOrderUtils.getOline());
        } else if (mType == OrderEnum.online) {
            new BusinessUiView(getFragmentManager(), childTabLayout, childViewPager, ChildOrderUtils.getLine());
        }
    }

    public Fragment initconfig(OrderEnum type) {
         mType = type;
        return this;
    }
}
