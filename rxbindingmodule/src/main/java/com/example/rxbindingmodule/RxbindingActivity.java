package com.example.rxbindingmodule;

import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.Log;
import android.view.TextureView;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.utils.TextUtils;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxCompoundButton;
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
import rx.functions.Func2;
import rx.functions.Func3;

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

    @BindView(R2.id.btn_highlight)
    Button highLightkBtn;

    @BindView(R2.id.et_username)
    EditText usernameEt;

    @BindView(R2.id.et_pwd)
    EditText pwdEt;

    @BindView(R2.id.cb_protocol)
    AppCompatCheckBox protocolCb;


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
        initLoginListener();
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

    private void initLongClickListener() {
        RxView.longClicks(longClickBtn)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        showToast("长按");
                    }
                });
    }

    private void initLoginListener() {
        Observable<CharSequence> usernameOb = RxTextView.textChanges(usernameEt);
        Observable<CharSequence> pwdOb = RxTextView.textChanges(pwdEt);
        Observable<Boolean> protocolOb = RxCompoundButton.checkedChanges(protocolCb);
        Observable.combineLatest(usernameOb, pwdOb, protocolOb, new Func3<CharSequence, CharSequence, Boolean, Boolean>() {
            @Override
            public Boolean call(CharSequence username, CharSequence pwd, Boolean isChecked) {
                return !TextUtils.isEmpty(username) && !TextUtils.isEmpty(username) && isChecked;
            }
        }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                RxView.enabled(highLightkBtn).call(aBoolean);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != timeObservable) {
            timeObservable.unsubscribeOn(AndroidSchedulers.mainThread());
        }
    }
}
