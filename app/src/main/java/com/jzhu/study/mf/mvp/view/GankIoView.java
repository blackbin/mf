package com.jzhu.study.mf.mvp.view;

import com.jzhu.study.baselibrary.base.BaseView;
import com.jzhu.study.datalayer.entities.GankFLEntities;

import java.util.List;

/**
 * Created by jzhu on 2016/11/22.
 */

public interface GankIoView extends BaseView {
    void getList(List<GankFLEntities> list);

}
