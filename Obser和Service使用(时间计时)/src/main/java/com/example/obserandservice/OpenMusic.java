package com.example.obserandservice;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

/**
 * 播放声音
 */
public class OpenMusic implements MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer;
    private Context mContext;

    public OpenMusic(Context context) {
        mContext = context;
    }

    public void playMusic() {
        Log.e("playMusic:", "playMusic");
        if (null == mediaPlayer) {
            mediaPlayer = MediaPlayer.create(mContext, R.raw.order);
        }
        mediaPlayer.setOnPreparedListener(this);
        try {
            mediaPlayer.prepare();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // prepare async to not block main thread
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        Log.e("playMusic:", "start");
        mediaPlayer.start();
    }


    public void MusicDestory() {
        if (null != mediaPlayer) {
            mediaPlayer.stop();
        }
    }
}

