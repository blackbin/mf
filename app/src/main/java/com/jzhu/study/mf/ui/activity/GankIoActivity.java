package com.jzhu.study.mf.ui.activity;

import android.os.Bundle;
import android.util.Log;
import com.jzhu.study.mf.R;
import com.jzhu.study.mf.base.BaseMvpActivity;
import com.jzhu.study.mf.data.model.GankFLResp;
import com.jzhu.study.mf.injection.component.DaggerGankIoComponent;
import com.jzhu.study.mf.injection.module.GankIoModule;
import com.jzhu.study.mf.mvp.presenter.GankIoPresenter;
import com.jzhu.study.mf.mvp.view.GankIoView;
import com.jzhu.study.mf.utils.ObjectUtils;

import java.util.List;

/**
 * Created by jzhu on 2016/11/22.
 */

public class GankIoActivity extends BaseMvpActivity<GankIoPresenter> implements GankIoView {

    private int pageNum = 1;
    private int rows = 10;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gankio;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        mPresenter.getList(rows,pageNum, this);
    }

    @Override
    protected void injectComponent() {
        DaggerGankIoComponent.builder()
                             .applicationComponent(getApplicationComponent())
                             .gankIoModule(new GankIoModule())
                             .build()
                             .inject(this);
        mPresenter.setView(this);
    }

    @Override
    public void getList(List<GankFLResp> list) {
        if (!ObjectUtils.isListEmpty(list)) {
            for (GankFLResp resp : list) {
                Log.i("zj", resp.getUrl());
            }
        }
    }
}
