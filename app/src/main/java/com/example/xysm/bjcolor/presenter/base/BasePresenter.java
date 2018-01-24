package com.example.xysm.bjcolor.presenter.base;

/**
 * Created by XYSM on 2018/1/19.
 */

public class BasePresenter<T> {
    T mView ;
    public void setView(T view) {
        mView=view;
    }

    protected   T getView(){
        return mView;
    }


}
