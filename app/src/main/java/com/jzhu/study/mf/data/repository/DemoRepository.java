package com.jzhu.study.mf.data.repository;

import com.jzhu.study.mf.base.BaseResp;
import com.jzhu.study.mf.data.model.DemoReq;
import com.jzhu.study.mf.data.model.DemoResp;
import rx.Observable;

import java.util.List;

/**
 * Created by Arthas_T on 2016/10/17.
 */

public interface DemoRepository {

    Observable<BaseResp<List<DemoResp>>> getDemoList(String postion);

    Observable<BaseResp> getDemo(DemoReq req);

}
