package com.marvel.heroes.domain.data.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marvel.heroes.domain.data.error.HttpExceptionParser;
import com.marvel.heroes.domain.data.error.RxErrorHandlingCallAdapterFactory;
import com.marvel.heroes.domain.data.parser.DateSerializer;
import com.marvel.heroes.domain.data.parser.MixedDateDeserializer;

import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sergio on 19/06/16.
 */
public class ApiFactory {
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String BRAZILIAN_DATE_FORMAT = "dd/MM/yyyy";
    public static final String API_KEY = "apikey";
    private static <T> T create(Class<T> endpoint) {
        return create(endpoint, DEFAULT_DATE_FORMAT);
    }

    private static OkHttpClient client = null;

    private static <T> T create(Class<T> endpoint, String serializeDateFormat) {
        Gson gson = buildGson(serializeDateFormat);
        client =buildHttpClient();

        Retrofit retrofit = buildRetroFit(client, gson);
        return retrofit.create(endpoint);
    }
    private static OkHttpClient buildHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();
        return okHttpClient;
    }
    private static retrofit2.Retrofit buildRetroFit(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl("http://gateway.marvel.com:80")
                .client(client)
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static Gson buildGson() {
        return buildGson(DEFAULT_DATE_FORMAT);
    }

    public static <T> T exceptionParser(Class<T> tClass, HttpException error) {
        return new HttpExceptionParser<T>(buildGson(), tClass).toResponse(error);
    }

    private static Gson buildGson(String serializeDateFormat){
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateSerializer(serializeDateFormat))
                .registerTypeAdapter(Date.class, new MixedDateDeserializer(DEFAULT_DATE_FORMAT,
                        BRAZILIAN_DATE_FORMAT))
                .create();
    }
    public static ComicsMarvelApi comicsMarvelApi(){
        return create(ComicsMarvelApi.class);
    }
}
