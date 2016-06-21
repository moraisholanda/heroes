package com.marvel.heroes.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.interceptor.SharedConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sergio on 20/06/16.
 */
public class FullScreenImageActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView(R.layout.full_image_activity);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String imageId = intent.getStringExtra(SharedConstants.EXTRA_COMIC);
        ImageView imageView = (ImageView)findViewById(R.id.full_image);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(v -> finish());

        getWindow().addFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN );
        Glide.with(this)
                .load(imageId)
                .into(imageView);


    }
    }



