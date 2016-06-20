package com.marvel.heroes.ui.activities;

import android.os.Bundle;

import com.marvel.heroes.R;
import com.marvel.heroes.ui.fragments.ComicsDetailFragment;

/**
 * Created by sergio on 20/06/16.
 */
public class ComicsDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comics_detail_activity);
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new ComicsDetailFragment());
        }
    }
}
