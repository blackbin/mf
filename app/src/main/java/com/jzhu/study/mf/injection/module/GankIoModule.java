package com.jzhu.study.mf.injection.module;

import com.jzhu.study.mf.data.repository.GankIoRepository;
import com.jzhu.study.mf.data.repository.impl.GankIoRepositoryImpl;
import com.jzhu.study.mf.data.service.GankIoService;
import com.jzhu.study.mf.data.service.impl.GankIoServiceImp;
import dagger.Module;
import dagger.Provides;

/**
 * Created by jzhu on 2016/11/22.
 */
@Module
public class GankIoModule {

    @Provides
    GankIoRepository provideGankIoRepository(GankIoRepositoryImpl service){
        return service;
    }

    @Provides
    GankIoService provideGankIoService(GankIoServiceImp repository){
        return repository;
    }

}
