package com.marvel.heroes.ui.presenter;

import com.marvel.heroes.HeroesApplication;
import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.domain.data.error.ComicsNotFoundException;
import com.marvel.heroes.domain.data.error.DefaultErrorBundle;
import com.marvel.heroes.domain.data.error.ErrorBundle;
import com.marvel.heroes.domain.data.error.ErrorMessageFactory;
import com.marvel.heroes.domain.data.error.NetworkConnectionException;
import com.marvel.heroes.domain.data.response.SimpleObserver;
import com.marvel.heroes.domain.repository.ComicsMarvelRepository;
import com.marvel.heroes.domain.repository.IComicsMarvelRepository;
import com.marvel.heroes.domain.tools.ConectivityUtil;
import com.marvel.heroes.ui.view.ComicsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsPresenterImpl implements ComicsPresenter {


    private IComicsMarvelRepository repository;
    private ComicsView comicsView;
    private List<Comics> comicsList;
    public ComicsPresenterImpl(ComicsView comicsView) {
        this.comicsView = comicsView;
        this.repository = new ComicsMarvelRepository();
    }

    @Override
    public void loadComics() {
        comicsList = new ArrayList<>();
        comicsView.showLoading();
        if(ConectivityUtil.isThereInternetConnection()){
            repository.comics()
                    .subscribe(new SimpleObserver<List<Comics>>(){
                        @Override
                        public void onNext(List<Comics> list) {
                            comicsList = list;
                            showList(list);
                        }
                        @Override
                        public void onError(Throwable e) {
                            comicsView.hideLoading();
                            shorErrorMessage(new DefaultErrorBundle((Exception) e));

                        }

                        @Override
                        public void onCompleted() {
                            comicsView.hideLoading();
                            comicsView.hideRetry();
                        }
                    });
        }else{
            comicsView.hideLoading();
            comicsView.showRetry();
            shorErrorMessage(new DefaultErrorBundle(new NetworkConnectionException()));
        }

    }

    private void showList(List<Comics> list) {
        if(comicsList.size()==0){
            shorErrorMessage(new DefaultErrorBundle(new ComicsNotFoundException()));
        }else {
            comicsView.showComics(list);
        }
    }

    private void shorErrorMessage(ErrorBundle errorBundle){
        comicsView.showError(ErrorMessageFactory.create(HeroesApplication.getInstance(),errorBundle.getException()));
    }

    @Override
    public List<Comics> comicsParcelable() {
        return (List<Comics>) ((ArrayList<Comics>) comicsList).clone();
    }

    @Override
    public void restoreParcelable(List<Comics> comicsList) {
        this.comicsList = comicsList;
        comicsView.showComics(comicsList);
    }
}
