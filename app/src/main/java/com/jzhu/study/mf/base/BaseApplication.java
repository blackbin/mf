package com.jzhu.study.mf.base;

import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.jzhu.study.mf.injection.component.ApplicationComponent;
import com.jzhu.study.mf.injection.component.DaggerApplicationComponent;
import com.jzhu.study.mf.injection.module.ApplicationModule;


public class BaseApplication extends MultiDexApplication {

    public static boolean isCheckedUpdate;
    private ApplicationComponent applicationComponent;

    public static Context getContext() {
        return context;
    }

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initializeInjector();

    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    @Override
    public void onLowMemory() {
        Log.d("***", "memory_low");
        super.onLowMemory();
    }
}
