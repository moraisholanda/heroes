package com.marvel.heroes.ui.presenter;

import com.marvel.heroes.domain.data.dto.Comics;

import java.util.List;

/**
 * Created by sergio on 19/06/16.
 */
public interface ComicsPresenter {

    List<Comics> loadComics();
}
