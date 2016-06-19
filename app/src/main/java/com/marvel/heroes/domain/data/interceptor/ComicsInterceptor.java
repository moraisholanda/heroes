package com.marvel.heroes.domain.data.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Request newRequest = request.newBuilder()
                .addHeader(SharedConstantsApiUtils.TS,"1")
                .addHeader(SharedConstantsApiUtils.APIKEY,"bb4470a46d0659a43c566ac6056ed48d")
                .addHeader(SharedConstantsApiUtils.HASH,"479474cf0a28eac9998960da4d96f06b")
                .build();
        return chain.proceed(newRequest);
    }
}
