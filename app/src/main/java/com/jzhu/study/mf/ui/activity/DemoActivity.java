package com.jzhu.study.mf.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.jzhu.study.mf.R;
import com.jzhu.study.mf.base.BaseMvpActivity;
import com.jzhu.study.mf.base.BaseResp;
import com.jzhu.study.mf.data.model.DemoReq;
import com.jzhu.study.mf.data.model.DemoResp;
import com.jzhu.study.mf.injection.component.DaggerDemoComponent;
import com.jzhu.study.mf.injection.module.DemoModule;
import com.jzhu.study.mf.mvp.presenter.DemoPresenter;
import com.jzhu.study.mf.mvp.view.DemoView;

import java.util.List;

/**
 * Created by jzhu on 2016/11/22.
 */

public class DemoActivity extends BaseMvpActivity<DemoPresenter> implements DemoView{

    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
       // mPresenter.getDemoList(new DemoReq());
        mPresenter.getDemo(new DemoReq());
    }

    @Override
    protected void injectComponent() {
        DaggerDemoComponent.builder()
                .applicationComponent(getApplicationComponent())
                .demoModule(new DemoModule())
                .build()
                .inject(this);
        mPresenter.setView(this);
    }

    @Override
    public void getDemoList(List<DemoResp> list) {
    }

    @Override
    public void getDemo(BaseResp demo) {
        Log.i("zj",""+demo.getStatus());
    }
}
