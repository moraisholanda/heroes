package com.marvel.heroes.ui.activities;

import android.os.Bundle;
import android.os.Parcelable;

import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.domain.data.interceptor.SharedConstants;
import com.marvel.heroes.ui.fragments.ComicsDetailFragment;

import org.parceler.Parcels;

/**
 * Created by sergio on 20/06/16.
 */
public class ComicsDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comics_detail_activity);
        if (savedInstanceState == null) {
            addInfoFragment();
        }
    }

    public void addInfoFragment() {
        Parcelable comicsParcelable = getIntent().getExtras().getParcelable(SharedConstants.EXTRA_COMIC);
        Comics comicsDetail = Parcels.unwrap(comicsParcelable);

        ComicsDetailFragment comicsDetailFragment = ComicsDetailFragment.newInstance(comicsDetail);
        addFragment(R.id.fragmentContainer,comicsDetailFragment);
    }
}
