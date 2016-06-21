package com.marvel.heroes.ui.activities;

import android.os.Bundle;

import com.marvel.heroes.R;
import com.marvel.heroes.ui.fragments.ProfileFragement;

/**
 * Created by sergio on 21/06/16.
 */
public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new ProfileFragement());
        }
    }
}
