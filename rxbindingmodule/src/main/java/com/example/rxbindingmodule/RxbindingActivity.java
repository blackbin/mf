package com.example.rxbindingmodule;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.jzhu.study.baselibrary.base.BaseActivity;
import com.jzhu.study.baselibrary.base.utils.ToastUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by jzhu on 2017/5/3.
 */
@Route(path = "/rxbindingmodule/RxbindingActivity")
public class RxbindingActivity extends BaseActivity {

    @BindView(R2.id.btn_shake)
    Button shakeBtn;

    @BindView(R2.id.btn_doubleclick)
    Button doubleClickBtn;

    @BindView(R2.id.btn_time)
    Button timeBtn;

    @BindView(R2.id.btn_long_click)
    Button longClickBtn;

    public static int SECOND = 10;

    private Observable<Void> timeObservable;

    @Override
    protected int getLayoutId() {
        return R.layout.rxbinding_activity_main;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        initShakeListener();
        initDoubleClickListener();
        initTimerListener();
        initLongClickListener();
    }

    private void initShakeListener() {
        RxView.clicks(shakeBtn)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        //// TODO: 2017/5/4
                        showToast("throttleFirst 1秒内只响应第一次点击");
                    }
                });
    }

    private void initDoubleClickListener() {
        Observable<Void> observable = RxView.clicks(doubleClickBtn).share();
        observable.buffer(observable.debounce(400, TimeUnit.MILLISECONDS))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Void>>() {
                    @Override
                    public void call(List<Void> voids) {
                        if (voids.size() >= 2) {
                            //double click detected
                            showToast(" 400毫秒内进行了" + voids.size() + "点次击");
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                    }
                });
    }

    private void initTimerListener() {
        timeObservable = RxView.clicks(timeBtn)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        RxView.enabled(timeBtn).call(false);
                    }
                });
        timeObservable.subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Observable.interval(0, 1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                        .take(SECOND + 1)
                        .subscribe(new Observer<Long>() {
                            @Override
                            public void onCompleted() {
                                RxTextView.text(timeBtn).call("点击倒计时");
                                RxView.enabled(timeBtn).call(true);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Long aLong) {
                                long curTime = SECOND - aLong;
                                RxTextView.text(timeBtn).call("倒计时 " + curTime + "s");
                            }
                        });
            }
        });
    }

    private void initLongClickListener(){
        RxView.longClicks(longClickBtn)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                    showToast("长按");
                    }
                });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != timeObservable){
            timeObservable.unsubscribeOn(AndroidSchedulers.mainThread());
        }
    }
}
