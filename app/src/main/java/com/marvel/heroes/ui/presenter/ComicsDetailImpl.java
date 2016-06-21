package com.marvel.heroes.ui.presenter;

import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.ui.view.ComicsDetailView;

/**
 * Created by sergio on 21/06/16.
 */
public class ComicsDetailImpl implements ComicsDetailPresenter {

    private ComicsDetailView comicsDetailView;

    public ComicsDetailImpl(ComicsDetailView comicsDetailView) {
        this.comicsDetailView = comicsDetailView;
    }

    @Override
    public void showComicsDetail(Comics comics) {
        comicsDetailView.showComicsDetail(comics);
    }
}
