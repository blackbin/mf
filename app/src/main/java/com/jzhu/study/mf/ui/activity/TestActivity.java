package com.jzhu.study.mf.ui.activity;

import android.os.Bundle;
import android.view.View;
import butterknife.OnClick;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jzhu.study.baselibrary.base.BaseActivity;
import com.jzhu.study.mf.R;

/**
 * Created by jzhu on 2016/11/22.
 */
public class TestActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
    }


    @OnClick({ R.id.arouter, R.id.test ,R.id.mvp,R.id.lottie,R.id.rxbinding})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mvp:
                ARouter.getInstance().build("/app/gankIoActivity").navigation();
                break;
            case R.id.arouter:
                ARouter.getInstance().build("/studyaroutermodule/mainActivity").navigation();
                break;
            case R.id.test:
                ARouter.getInstance().build("/testmodule/activity").navigation();
                break;
            case R.id.lottie:
                ARouter.getInstance().build("/lottiemodule/LottieMainActivity").navigation();
                break;
            case R.id.rxbinding:
                ARouter.getInstance().build("/rxbindingmodule/RxbindingActivity").navigation();
                break;
        }
    }
}
