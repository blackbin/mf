package com.jzhu.study.mf.data.service.impl;

import com.jzhu.study.mf.base.BaseFunc;
import com.jzhu.study.mf.base.BaseResp;
import rx.Observable;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jzhu on 2016/11/22.
 */

public class DemoServiceImp extends DemoService{
    @Inject
    DemoRepository demoRepository;

    @Inject
    public DemoServiceImp() {
    }

    @Override
    public Observable<List<DemoResp>> getDemoList(String postion) {
        return demoRepository.getDemoList(postion).flatMap(new BaseFunc<>());
    }

    @Override
    public Observable<BaseResp> getDemo(DemoReq req) {
        return demoRepository.getDemo(req);
    }
}
