package com.jzhu.study.studyaroutermodule.service;

import android.content.Context;
import android.util.Log;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by zhujian on 2017/3/17.
 */
@Route(path = "/service/test")
public class TestServiceImpl implements TestService {
    @Override
    public void print(String msg) {
        Log.i("zj",msg);
    }

    @Override
    public void init(Context context) {
        Log.e("zj", TestServiceImpl.class.getName() + " has init.");

    }
}
