package com.marvel.heroes.domain.repository;

import com.marvel.heroes.domain.model.ComicsMarvel;

import java.util.List;

import rx.Observable;

/**
 * Created by sergio on 18/06/16.
 */
public interface ComicsMarvelRepository {

    Observable<List<ComicsMarvel>> comics();
}
