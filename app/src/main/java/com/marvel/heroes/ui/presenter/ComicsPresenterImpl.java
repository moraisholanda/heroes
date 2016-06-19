package com.marvel.heroes.ui.presenter;

import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.domain.data.response.SimpleObserver;
import com.marvel.heroes.domain.repository.ComicsMarvelRepository;
import com.marvel.heroes.domain.repository.IComicsMarvelRepository;
import com.marvel.heroes.ui.view.ComicsView;

import java.util.List;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsPresenterImpl implements ComicsPresenter {


    private IComicsMarvelRepository repository;
    private ComicsView comicsView;

    public ComicsPresenterImpl() {
        this.repository = new ComicsMarvelRepository();
    }

    @Override
    public List<Comics> loadComics() {

        repository.comics()
            .subscribe(new SimpleObserver<List<Comics>>(){
                @Override
                public void onNext(List<Comics> list) {
                    comicsView.showComics(list);
                }

                @Override
                public void onError(Throwable e) {
                    comicsView.showError(e.getMessage());
                }

                @Override
                public void onCompleted() {
                   ;
                }
            });

        return null;
    }
}
