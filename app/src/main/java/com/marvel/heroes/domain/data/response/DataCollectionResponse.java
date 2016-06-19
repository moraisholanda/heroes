package com.marvel.heroes.domain.data.response;

/**
 * Created by sergio on 19/06/16.
 */
public class DataCollectionResponse <T> {

    public int code;

    public String status;

    public String copyright;

    public String attributionText;

    public String attributionHTML;

    public String etag;

    public DataResult<T> data;


}
