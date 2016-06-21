package com.marvel.heroes.ui.presenter;

import com.marvel.heroes.HeroesApplication;
import com.marvel.heroes.R;
import com.marvel.heroes.domain.model.UserPreferences;
import com.marvel.heroes.ui.view.ProfileView;

/**
 * Created by sergio on 21/06/16.
 */
public class ProfilePresenteImpl implements ProfilePresenter {

    private ProfileView profileView;
    private UserPreferences userPreferences;

    public ProfilePresenteImpl(ProfileView profileView) {
        this.profileView = profileView;
    }

    private void initialize(){
        userPreferences = new UserPreferences(HeroesApplication.getInstance());
        userPreferences.setEmail("moraisholanda765@gmail.com");
        userPreferences.setGitHub("moraisholanda");
        userPreferences.setName("Sergio Holanda");
        userPreferences.setDescription(HeroesApplication.getInstance().getString(R.string.about_me));

    }
    @Override
    public void loadUser() {
        initialize();
        profileView.showUser(userPreferences);

    }
}
