package com.marvel.heroes.domain.interactor;

import com.marvel.heroes.domain.executor.PostExecutionThread;
import com.marvel.heroes.domain.executor.ThreadExecutor;

import rx.Observable;

/**
 * Created by sergio on 18/06/16.
 */
public class GetComicsMarvel extends AbstractInteractor {


    protected GetComicsMarvel(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return null;
    }
}
