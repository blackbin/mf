package com.jzhu.study.mf.mvp.view;

import com.jzhu.study.mf.base.BaseView;
import com.jzhu.study.mf.data.model.GankFLResp;

import java.util.List;

/**
 * Created by jzhu on 2016/11/22.
 */

public interface GankIoView extends BaseView{
    void getList(List<GankFLResp> list);

}
