package com.example.xysm.bjcolor.newOrder.presenter;

import com.example.xysm.bjcolor.newOrder.view.IChild;
import com.example.xysm.bjcolor.presenter.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYSM on 2018/2/1.
 */

public class ChildPrsenter extends BasePresenter<IChild> {


    public void getData1() {
        List<String> mratings =new ArrayList<>();
        for (int x = 0; x < 10; x++) {
            mratings.add(x + "-" + "线上全部");
        }
        getView().onSuccess(mratings);
    }
    public void getData2() {
        List<String> mratings =new ArrayList<>();
        for (int x = 0; x < 10; x++) {
            mratings.add(x + "-" + "待发货");
        }
        getView().onSuccess(mratings);
    }
    public void getData3() {
        List<String> mratings =new ArrayList<>();
        for (int x = 0; x < 10; x++) {
            mratings.add(x + "-" + "待收货");
        }
        getView().onSuccess(mratings);
    }
    public void getData4() {
        List<String> mratings =new ArrayList<>();
        for (int x = 0; x < 10; x++) {
            mratings.add(x + "-" + "已完成");
        }
        getView().onSuccess(mratings);
    }
    public void getData5() {
        List<String> mratings =new ArrayList<>();
        for (int x = 0; x < 10; x++) {
            mratings.add(x + "-" + "线下全部");
        }
        getView().onSuccess(mratings);
    }
    public void getData6() {
        List<String> mratings =new ArrayList<>();
        for (int x = 0; x < 10; x++) {
            mratings.add(x + "-" + "微信支付");
        }
        getView().onSuccess(mratings);
    }
    public void getData7() {
        List<String> mratings =new ArrayList<>();
        for (int x = 0; x < 10; x++) {
            mratings.add(x + "-" + "店内结算");
        }
        getView().onSuccess(mratings);
    }
}
