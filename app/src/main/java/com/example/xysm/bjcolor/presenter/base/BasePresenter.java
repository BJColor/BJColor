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
    /**
     * 在view销毁的时候调用
     */
    public void onDestory() {
        /*Net.get().cancel(getIdentifier());*/
        mView = null;
    }

}
