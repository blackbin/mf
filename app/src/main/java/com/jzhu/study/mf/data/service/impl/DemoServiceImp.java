package com.jzhu.study.mf.data.service.impl;

import com.jzhu.study.mf.base.BaseFunc;
import com.jzhu.study.mf.base.BaseResp;
import com.jzhu.study.mf.data.model.DemoReq;
import com.jzhu.study.mf.data.model.DemoResp;
import com.jzhu.study.mf.data.repository.DemoRepository;
import com.jzhu.study.mf.data.service.DemoService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by jzhu on 2016/11/22.
 */

public class DemoServiceImp extends DemoService{
    @Inject
    DemoRepository actRepository;

    @Inject
    public DemoServiceImp() {
    }

    @Override
    public Observable<List<DemoResp>> getDemoList(DemoReq req) {
        return actRepository.getDemoList(req).flatMap(new BaseFunc<>());
    }

    @Override
    public Observable<BaseResp> getDemo(DemoReq req) {
        return actRepository.getDemo(req);
    }
}
