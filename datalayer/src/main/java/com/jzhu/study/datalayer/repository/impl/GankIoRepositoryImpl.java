package com.jzhu.study.datalayer.repository.impl;

import com.jzhu.study.datalayer.BaseGankIoResp;
import com.jzhu.study.datalayer.entities.GankFLEntities;
import com.jzhu.study.datalayer.net.RetrofitFactory;
import com.jzhu.study.datalayer.net.api.GankIoApi;
import com.jzhu.study.datalayer.repository.GankIoRepository;
import rx.Observable;

import javax.inject.Inject;
import java.util.List;

public class GankIoRepositoryImpl implements GankIoRepository {

    @Inject
    public GankIoRepositoryImpl() {
    }

    @Override
    public Observable<BaseGankIoResp<List<GankFLEntities>>> getFlist(int rows, int pageNum) {
        return RetrofitFactory.getInstance().create(GankIoApi.class).getFlList(rows, pageNum);
    }
}
