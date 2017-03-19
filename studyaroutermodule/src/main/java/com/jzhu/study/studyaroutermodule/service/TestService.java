package com.jzhu.study.studyaroutermodule.service;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by zhujian on 2017/3/17.
 */

public interface TestService extends IProvider {
    void print(String msg);

}
