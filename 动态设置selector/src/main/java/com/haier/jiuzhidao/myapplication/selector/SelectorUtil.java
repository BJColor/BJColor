package com.haier.jiuzhidao.myapplication.selector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.concurrent.ExecutionException;

/**
 * 动态设置 点击事件 selector 的工具类  可以从本地添加  也可以从网络添加
 * Created by suwenlai on 16-12-26.
 */

public class SelectorUtil {

    private static Context mContext;
    private static Drawable drawable;


    /**
     * 从 drawable 获取图片 id 给 Button 添加 selector
     *
     * @param context  调用方法的 Activity
     * @param idNormal 默认图片的 id
     * @param idPress  点击图片的 id
     * @param button   点击的 view
     */

    public static void addSelectorFromDrawable(Context context, int idNormal, int idPress, Button button) {

        StateListDrawable drawable = new StateListDrawable();
        Drawable normal = context.getResources().getDrawable(idNormal);
        Drawable press = context.getResources().getDrawable(idPress);
        drawable.addState(new int[]{android.R.attr.state_pressed}, press);
        drawable.addState(new int[]{-android.R.attr.state_pressed}, normal);
        button.setBackgroundDrawable(drawable);
    }

    /**
     * 从网络获取图片 给 ImageView 设置 selector
     *
     * @param clazz     调用方法的类
     * @param normalUrl 获取默认图片的链接
     * @param pressUrl  获取点击图片的链接
     * @param img       点击的 view
     * @param context
     */
    public static void addSeletorFromNet(final Class clazz, final String normalUrl, final String pressUrl, final ImageView img, Context context) {
        mContext = context;
        new AsyncTask<Void, Void, Drawable>() {
            @Override
            protected void onPreExecute() {

            }

            @Override
            protected Drawable doInBackground(Void... params) {

                StateListDrawable drawable = new StateListDrawable();
                Drawable normal = loadImageFromNet(clazz, normalUrl);
                Drawable press = loadImageFromNet(clazz, pressUrl);
                drawable.addState(new int[]{android.R.attr.state_pressed}, press);
                drawable.addState(new int[]{-android.R.attr.state_pressed}, normal);
                return drawable;
            }

            @Override
            protected void onPostExecute(Drawable drawable1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    img.setBackground(drawable1);
                }else{
                    img.setBackgroundDrawable(drawable1);
                }
            }
        }.execute();

    }

    /**
     * 从网络获取图片
     *
     * @param clazz  调用方法的类
     * @param netUrl 获取图片的链接
     * @return 返回一个 drawable 类型的图片
     */
    private static Drawable loadImageFromNet(Class clazz, String netUrl) {

        try {
            Bitmap myBitmap = Glide.with(mContext)
                    .load(netUrl)
                    .asBitmap()
                    .centerCrop()
                    .into(400, 400)
                    .get();

            drawable = new BitmapDrawable(mContext.getResources(), myBitmap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return drawable;
    }


}