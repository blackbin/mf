package com.jzhu.study.mf.data.service;


import com.jzhu.study.mf.base.BaseResp;
import com.jzhu.study.mf.base.BaseService;
import com.jzhu.study.mf.data.model.DemoReq;
import com.jzhu.study.mf.data.model.DemoResp;

import java.util.List;

import rx.Observable;

/**
 * Created by Arthas_T on 2016/10/17.
 */

public abstract class DemoService extends BaseService {
    public abstract Observable<List<DemoResp>> getDemoList(DemoReq req);

    public abstract Observable<BaseResp> getDemo(DemoReq req);

}
