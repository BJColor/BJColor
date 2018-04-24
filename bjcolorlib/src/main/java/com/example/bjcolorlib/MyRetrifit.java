package com.example.bjcolorlib;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public  class MyRetrifit {
    public static final String BASE_URL = "https://api.douban.com/v2/movie/";
    private static   MyRetrifit myRetrifit;
    private Retrofit retrofit;

    public static synchronized MyRetrifit getMyRetrifit(){
        if(myRetrifit==null){
            myRetrifit=new MyRetrifit();
        }
        return  myRetrifit;
    }

    private MyRetrifit() {
        init();
    }

    private void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private  Retrofit get() {
        return retrofit;
    }

    public static <T> T build(Class<T> convertClass, Object tag) {
        return getMyRetrifit().get().create(convertClass);
//        return (T) Proxy.newProxyInstance(convertClass.getClassLoader(),
//                new Class<?>[] {convertClass}, new Handler(tag));
    }


}
