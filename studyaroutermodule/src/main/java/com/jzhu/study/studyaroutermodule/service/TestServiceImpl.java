package com.jzhu.study.studyaroutermodule.service;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by zhujian on 2017/3/17.
 */
@Route(path = "/service/test")
public class TestServiceImpl implements TestService {
    Context context;

    @Override
    public void print(String msg) {
        if(!TextUtils.isEmpty(msg)){
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void init(Context context) {
        this.context = context;
        Log.e("zj", TestServiceImpl.class.getName() + " has init.");
    }
}
