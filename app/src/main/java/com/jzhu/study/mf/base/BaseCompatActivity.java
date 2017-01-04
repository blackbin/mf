package com.jzhu.study.mf.base;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;


/**
 * Created by jian on 16-10-13.
 */
@SuppressLint("NewApi")
public abstract class BaseCompatActivity extends BaseActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(getLayoutId());
        ButterKnife.bind(this);
        initContentView(savedInstanceState);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /**
     * this activity layout res
     * 设置layout布局,在子类重写该方法.
     *
     * @return res layout xml id
     */
    protected abstract int getLayoutId();

    //处理bundle数据
    protected abstract void initContentView(Bundle savedInstanceState);


}