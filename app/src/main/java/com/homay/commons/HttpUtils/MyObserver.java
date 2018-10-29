package com.homay.commons.HttpUtils;

import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyObserver<T> implements Observer<T> {


    private static final String TAG = "MyObserver";
    private ObserverOnNextListener listener;
    private Context context;

    public MyObserver(Context context, ObserverOnNextListener listener) {
        this.listener = listener;
        this.context = context;
    }


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Object o) {

        listener.onNext(o);
    }

    @Override
    public void onError(Throwable e) {

        listener.onError(e);
    }

    @Override
    public void onComplete() {

    }
}
