package com.jzhu.study.mf.ui.activity;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.jzhu.study.mf.R;
import com.jzhu.study.mf.base.BaseCompatActivity;

/**
 * Created by jzhu on 2016/11/22.
 */
@Route(path = "/test/activity")
public class TestActivity extends BaseCompatActivity{


    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
    }

}
