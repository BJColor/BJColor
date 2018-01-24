//package com.example.xysm.bjcolor;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//
//import com.example.xysm.bjcolor.bean.DemoBean;
//import com.example.xysm.bjcolor.presenter.base.DemoPresenter;
//import com.example.xysm.bjcolor.view.IDemo;
//
//import java.util.concurrent.TimeUnit;
//
//import rx.Observable;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.functions.Action1;
//
//
//public class MainActivity extends AppCompatActivity implements IDemo {
//
//    private DemoPresenter demoPresenter;
//    int i=1;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
////        demoPresenter = new DemoPresenter();
////        demoPresenter.setView(this);
////        demoPresenter.getDate();
//        findViewById(R.id.tv).setOnClickListener(new NoDoubleClickListener() {
//            @Override
//            protected void onNoDoubleClick(View v) {
//
//            }
//        });
//
//        //    进入蒙层
//    private void mTime() {
//        Observable.timer(20, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Long>() {
//                    @Override
//                    public void call(Long aLong) {
//
//                    }
//                });
//
//    }
////        subscribe = Observable.interval(2, 0, TimeUnit.SECONDS)
////                .subscribeOn(Schedulers.newThread())
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe(new Observer<Long>() {
////                    @Override
////                    public void onCompleted() {
////                    }
////                    @Override
////                    public void onError(Throwable throwable) {
////                    }
////                    @Override
////                    public void onNext(Long aLong) {
////                        if (aLong == 0) {
////                            tv_wine_pay.setEnabled(true);
////                        }
////                    }
////                });
//    }
//
//
//    @Override
//    public void onSuccess(DemoBean demoBean) {
//
//    }
//
//}
