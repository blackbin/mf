package com.jzhu.study.mf.data.repository;

import com.jzhu.study.mf.base.BaseGankIoResp;
import com.jzhu.study.mf.data.model.GankFLResp;
import rx.Observable;

import java.util.List;

/**
 * Created by Arthas_T on 2016/10/17.
 */

public interface GankIoRepository {

    Observable<BaseGankIoResp<List<GankFLResp>>> getFlist(int rows,int pageNum);


}
