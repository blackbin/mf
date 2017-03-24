package com.jzhu.study.mf.mvp.presenter;

import com.jzhu.study.baselibrary.base.BaseAbstractPresenter;
import com.jzhu.study.baselibrary.base.BaseActivity;
import com.jzhu.study.baselibrary.base.BaseSubscriber;
import com.jzhu.study.datalayer.entities.GankFLEntities;
import com.jzhu.study.datalayer.service.GankIoService;
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
        gankIoService.execute(new BaseSubscriber<List<GankFLEntities>>(mView) {
            @Override
            public void onNext(List<GankFLEntities> list) {
                mView.getList(list);
                gankIoService.unsubscribe();
            }
        }, gankIoService.getList(rows,pageNum),act);
    }

}
