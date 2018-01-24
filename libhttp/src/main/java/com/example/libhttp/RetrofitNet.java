package com.example.libhttp;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by BJColor on 2018/1/19.
 */

public class RetrofitNet {
    private static RetrofitNet mRetrofit;
    private OkHttpClient client;
    private Retrofit retrofit;

    private RetrofitNet() {
        init();
    }

    public static RetrofitNet getInstance() {
        if (mRetrofit == null) {
            return new RetrofitNet();
        }
        return mRetrofit;
    }


    public Retrofit init() {
        //设置 请求的缓存的大小跟位置
        File cacheFile = new File(App.get().getCacheDir(), "bjcolor");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50); //50Mb 缓存的大小
//添加缓存
        client = new OkHttpClient
                .Builder()
                .addInterceptor(addQueryParameterInterceptor())  //参数添加
                .addInterceptor(addHeaderInterceptor()) // token过滤
                .addInterceptor(new LoggingInterceptor()) //日志,所有的请求响应度看到 LoggingInterceptor
                .cache(cache)  //添加缓存
                .connectTimeout(60l, TimeUnit.SECONDS)
                .readTimeout(60l, TimeUnit.SECONDS)
                .writeTimeout(60l, TimeUnit.SECONDS)
                .build();

//        client.dispatcher().runningCalls().get(0).request().tag()

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.200.69:8080/linkcook/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;

    }

    /**
     * 设置公共参数
     */
    private static Interceptor addQueryParameterInterceptor() {
        Interceptor addQueryParameterInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request;
                HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                        // Provide your custom parameter here
//                        .addQueryParameter("phoneSystem", "")
//                        .addQueryParameter("phoneModel", "")
                        .build();
                request = originalRequest.newBuilder().url(modifiedUrl).build();
                return chain.proceed(request);
            }
        };
        return addQueryParameterInterceptor;
    }

    /**
     * 设置头
     */
    private static Interceptor addHeaderInterceptor() {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        // Provide your custom header here
//                        .header("token", (String) SpUtils.get("token", ""))
                        .method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        return headerInterceptor;
    }

    public static <T> T build(Class<T> convertClass) {
        return getInstance().get().create(convertClass);
//        return (T) Proxy.newProxyInstance(convertClass.getClassLoader(),
//                new Class<?>[] {convertClass}, new Handler(tag));
    }

    private Retrofit get() {
        return retrofit;
    }
}
