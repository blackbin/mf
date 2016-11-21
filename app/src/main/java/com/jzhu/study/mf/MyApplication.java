package com.jzhu.study.mf;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by zhujian on 2016/11/20.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }
}
