package com.jzhu.study.mf.data.repository.impl;

import com.jzhu.study.mf.base.BaseResp;
import com.jzhu.study.mf.data.model.DemoReq;
import com.jzhu.study.mf.data.model.DemoResp;
import com.jzhu.study.mf.data.net.RetrofitFactory;
import com.jzhu.study.mf.data.net.api.DemoApi;
import com.jzhu.study.mf.data.repository.DemoRepository;
import rx.Observable;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Arthas_T on 2016/10/17.
 */

public class DemoRepositoryImpl implements DemoRepository {

    @Inject
    public DemoRepositoryImpl() {
    }

    @Override
    public Observable<BaseResp<List<DemoResp>>> getDemoList(String postion) {
        DemoReq req = new DemoReq();
        req.setShowPosition(postion);
        req.setDeviceOsType(0);
        return RetrofitFactory.getInstance().create(DemoApi.class).getDemoList(req);
    }

    @Override
    public Observable<BaseResp> getDemo(DemoReq req) {
        return RetrofitFactory.getInstance().create(DemoApi.class).getDemo(req);
    }
}
