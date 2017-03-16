package com.jzhu.study.mf.mvp.presenter;

import com.jzhu.study.mf.base.BaseAbstractPresenter;
import com.jzhu.study.mf.base.BaseActivity;
import com.jzhu.study.mf.base.BaseSubscriber;
import com.jzhu.study.mf.data.model.GankFLResp;
import com.jzhu.study.mf.data.service.GankIoService;
import com.jzhu.study.mf.mvp.view.GankIoView;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jzhu on 2016/11/22.
 */

public class GankIoPresenter extends BaseAbstractPresenter<GankIoView> {

    @Inject
    GankIoService gankIoService;

    @Inject
    public GankIoPresenter() {
    }

    public void getList(int rows, int pageNum, BaseActivity act) {
        if (!checkNetWork()) {
            return;
        }
        mView.showLoading();
        gankIoService.execute(new BaseSubscriber<List<GankFLResp>>(mView) {
            @Override
            public void onNext(List<GankFLResp> list) {
                mView.getList(list);
                gankIoService.unsubscribe();
            }
        }, gankIoService.getList(rows,pageNum),act);
    }

}
