package com.marvel.heroes.domain.interactor;

import rx.Subscriber;

/**
 * Created by sergio on 18/06/16.
 */
public class SubscriberDefault<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable exception) {

    }

    @Override
    public void onNext(T entity) {

    }
}
