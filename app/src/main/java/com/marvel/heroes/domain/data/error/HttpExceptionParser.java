package com.marvel.heroes.domain.data.error;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by sergio on 19/06/16.
 */
public class HttpExceptionParser <T> {

    private static final String TAG = "HttpExceptionParser";

    Gson gson;
    Class<T> tClass;

    public HttpExceptionParser(Gson gson, Class<T> tClass) {
        this.gson = gson;
        this.tClass = tClass;
    }

    public T toResponse(HttpException error) {
        String responseBody = null;
        try {
            responseBody = new String(error.response().errorBody().bytes());
            return gson.fromJson(responseBody, tClass);
        } catch (IOException e) {
            Log.e(TAG, "toResponse: ", e);
        }
        return null;
    }
}
