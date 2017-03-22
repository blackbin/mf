package com.jzhu.study.mf.injection.component;

import com.jzhu.study.mf.injection.PerActivity;
import com.jzhu.study.mf.injection.module.ActivityModule;
import com.jzhu.study.mf.injection.module.GankIoModule;
import com.jzhu.study.mf.ui.activity.GankIoActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class,
                                                                 GankIoModule.class})
public interface GankIoComponent extends ActivityComponent{
    void inject(GankIoActivity baseActivity);
}
