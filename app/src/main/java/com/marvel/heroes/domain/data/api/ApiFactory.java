package com.marvel.heroes.domain.data.api;

import android.support.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.marvel.heroes.BuildConfig;
import com.marvel.heroes.domain.data.error.RxErrorHandlingCallAdapterFactory;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sergio on 19/06/16.
 */
public class ApiFactory {

    private final static ApiFactory INSTANCE = new ApiFactory();

    private  <T> T create(Class<T> endpoint) {
        return build(null).create(endpoint);
    }

    public Retrofit build(Interceptor idlingInterceptor) {
        OkHttpClient.Builder clientBuilder = getBuilderHttp(idlingInterceptor);

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .client(clientBuilder.build())
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(buildGson())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @NonNull
    private OkHttpClient.Builder getBuilderHttp(Interceptor idlingInterceptor) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        if (idlingInterceptor != null) {
            clientBuilder.addInterceptor(idlingInterceptor);
        }
        return clientBuilder;
    }


    private GsonConverterFactory buildGson(){
        return GsonConverterFactory.create(new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create());
    }
    public static ApiFactory getInstance(){
        return  INSTANCE;
    }
    public ComicsMarvelApi comicsMarvelApi(){
        return create(ComicsMarvelApi.class);
    }
}
