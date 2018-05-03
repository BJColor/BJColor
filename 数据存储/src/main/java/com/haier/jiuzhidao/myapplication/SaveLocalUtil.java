package com.haier.jiuzhidao.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLocalUtil<T> {

    private final String spName;
    private final Context mContext;
    private final SharedPreferences mSharedPre;

    public SaveLocalUtil(Context context, String name) {
        mContext = context;
        spName = name;
        mSharedPre = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public void save(String key, Object object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectInputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectInputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String s = new String(Base64.encode(byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
        SharedPreferences.Editor edit = mSharedPre.edit();
        edit.putString(key, s);
        edit.commit();
    }


    public T get(String key) {
        T o = null;
        String objectString = mSharedPre.getString(key, null);
        if (objectString == null) {
            return null;
        }

        byte[] decode = Base64.decode(objectString.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            o = (T) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return o;
    }

}
