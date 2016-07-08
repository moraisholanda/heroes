package com.marvel.heroes.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.marvel.heroes.R;
import com.marvel.heroes.ui.fragments.ComicListFragment;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsActivity extends BaseActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        imageView = (ImageView) findViewById(R.id.open_profile);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComicsActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new ComicListFragment());
        }
    }
}
