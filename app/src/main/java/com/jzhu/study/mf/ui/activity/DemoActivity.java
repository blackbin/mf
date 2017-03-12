package com.jzhu.study.mf.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import butterknife.BindView;
import com.jzhu.study.mf.R;
import com.jzhu.study.mf.base.BaseMvpActivity;
import com.jzhu.study.mf.base.BaseResp;
import com.jzhu.study.mf.data.model.DemoReq;
import com.jzhu.study.mf.data.model.DemoResp;
import com.jzhu.study.mf.injection.component.DaggerDemoComponent;
import com.jzhu.study.mf.injection.module.DemoModule;
import com.jzhu.study.mf.mvp.presenter.DemoPresenter;
import com.jzhu.study.mf.mvp.view.DemoView;
import com.jzhu.study.mf.utils.ObjectUtils;
import rx.Observable;
import rx.functions.Func1;

import java.util.List;

/**
 * Created by jzhu on 2016/11/22.
 */

public class DemoActivity extends BaseMvpActivity<DemoPresenter> implements DemoView {

    @BindView(R.id.mf)
    TextView textView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        mPresenter.getDemoList(DemoReq.SHOW_POSTION_MAIN, this);
        testRX();
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
        if (!ObjectUtils.isListEmpty(list)) {
            for (DemoResp resp : list) {
                textView.setText(resp.getContent());
                Log.i("zj", resp.getContent());
            }
        }
    }

    @Override
    public void getDemo(BaseResp demo) {

    }

    static Observable<Integer> addPre(Integer lan) {
        return Observable.just(lan + 1);
    }

    static Observable<String> int2String(Integer lan) {
        return Observable.just(String.valueOf(lan));
    }

    private void testRX() {

        Integer num[] = { 0, 1, 2, 3, 4, 5, 6, 7 };

        Observable.just(num).flatMap(new Func1<Integer[], Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Integer[] integers) {
                return Observable.from(integers);
            }
        }).flatMap(new Func1<Integer, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Integer integer) {
                return addPre(integer);
            }
        })
//                  .flatMap(new Func1<Integer, Observable<String>>() {
//            @Override
//            public Observable<String> call(Integer integer) {
//                return int2String(integer);
//            }
//        })
                  .filter(i -> i % 2 == 0)
                  .take(3)
                  .doOnNext(integer -> {

                  })
                  .subscribe(integer -> {
                      Log.i("zj", "Integer:" + integer);
                  })

//                  .subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.i("zj", "String:"+s);
//            }
//        })
        ;

//        Observable.create(new Observable.OnSubscribe<Integer>() {
//            @Override
//            public void call(Subscriber<? super Integer> subscriber) {
//                for(int i =0;i<4;i++){
//                    subscriber.onNext(i);
//                }
//                subscriber.onCompleted();
//            }
//        }).map(new Func1<Integer, Boolean>() {
//            @Override
//            public Boolean call(Integer integer) {
//                return integer%2 == 0;
//            }
//        }).map(new Func1<Boolean, Integer>() {
//            @Override
//            public Integer call(Boolean aBoolean) {
//                return aBoolean==true?1:0;
//            }
//        }).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                Log.i("zj",""+integer);
//            }
//        });

//        Observable.from(num).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                Log.i("zj", "call:" + integer);
//            }
//        }, new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//
//            }
//        }, new Action0() {
//            @Override
//            public void call() {
//                Log.i("zj", "Action0:");
//            }
//        });

    }
}
