package com.jzhu.study.mf.data.net;


import com.jzhu.study.mf.common.Constant;
import com.jzhu.study.mf.data.net.fastjson.FastJsonConverterFactory;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public class RetrofitFactory {

    public static String BASE_URL = Constant.SERVER_ADDRESS;
    public static String BASE_URL_DEBUG = "";

    private static volatile RetrofitFactory sInstance;
    private Retrofit retrofit;
    private boolean isDebug = true;

    private RetrofitFactory() {
        if (isDebug) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)      //访问主机地址
                    .addConverterFactory(FastJsonConverterFactory.create())  //解析方式
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(genericClient())
                    .build();
        } else {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.SERVER_ADDRESS)      //访问主机地址
                    .addConverterFactory(FastJsonConverterFactory.create())  //解析方式
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(genericClient())
                    .build();
        }

    }

    public void changeServer(String address){
        retrofit = new Retrofit.Builder()
                .baseUrl(address)      //访问主机地址
                .addConverterFactory(FastJsonConverterFactory.create())  //解析方式
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


    //设置header相关的拦截器
    private static Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("charset", "UTF-8")
//                    .addHeader("Authorization", AppPrefsUtils.getString(Constant.KEY_SP_TOKEN))
//                    .addHeader("Request-Version","1.0")
                    .build();
            return chain.proceed(request);
        }
    };

    //设置Log相关的拦截器
    private static HttpLoggingInterceptor initLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    private static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                //上线前需要注释掉这个
                .addInterceptor(initLoggingInterceptor())
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(chain -> onOnIntercept(chain))
                .build();
        return httpClient;
    }

    private static Response onOnIntercept(Interceptor.Chain chain) throws IOException {
        Response response = null;
        try {
            response =  chain.proceed(chain.request());
        }
        catch (SocketTimeoutException exception) {
            exception.printStackTrace();
        }

        return response;
    }

}
