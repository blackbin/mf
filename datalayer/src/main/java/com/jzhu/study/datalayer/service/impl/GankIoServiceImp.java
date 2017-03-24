package com.jzhu.study.datalayer.service.impl;

import com.jzhu.study.datalayer.BaseGankIoFunc;
import com.jzhu.study.datalayer.entities.GankFLEntities;
import com.jzhu.study.datalayer.repository.GankIoRepository;
import com.jzhu.study.datalayer.service.GankIoService;
import rx.Observable;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jzhu on 2016/11/22.
 */

public class GankIoServiceImp extends GankIoService {
    @Inject
    GankIoRepository gankIoRepository;

    @Inject
    public GankIoServiceImp() {
    }

    @Override
    public Observable<List<GankFLEntities>> getList(int rows, int pageNum) {
        return gankIoRepository.getFlist(rows,pageNum).flatMap(new BaseGankIoFunc());
    }

}
