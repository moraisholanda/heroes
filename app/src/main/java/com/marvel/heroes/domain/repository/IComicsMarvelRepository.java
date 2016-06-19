package com.marvel.heroes.domain.repository;

import com.marvel.heroes.domain.data.dto.Comics;

import java.util.List;

import rx.Observable;

/**
 * Created by sergio on 18/06/16.
 */
public interface IComicsMarvelRepository {

    Observable<List<Comics>> comics();
}
