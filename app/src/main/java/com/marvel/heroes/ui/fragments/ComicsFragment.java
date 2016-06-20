package com.marvel.heroes.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.ui.adapter.ComicsAdapter;
import com.marvel.heroes.ui.presenter.ComicsPresenter;
import com.marvel.heroes.ui.presenter.ComicsPresenterImpl;
import com.marvel.heroes.ui.view.ComicsView;

import java.util.List;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsFragment extends Fragment implements ComicsView {


    private ComicsAdapter adapter;
    private ComicsPresenter presenter;
    RecyclerView recyclerView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.comics_fragment, null);
        recyclerView = (RecyclerView) fragmentView.findViewById(R.id.recycler_view);
        adapter = new ComicsAdapter();
        setupRecyclerView();
        loadComics();
        return fragmentView;
    }

    private void loadComics(){
        presenter = new ComicsPresenterImpl(this);
        presenter.loadComics();

    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showComics(List<Comics> list) {
        if (list != null) {
            this.adapter.setComicsList(list);
        }
    }

    @Override
    public void showError(String message) {

    }
}
