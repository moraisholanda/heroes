package com.marvel.heroes.domain.repository;

import com.marvel.heroes.domain.data.api.ApiFactory;
import com.marvel.heroes.domain.data.dto.Comics;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsMarvelRepository implements IComicsMarvelRepository {
    @Override
    public Observable<List<Comics>> comics() {
       return ApiFactory.getInstance().comicsMarvelApi().getComics(1009610,"1","bb4470a46d0659a43c566ac6056ed48d","479474cf0a28eac9998960da4d96f06b")
                .subscribeOn(Schedulers.io())
                .map(listDataCollectionResponse -> listDataCollectionResponse.data.results)
                .observeOn(AndroidSchedulers.mainThread());

    }
}
