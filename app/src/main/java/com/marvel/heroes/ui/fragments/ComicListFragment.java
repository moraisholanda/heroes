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
import android.widget.RelativeLayout;

import com.liucanwen.app.headerfooterrecyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.domain.data.interceptor.SharedConstants;
import com.marvel.heroes.ui.activities.ComicsDetailActivity;
import com.marvel.heroes.ui.adapter.ComicsAdapter;
import com.marvel.heroes.ui.adapter.OnClickListenerItemAdapter;
import com.marvel.heroes.ui.presenter.ComicsPresenter;
import com.marvel.heroes.ui.presenter.ComicsPresenterImpl;
import com.marvel.heroes.ui.view.ComicsView;
import com.marvel.heroes.ui.view.MessageInfo;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicListFragment extends BaseFragment implements ComicsView,OnClickListenerItemAdapter {


    public static final int SPAN_COUNT = 3;
    public static final int REQUEST_CODE = 0;
    private ComicsAdapter adapter;
    private ComicsPresenter presenter;
    private HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter;


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.rl_progress)
    RelativeLayout progressView;
    @BindView(R.id.rl_retry)
    RelativeLayout retryView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ComicsPresenterImpl(this);
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
        adapter = new ComicsAdapter(this,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    public void showComics(List<Comics> list) {
        if (list != null) {
           this.adapter.setItems(list);
        }
    }

    @Override
    public void showError(String message) {
        MessageInfo.showMessage(message,R.id.container,getActivity());
    }

    @Override
    public void hideLoading() {
        progressView.setVisibility(View.GONE);
        getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showLoading() {
        progressView.setVisibility(View.VISIBLE);
        getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void showRetry() {
        retryView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        retryView.setVisibility(View.GONE);
    }

    @Override
    public void setItemClick(Comics comics) {
        Intent intent = new Intent(getActivity(),ComicsDetailActivity.class);
        Parcelable parcelable = Parcels.wrap(comics);
        intent.putExtra(SharedConstants.EXTRA_COMIC, parcelable);
        startActivity(intent);
    }

    @OnClick(R.id.button_open_settings)
    void onClickButtonSettings(){
        startActivityForResult(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS), REQUEST_CODE);
    }
    @OnClick(R.id.button_retry)
    void onClickButtonRetry(){
        presenter.loadComics();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            presenter.loadComics();
        }
    }
}
