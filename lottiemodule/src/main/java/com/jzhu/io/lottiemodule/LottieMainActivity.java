package com.jzhu.io.lottiemodule;

import android.animation.Animator;
import android.os.Bundle;
import butterknife.BindView;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.jzhu.study.baselibrary.base.BaseActivity;
import com.jzhu.study.baselibrary.base.utils.ToastUtils;

@Route(path = "/lottiemodule/LottieMainActivity")
public class LottieMainActivity extends BaseActivity {

    @BindView(R2.id.animation_view)
    LottieAnimationView animationView;

    @Override
    protected int getLayoutId() {
        return R.layout.lottie_activity_main;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        initAnimation();
    }

    private void initAnimation(){
        animationView.setImageAssetsFolder("splash");
        animationView.setAnimation("splash.json");
        animationView.loop(false);
        animationView.playAnimation();
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                ToastUtils.showShortMessage(LottieMainActivity.this,"onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ToastUtils.showShortMessage(LottieMainActivity.this,"onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                ToastUtils.showShortMessage(LottieMainActivity.this,"onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                ToastUtils.showShortMessage(LottieMainActivity.this,"onAnimationRepeat");
            }
        });
    }
}
