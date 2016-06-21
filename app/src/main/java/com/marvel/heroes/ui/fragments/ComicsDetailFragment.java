package com.marvel.heroes.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.domain.data.interceptor.SharedConstants;
import com.marvel.heroes.domain.tools.DateUtils;
import com.marvel.heroes.ui.presenter.ComicsDetailImpl;
import com.marvel.heroes.ui.presenter.ComicsDetailPresenter;
import com.marvel.heroes.ui.view.ComicsDetailView;
import com.nineoldandroids.animation.Animator;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsDetailFragment extends BaseFragment implements ComicsDetailView {

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
    @BindView(R.id.page_count)
    TextView pageCount;
    @BindView(R.id.linerar_info)
    LinearLayout description;

    Animation slideUpAnimation, slideDownAnimation;
    private YoYo.YoYoString rope;

    private Comics comics;
    private ComicsDetailPresenter presenter = new ComicsDetailImpl(this);

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
            presenter.showComicsDetail(comics);
        }

        AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        appCompatActivity.setSupportActionBar(toolbar);
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> getActivity().finish());

    }
    @OnClick(R.id.magazine_cover)
    void openImageFullScreen(){
       /* Intent intent = new Intent(getActivity(), FullScreenImageActivity.class);
        intent.putExtra(SharedConstants.EXTRA_COMIC,comics.thumbnail.getPathPortraitIncredible());
        startActivity(intent);*/

    }
    private Comics getComicsParcelableFromArgs() {
        Parcelable comic = getArguments().getParcelable(SharedConstants.EXTRA_COMIC);
        return Parcels.unwrap(comic);
    }

    @Override
    public void showComicsDetail(Comics comics) {
        description.setVisibility(View.INVISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                YoYo.with(Techniques.SlideInDown)
                        .duration(1800)
                        .interpolate(new AccelerateDecelerateInterpolator())
                        .withListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                description.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {

                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {
                                Toast.makeText(getActivity(), "canceled", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        })
                        .playOn(description);
            }
        },500);

        Glide.with(getActivity())
                .load(comics.thumbnail.getPathPortraitMedium())
                .crossFade()
                .into(magazineCover);
        infoMagazine.setText(!TextUtils.isEmpty(comics.description) ? comics.description : "");
        titleMagazine.setText(!TextUtils.isEmpty(comics.title) ? comics.title : "");
        datePublisehd.setText(!TextUtils.isEmpty(comics.modified) ? DateUtils.parseDate(comics.modified) : "");
        priceMagazine.setText(String.valueOf(comics.prices.get(0).price));
        pageCount.setText(!TextUtils.isEmpty(String.valueOf(comics.pageCount)) ? String.valueOf(comics.pageCount) : "");

    }
}
