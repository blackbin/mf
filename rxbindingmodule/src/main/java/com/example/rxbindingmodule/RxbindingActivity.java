package com.example.rxbindingmodule;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jzhu.study.baselibrary.base.BaseActivity;

/**
 * Created by jzhu on 2017/5/3.
 */
@Route(path = "/rxbindingmodule/RxbindingActivity")
public class RxbindingActivity extends BaseActivity{
    @Override
    protected int getLayoutId() {
        return R.layout.rxbinding_activity_main;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {

    }
}
