package com.example.xysm.bjcolor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends base  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        findViewById(R.id.tv).setOnClickListener(new NoDoubleClickListener() {
//            @Override
//            protected void onNoDoubleClick(View v) {
//
//            }
//        });


        onNoDoubleClick(findViewById(R.id.tv));
        findViewById(R.id.tv2).setOnClickListener(this);


//        findViewById(R.id.tv).setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        break;
//                    case MotionEvent.ACTION_UP:
//                    case MotionEvent.ACTION_CANCEL:
//
//                        break;
//                }
//
//                return false;
//            }
//        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv:
                Toast.makeText(this,"tv1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv2:
                Toast.makeText(this,"tv2",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //    //    进入蒙层
//    private void mTime() {
//        subscribe = Observable.timer(20, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Long>() {
//                    @Override
//                    public void call(Long aLong) {
//
//                    }
//                });
//
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (subscribe != null) {
//            subscribe.unsubscribe();
//        }
//    }


}
