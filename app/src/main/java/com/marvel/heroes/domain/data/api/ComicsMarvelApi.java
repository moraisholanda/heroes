package com.marvel.heroes.domain.data.api;

import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.domain.data.response.DataCollectionResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sergio on 19/06/16.
 */
public interface ComicsMarvelApi {

    @GET("/v1/public/characters/{comicId}/comics")
    Observable<DataCollectionResponse<List<Comics>>> getComics(@Path("comicId") Integer comicId, @Query("ts")String timeStamp,@Query("apikey")String apikey,@Query("hash")String hash);
}
