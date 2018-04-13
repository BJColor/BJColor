package com.example.obserandservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements Observer {

    private TextView tvDay, tvHour, tvMin, tvSec, tvCurrentTime;
    private ObserService.MyBind myBind;
    private EditText etDay;
    private EditText etHour;
    private EditText etMin;
    private EditText etSec;
    private String etDaytrim;
    private String etHourtrim;
    private String etMintrim;
    private String etSectrim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
//        绑定服务并进行操作 和startservice 不冲突
        bindService(new Intent(this, ObserService.class), serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void findId() {
        tvDay = findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMin = findViewById(R.id.tvMin);
        tvSec = findViewById(R.id.tvSec);
        tvCurrentTime = findViewById(R.id.tvCurrentTime);

        etDay = findViewById(R.id.etDay);
        etHour = findViewById(R.id.etHour);
        etMin = findViewById(R.id.etMin);
        etSec = findViewById(R.id.etSec);
    }


    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBind = (ObserService.MyBind) service;
            myBind.getObservable().addObserver(MainActivity.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    //  监听observer 是否有改变的回调
    @Override
    public void update(Observable o, final Object arg) {

        if (null != o) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String[] timeSplit = (String[]) arg;
                    tvDay.setText(timeSplit[0] + ":");
                    tvHour.setText(timeSplit[1] + ":");
                    tvMin.setText(timeSplit[2] + ":");
                    tvSec.setText(timeSplit[3] + ":");
                }
            });

        }
    }

    public void start(View view) {
        new EditTextUtils().isEdit(etDay, etHour, etMin, etSec);
        etDaytrim = etDay.getEditableText().toString().trim();
        etHourtrim = etHour.getEditableText().toString().trim();
        etMintrim = etMin.getEditableText().toString().trim();
        etSectrim = etSec.getEditableText().toString().trim();
        myBind.startTime(Integer.valueOf(etDaytrim), Integer.valueOf(etHourtrim), Integer.valueOf(etMintrim), Integer.valueOf(etSectrim));

    }

    public void stop(View view) {
        myBind.stop();
    }

    public void reset(View view) {
        myBind.reset();
    }

    public void Goon(View view) {
        myBind.goon();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
