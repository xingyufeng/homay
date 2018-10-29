package com.homay.commons.HttpUtils;

public interface ObserverOnNextListener<T> {
    void onNext(T t);
    void onComplete();
    void onError(Throwable e);
}
