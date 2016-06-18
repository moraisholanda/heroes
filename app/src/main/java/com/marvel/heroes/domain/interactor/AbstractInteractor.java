package com.marvel.heroes.domain.interactor;

import com.marvel.heroes.domain.executor.PostExecutionThread;
import com.marvel.heroes.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by sergio on 18/06/16.
 */
public abstract class AbstractInteractor {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private Subscription subscription = Subscriptions.empty();

    protected AbstractInteractor(ThreadExecutor threadExecutor,
                      PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }


    protected abstract Observable buildUseCaseObservable();


    @SuppressWarnings("unchecked")
    public void execute(Subscriber UseCaseSubscriber) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(UseCaseSubscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
