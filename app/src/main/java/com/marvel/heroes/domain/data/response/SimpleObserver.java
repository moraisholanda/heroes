package com.marvel.heroes.domain.data.response;

import rx.Observer;

/**
 * Created by sergio on 19/06/16.
 */
public class SimpleObserver <T> implements Observer<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
