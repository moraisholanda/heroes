package com.marvel.heroes.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marvel.heroes.R;

import butterknife.ButterKnife;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.comics_fragment, container, false);
        ButterKnife.bind(this, fragmentView);
      //  setupRecyclerView();

        return fragmentView;
    }
}
