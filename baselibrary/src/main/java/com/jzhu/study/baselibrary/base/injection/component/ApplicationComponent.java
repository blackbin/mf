package com.jzhu.study.baselibrary.base.injection.component;

import android.content.Context;
import com.jzhu.study.baselibrary.base.BaseActivity;
import com.jzhu.study.baselibrary.base.injection.module.ApplicationModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
}
