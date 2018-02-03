package com.example.xysm.bjcolor.newOrder.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.xysm.bjcolor.newOrder.base.BaseUiChildFragment;
import com.example.xysm.bjcolor.newOrder.other.ChildView;
import com.example.xysm.bjcolor.newOrder.other.OrderEnum;
import com.example.xysm.bjcolor.newOrder.presenter.ChildPrsenter;
import com.example.xysm.bjcolor.newOrder.view.IChild;

import java.util.List;

/**
 * Created by XYSM on 2018/1/31.
 */

public class ChildFragment extends BaseUiChildFragment implements IChild {

    private OrderEnum mType;
    private ChildPrsenter mChildePresenter;


    @Override
    protected void setup(View rootView, @Nullable Bundle savedInstanceState) {
        mChildePresenter = new ChildPrsenter();
        mChildePresenter.setView(this);

        initData();


    }

    private void initData() {
        if (mType == OrderEnum.onlineall) {
            mChildePresenter.getData1();
        } else if (mType == OrderEnum.daifahuo) {
            mChildePresenter.getData2();
        } else if (mType == OrderEnum.daishouhuo) {
            mChildePresenter.getData3();
        } else if (mType == OrderEnum.yiwancheng) {
            mChildePresenter.getData4();
        } else if (mType == OrderEnum.lineall) {
            mChildePresenter.getData5();
        } else if (mType == OrderEnum.weixin) {
            mChildePresenter.getData6();
        } else if (mType == OrderEnum.diannei) {
            mChildePresenter.getData7();
        }
    }

    public Fragment initconfig(OrderEnum type) {
        mType = type;
        return this;
    }

    @Override
    public void onSuccess(List<String> s) {
        new ChildView(list, s);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mChildePresenter.onDestory();
    }
}