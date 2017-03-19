package com.jzhu.study.studyaroutermodule.interceptor;

import android.content.Context;
import android.util.Log;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * Created by zhujian on 2017/3/17.
 */
@Interceptor(priority = 7)
public class TestInterceptor implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if("/studyaroutermodule/secondActivity".equals(postcard.getPath())){
            postcard.withString("sex","male");
        }
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {
        Log.e("zj", TestInterceptor.class.getName() + " has init.");
    }
}
