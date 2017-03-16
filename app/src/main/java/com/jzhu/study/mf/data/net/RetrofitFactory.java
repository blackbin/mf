package com.jzhu.study.mf.data.net;

import com.jzhu.study.mf.common.Constant;
import com.jzhu.study.mf.data.net.fastjson.FastJsonConverterFactory;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

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
        }
        else {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.SERVER_ADDRESS)      //访问主机地址
                    .addConverterFactory(FastJsonConverterFactory.create())  //解析方式
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(genericClient())
                    .build();
        }

    }

    public void changeServer(String address) {
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
                                   .addHeader("Content-Type",
                                              "application/json")
                                   .addHeader("charset", "UTF-8")
//                                   .addHeader("Authorization","")
//                                   .addHeader("Request-Version", "1.2")
//                                   .removeHeader("User-Agent")
//                                   .addHeader("User-Agent",
//                                              getUserAgent())
                                   .build();
            return chain.proceed(request);
        }
    };

    //设置Log相关的拦截器
    private static HttpLoggingInterceptor initLoggingInterceptor() {
        HttpLoggingInterceptor
                httpLoggingInterceptor =
                new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    private static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
//                .sslSocketFactory(getSSLCertifcation(BaseApplication.getContext()))
                .addInterceptor(initLoggingInterceptor())
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(chain -> onOnIntercept(chain))
                .build();
        return httpClient;
    }

    private static Response onOnIntercept(Interceptor.Chain chain) throws
                                                                   IOException {
        Response response = null;
        try {
            response = chain.proceed(chain.request());
        }
        catch (SocketTimeoutException exception) {
            exception.printStackTrace();
        }

        return response;
    }
//
//    private final static String CLIENT_PRI_KEY = "client.p12";
//
//    private final static String TRUSTSTORE_PUB_KEY = "server.bks";
//
//    private final static String CLIENT_BKS_PASSWORD = "smzc$%@45e3)";
//
//    private final static String TRUSTSTORE_BKS_PASSWORD = "smzc$%@45e3)";
//
//    private final static String KEYSTORE_TYPE = "BKS";
//
//    private final static String PROTOCOL_TYPE = "TLS";
//
//    private static final String KEY_STORE_TYPE_BKS = "bks";
//
//    private static final String KEY_STORE_TYPE_P12 = "PKCS12";
//
//    private final static String CERTIFICATE_FORMAT = "X509";
//
//    public static SSLSocketFactory getSSLCertifcation(Context context) {
//        SSLSocketFactory sslSocketFactory = null;
//        try {
//            // 服务器端需要验证的客户端证书，其实就是客户端的keystore
//            KeyStore
//                    keyStore =
//                    KeyStore.getInstance(KEY_STORE_TYPE_P12);// 客户端信任的服务器端证书
//            KeyStore
//                    trustStore =
//                    KeyStore.getInstance(KEY_STORE_TYPE_BKS);//读取证书
//            InputStream ksIn = context.getAssets().open(CLIENT_PRI_KEY);
//            InputStream
//                    tsIn =
//                    context.getAssets().open(TRUSTSTORE_PUB_KEY);//加载证书
//            keyStore.load(ksIn, CLIENT_BKS_PASSWORD.toCharArray());
//            trustStore.load(tsIn, TRUSTSTORE_BKS_PASSWORD.toCharArray());
//            ksIn.close();
//            tsIn.close();
//            //初始化SSLContext
//            SSLContext sslContext = SSLContext.getInstance(PROTOCOL_TYPE);
//            TrustManagerFactory
//                    trustManagerFactory =
//                    TrustManagerFactory.getInstance(CERTIFICATE_FORMAT);
//            KeyManagerFactory
//                    keyManagerFactory =
//                    KeyManagerFactory.getInstance(CERTIFICATE_FORMAT);
//            trustManagerFactory.init(trustStore);
//            keyManagerFactory.init(keyStore, CLIENT_BKS_PASSWORD.toCharArray());
//            sslContext.init(keyManagerFactory.getKeyManagers(),
//                            trustManagerFactory.getTrustManagers(),
//                            null);
//
//            sslSocketFactory = sslContext.getSocketFactory();
//
//        }
//        catch (CertificateException e) {
//            e.printStackTrace();
//        }
//        catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        catch (KeyStoreException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        catch (UnrecoverableKeyException e) {
//            e.printStackTrace();
//        }
//        catch (KeyManagementException e) {
//            e.printStackTrace();
//        }
//        return sslSocketFactory;
//    }
//
//    private static String getUserAgent() {
//        String userAgent = "";
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            try {
//                userAgent =
//                        WebSettings.getDefaultUserAgent(BaseApplication.getContext());
//            }
//            catch (Exception e) {
//                userAgent = System.getProperty("http.agent");
//            }
//        }
//        else {
//            userAgent = System.getProperty("http.agent");
//        }
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0, length = userAgent.length(); i < length; i++) {
//            char c = userAgent.charAt(i);
//            if (c <= '\u001f' || c >= '\u007f') {
//                sb.append(String.format("\\u%04x", (int) c));
//            }
//            else {
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }
}


