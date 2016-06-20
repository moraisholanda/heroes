package com.marvel.heroes.ui.activities;

import android.os.Bundle;

import com.marvel.heroes.R;
import com.marvel.heroes.ui.fragments.ComicsFragment;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new ComicsFragment());
        }
    }
}
