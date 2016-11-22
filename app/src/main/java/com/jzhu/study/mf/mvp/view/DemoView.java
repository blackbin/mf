package com.jzhu.study.mf.mvp.view;

import com.jzhu.study.mf.base.BaseResp;
import com.jzhu.study.mf.base.BaseView;
import com.jzhu.study.mf.data.model.DemoResp;

import java.util.List;

/**
 * Created by jzhu on 2016/11/22.
 */

public interface DemoView extends BaseView{
    void getDemoList(List<DemoResp> list);
    void getDemo(BaseResp demo);

}
