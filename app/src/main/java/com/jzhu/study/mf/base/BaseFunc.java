package com.jzhu.study.mf.base;


import com.jzhu.study.mf.common.Constant;
import com.jzhu.study.mf.data.exception.BusinessException;

import rx.Observable;
import rx.functions.Func1;

public class BaseFunc<T> implements Func1<BaseResp<T>, Observable<T>> {
    @Override
    public Observable<T> call(BaseResp<T> resp) {
        if (!Constant.STATUS_SUCCESS.equals(resp.getStatus())) {
            return Observable.error(new BusinessException(
                    resp.getErrorCode(),
                    resp.getErrorMsg()));
        }
        return Observable.just(resp.getData());
    }
}
