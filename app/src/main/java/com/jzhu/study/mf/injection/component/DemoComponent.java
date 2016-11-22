package com.jzhu.study.mf.injection.component;

import com.jzhu.study.mf.injection.PerActivity;
import com.jzhu.study.mf.injection.module.ActivityModule;
import com.jzhu.study.mf.injection.module.DemoModule;
import com.jzhu.study.mf.ui.activity.DemoActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class,
        DemoModule.class})
public interface DemoComponent {
    void inject(DemoActivity baseActivity);
}
