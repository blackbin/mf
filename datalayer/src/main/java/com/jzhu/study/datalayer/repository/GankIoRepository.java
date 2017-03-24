package com.jzhu.study.datalayer.repository;

import com.jzhu.study.datalayer.BaseGankIoResp;
import com.jzhu.study.datalayer.entities.GankFLEntities;
import rx.Observable;

import java.util.List;

public interface GankIoRepository {

    Observable<BaseGankIoResp<List<GankFLEntities>>> getFlist(int rows, int pageNum);


}
