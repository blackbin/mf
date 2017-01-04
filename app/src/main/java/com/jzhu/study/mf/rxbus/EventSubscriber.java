package com.jzhu.study.mf.rxbus;

public abstract class EventSubscriber<T> {
    public abstract void onEvent(T event);
    public void onError(Throwable throwable) {

    }
}
