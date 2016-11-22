package com.jzhu.study.mf.mvp.presenter;

import com.jzhu.study.mf.base.BaseAbstractPresenter;
import com.jzhu.study.mf.base.BaseResp;
import com.jzhu.study.mf.base.BaseSubscriber;
import com.jzhu.study.mf.data.model.DemoReq;
import com.jzhu.study.mf.data.model.DemoResp;
import com.jzhu.study.mf.data.service.DemoService;
import com.jzhu.study.mf.mvp.view.DemoView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by jzhu on 2016/11/22.
 */

public class DemoPresenter extends BaseAbstractPresenter<DemoView> {

    @Inject
    DemoService demoService;

    @Inject
    public DemoPresenter() {
    }

    public void getDemoList(DemoReq req) {
        if (!checkNetWork()) {
            return;
        }
        mView.showLoading();
        demoService.execute(new BaseSubscriber<List<DemoResp>>(mView) {
            @Override
            public void onNext(List<DemoResp> list) {
                mView.getDemoList(list);
            }
        }, demoService.getDemoList(req));
    }

    public void getDemo(DemoReq req) {
        if (!checkNetWork()) {
            return;
        }
        mView.showLoading();
        demoService.execute(new BaseSubscriber<BaseResp>(mView) {
            @Override
            public void onNext(BaseResp demo) {
                mView.getDemo(demo);
            }
        }, demoService.getDemo(req));
    }

}
