package com.marvel.heroes.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.domain.data.interceptor.SharedConstants;
import com.marvel.heroes.ui.activities.FullScreenImageActivity;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsDetailFragment extends BaseFragment  {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.magazine_cover)
    ImageView magazineCover;
    @BindView(R.id.info)
    TextView infoMagazine;
    @BindView(R.id.title_magazine)
    TextView titleMagazine;
    @BindView(R.id.date_published)
    TextView datePublisehd;
    @BindView(R.id.price_magazine)
    TextView priceMagazine;
    private Comics comics;

    public static ComicsDetailFragment newInstance(Comics comics){
        Bundle args = new Bundle();
        Parcelable comicParcel = Parcels.wrap(comics);
        args.putParcelable(SharedConstants.EXTRA_COMIC, comicParcel);

        ComicsDetailFragment characterInfoFragment = new ComicsDetailFragment();
        characterInfoFragment.setArguments(args);
        return characterInfoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.comics_detail_fragment, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            comics = getComicsParcelableFromArgs();
            showComicDetail();
        }

        AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        appCompatActivity.setSupportActionBar(toolbar);
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> getActivity().finish());

    }

    private void showComicDetail(){
        Glide.with(getActivity())
                .load(comics.thumbnail.getPathPortraitMedium())
                .crossFade()
                .into(magazineCover);
        infoMagazine.setText(!TextUtils.isEmpty(comics.description) ? comics.description : "");
        titleMagazine.setText(!TextUtils.isEmpty(comics.title) ? comics.title : "");
        datePublisehd.setText(!TextUtils.isEmpty(comics.modified) ? comics.modified : "");
        priceMagazine.setText(String.valueOf(comics.prices.get(0).price));
    }

    @OnClick(R.id.magazine_cover)
    void openImageFullScreen(){
        Intent intent = new Intent(getActivity(), FullScreenImageActivity.class);
        intent.putExtra(SharedConstants.EXTRA_COMIC,comics.thumbnail.getPathPortraitIncredible());
        startActivity(intent);
    }
    private Comics getComicsParcelableFromArgs() {
        Parcelable comic = getArguments().getParcelable(SharedConstants.EXTRA_COMIC);
        return Parcels.unwrap(comic);
    }
}
