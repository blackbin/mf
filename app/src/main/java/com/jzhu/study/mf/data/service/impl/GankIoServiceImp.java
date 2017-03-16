package com.jzhu.study.mf.data.service.impl;

import com.jzhu.study.mf.base.BaseGankIoFunc;
import com.jzhu.study.mf.data.model.GankFLResp;
import com.jzhu.study.mf.data.repository.GankIoRepository;
import com.jzhu.study.mf.data.service.GankIoService;
import rx.Observable;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jzhu on 2016/11/22.
 */

public class GankIoServiceImp extends GankIoService{
    @Inject
    GankIoRepository gankIoRepository;

    @Inject
    public GankIoServiceImp() {
    }

    @Override
    public Observable<List<GankFLResp>> getList(int rows, int pageNum) {
        return gankIoRepository.getFlist(rows,pageNum).flatMap(new BaseGankIoFunc());
    }
}
