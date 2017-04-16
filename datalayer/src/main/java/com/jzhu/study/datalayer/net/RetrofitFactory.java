package com.jzhu.study.datalayer.net;

import com.jzhu.study.baselibrary.base.BaseApplication;
import com.jzhu.study.datalayer.common.Constant;
import com.jzhu.study.datalayer.net.interceptor.HttpInterceptor;
import com.jzhu.study.datalayer.net.interceptor.TimeoutIntercepter;
import com.readystatesoftware.chuck.ChuckInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitFactory {

    public static String BASE_URL = Constant.SERVER_ADDRESS;

    private static volatile RetrofitFactory sInstance;

    private Retrofit retrofit;

    private RetrofitFactory() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)      //访问主机地址
//                .addConverterFactory(FastJsonConverterFactory.create())  //解析方式
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(genericClient())
                .build();
    }

    public static RetrofitFactory getInstance() {
        if (null == sInstance) {
            synchronized (RetrofitFactory.class) {
                if (null == sInstance) {
                    sInstance = new RetrofitFactory();
                }
            }
        }
        return sInstance;
    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }

    private static HttpLoggingInterceptor initLoggingInterceptor() {
        HttpLoggingInterceptor
                httpLoggingInterceptor =
                new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    private static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(initLoggingInterceptor())
                .addInterceptor(new HttpInterceptor())
                .addInterceptor(new ChuckInterceptor(BaseApplication.getContext()))
//                .addInterceptor(new FakeInterceptor("/api/data/%E7%A6%8F%E5%88%A9/10/1", FakeInterceptor.mockJson()))
                .addInterceptor(new TimeoutIntercepter())
                .build();
        return httpClient;
    }

}


