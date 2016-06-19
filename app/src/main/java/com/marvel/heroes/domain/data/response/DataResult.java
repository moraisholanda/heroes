package com.marvel.heroes.domain.data.response;

/**
 * Created by sergio on 19/06/16.
 */
public class DataResult<T> {

    public int offset;
    public int limit;
    public int total;
    public int count;

    public T results;

}
