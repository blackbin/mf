package com.jzhu.study.mf.injection.component;

import android.content.Context;

import com.jzhu.study.mf.base.BaseActivity;
import com.jzhu.study.mf.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
}
