package com.jzhu.study.mf.data.repository.impl;

import com.jzhu.study.mf.base.BaseGankIoResp;
import com.jzhu.study.mf.data.model.GankFLResp;
import com.jzhu.study.mf.data.net.RetrofitFactory;
import com.jzhu.study.mf.data.net.api.GankIoApi;
import com.jzhu.study.mf.data.repository.GankIoRepository;
import rx.Observable;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Arthas_T on 2016/10/17.
 */

public class GankIoRepositoryImpl implements GankIoRepository {

    @Inject
    public GankIoRepositoryImpl() {
    }

    @Override
    public Observable<BaseGankIoResp<List<GankFLResp>>> getFlist(int rows, int pageNum) {
        return RetrofitFactory.getInstance().create(GankIoApi.class).getFlList(rows,pageNum);
    }
}
