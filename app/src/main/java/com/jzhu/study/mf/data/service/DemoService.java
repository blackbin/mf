package com.jzhu.study.mf.data.service;


import com.jzhu.study.mf.base.BaseResp;
import com.jzhu.study.mf.base.BaseService;
import com.jzhu.study.mf.data.model.DemoReq;
import com.jzhu.study.mf.data.model.DemoResp;
import rx.Observable;

import java.util.List;

/**
 * Created by Arthas_T on 2016/10/17.
 */

public abstract class DemoService extends BaseService {
    public abstract Observable<List<DemoResp>> getDemoList(String postion);

    public abstract Observable<BaseResp> getDemo(DemoReq req);

}
