package com.marvel.heroes.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.domain.data.interceptor.SharedConstants;
import com.marvel.heroes.ui.activities.ComicsDetailActivity;
import com.marvel.heroes.ui.adapter.ComicsAdapter;
import com.marvel.heroes.ui.adapter.OnClickListenerComicsAdapter;
import com.marvel.heroes.ui.presenter.ComicsPresenter;
import com.marvel.heroes.ui.presenter.ComicsPresenterImpl;
import com.marvel.heroes.ui.view.ComicsView;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsFragment extends BaseFragment implements ComicsView,OnClickListenerComicsAdapter {


    public static final int SPAN_COUNT = 3;
    private ComicsAdapter adapter;
    private ComicsPresenter presenter;
    private StaggeredGridLayoutManager gridLayoutManager;


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ComicsPresenterImpl(this);
        adapter = new ComicsAdapter(this);
        gridLayoutManager = new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.comics_fragment, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
        if(savedInstanceState==null) {
            loadComics();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        List<Comics> comicsList = presenter.comicsParcelable();
        Parcelable comicParcelable = Parcels.wrap(comicsList);
        outState.putParcelable(SharedConstants.EXTRA_COMICS_LIST,comicParcelable);
    }
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null) {
            Parcelable comicsParcelable = savedInstanceState.getParcelable(SharedConstants.EXTRA_COMICS_LIST);
            List<Comics> comicsList = Parcels.unwrap(comicsParcelable);
            presenter.restoreParcelable(comicsList);
        }
    }

    private void loadComics(){
        presenter.loadComics();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(gridLayoutManager);
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

    @Override
    public void setItemClick(Comics comics) {
        Intent intent = new Intent(getActivity(),ComicsDetailActivity.class);
        Parcelable parcelable = Parcels.wrap(comics);
        intent.putExtra(SharedConstants.EXTRA_COMIC, parcelable);
        startActivity(intent);
    }
}
