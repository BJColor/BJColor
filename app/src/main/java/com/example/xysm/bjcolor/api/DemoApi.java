package com.example.xysm.bjcolor.api;

import com.example.xysm.bjcolor.bean.DemoBean;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by XYSM on 2018/1/22.
 */

public interface DemoApi {

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("")
    Call<DemoBean> getActiveInfo(@Body RequestBody json);

}
