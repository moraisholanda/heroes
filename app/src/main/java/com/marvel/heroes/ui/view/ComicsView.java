package com.marvel.heroes.ui.view;

import com.marvel.heroes.domain.data.dto.Comics;

import java.util.List;

/**
 * Created by sergio on 19/06/16.
 */
public interface ComicsView {

    void showComics(List<Comics> list);

    void showError(String message);

    void hideLoading();

    void showLoading();

    void showRetry();

    void hideRetry();


}
