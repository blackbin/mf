package com.jzhu.study.mf.injection.module;

import com.jzhu.study.mf.data.repository.DemoRepository;
import com.jzhu.study.mf.data.repository.impl.DemoRepositoryImpl;
import com.jzhu.study.mf.data.service.DemoService;
import com.jzhu.study.mf.data.service.impl.DemoServiceImp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jzhu on 2016/11/22.
 */
@Module
public class DemoModule {

    @Provides
    DemoService provideDemoService(DemoServiceImp service){
        return service;
    }

    @Provides
    DemoRepository provideDemoRepository(DemoRepositoryImpl repository){
        return repository;
    }

}
