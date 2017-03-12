package com.jzhu.study.mf.data.net.api;

import com.jzhu.study.mf.base.BaseResp;
import com.jzhu.study.mf.data.model.DemoReq;
import com.jzhu.study.mf.data.model.DemoResp;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

import java.util.List;

public interface DemoApi {

    @POST("marketingAct/getMarketingActList")
    Observable<BaseResp<List<DemoResp>>> getDemoList(@Body DemoReq req);

    @POST("")
    Observable<BaseResp> getDemo(@Body DemoReq req);
}
