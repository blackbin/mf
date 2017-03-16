package com.jzhu.study.mf.data.service;


import com.jzhu.study.mf.base.BaseService;
import com.jzhu.study.mf.data.model.GankFLResp;
import rx.Observable;

import java.util.List;

public abstract class GankIoService extends BaseService {
    public abstract Observable<List<GankFLResp>> getList(int rows,int pageNum );

}
