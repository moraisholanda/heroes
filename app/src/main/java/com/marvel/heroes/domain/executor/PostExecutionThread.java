package com.marvel.heroes.domain.executor;

import rx.Scheduler;

/**
 * Created by sergio on 18/06/16.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
