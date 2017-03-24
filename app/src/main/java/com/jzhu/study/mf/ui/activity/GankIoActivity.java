package com.jzhu.study.mf.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.jzhu.study.baselibrary.base.BaseMvpActivity;
import com.jzhu.study.baselibrary.base.utils.ObjectUtils;
import com.jzhu.study.commonwidget.RecyclerViewItemDecoration;
import com.jzhu.study.datalayer.entities.GankFLEntities;
import com.jzhu.study.mf.R;
import com.jzhu.study.mf.injection.component.DaggerGankIoComponent;
import com.jzhu.study.mf.injection.module.GankIoModule;
import com.jzhu.study.mf.mvp.presenter.GankIoPresenter;
import com.jzhu.study.mf.mvp.view.GankIoView;
import com.jzhu.study.mf.ui.adpter.GankIoFLAdapter;

import java.util.List;

/**
 * Created by jzhu on 2016/11/22.
 */
@Route(path = "/app/gankIoActivity")
public class GankIoActivity extends BaseMvpActivity<GankIoPresenter> implements GankIoView {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    GankIoFLAdapter mGankIoFLAdapter;

    private int pageNum = 1;

    private int rows = 10;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gankio;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        mPresenter.getList(rows, pageNum, this);
        initRecyclerView();
    }

    @Override
    protected void injectComponent() {
        DaggerGankIoComponent.builder()
                             .applicationComponent(getApplicationComponent())
                             .gankIoModule(new GankIoModule())
                             .activityModule(getActivityModule())
                             .build()
                             .inject(this);
        mPresenter.setView(this);
    }

    private void initRecyclerView(){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new RecyclerViewItemDecoration(
                RecyclerViewItemDecoration.MODE_HORIZONTAL, getResources().getColor(R.color.colorAccent),
                0,
                0,
                0,
                0));
        mGankIoFLAdapter = new GankIoFLAdapter(this);
        mRecyclerView.setAdapter(mGankIoFLAdapter);
    }


    @Override
    public void getList(List<GankFLEntities> list) {
        if (!ObjectUtils.isListEmpty(list)) {
            mGankIoFLAdapter.setData(list);
        }
    }


}
