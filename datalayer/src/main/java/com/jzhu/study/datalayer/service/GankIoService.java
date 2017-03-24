package com.jzhu.study.datalayer.service;

import com.jzhu.study.datalayer.BaseService;
import com.jzhu.study.datalayer.entities.GankFLEntities;
import rx.Observable;

import java.util.List;

public abstract class GankIoService extends BaseService {

    public abstract Observable<List<GankFLEntities>> getList(int rows, int pageNum );

}
