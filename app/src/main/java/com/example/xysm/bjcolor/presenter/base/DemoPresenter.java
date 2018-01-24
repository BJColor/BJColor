package com.example.xysm.bjcolor.presenter.base;

import com.example.libhttp.RetrofitNet;
import com.example.xysm.bjcolor.api.DemoApi;
import com.example.xysm.bjcolor.bean.DemoBean;
import com.example.xysm.bjcolor.view.IDemo;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DemoPresenter extends BasePresenter<IDemo> {

    public void getDate() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("deviceId", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), jsonObject.toString());
        RetrofitNet.build(DemoApi.class).getActiveInfo(body).enqueue(new Callback<DemoBean>() {
            @Override
            public void onResponse(Call<DemoBean> call, Response<DemoBean> response) {
                getView().onSuccess(new DemoBean());
            }

            @Override
            public void onFailure(Call<DemoBean> call, Throwable t) {

            }
        });

    }
}
