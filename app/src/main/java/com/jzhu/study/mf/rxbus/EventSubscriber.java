package com.jzhu.study.mf.rxbus;

/**
 * Created by Tcz on 2016/8/30.
 */
public abstract class EventSubscriber<T> {
    public abstract void onEvent(T event);
    public void onError(Throwable throwable) {

    }
}
