package com.marvel.heroes.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marvel.heroes.R;
import com.marvel.heroes.domain.model.UserPreferences;
import com.marvel.heroes.ui.presenter.ProfilePresenteImpl;
import com.marvel.heroes.ui.presenter.ProfilePresenter;
import com.marvel.heroes.ui.view.ProfileView;

import butterknife.BindView;

/**
 * Created by sergio on 21/06/16.
 */
public class ProfileFragement extends BaseFragment implements ProfileView {

    private ProfilePresenter profilePresenter;

    @BindView(R.id.edit_user_description)
    TextView userDescription;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profilePresenter = new ProfilePresenteImpl(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_fragment, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState==null) {
            loadUser();
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        appCompatActivity.setSupportActionBar(toolbar);
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> getActivity().finish());
    }

    @Override
    public void loadUser() {
        profilePresenter.loadUser();
    }

    @Override
    public void showUser(UserPreferences userPreferences) {
        userDescription.setText(userPreferences.getDescription());
        toolbar.setTitle(userPreferences.getName());
    }
}
