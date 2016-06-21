package com.marvel.heroes.ui.view;

import com.marvel.heroes.domain.model.UserPreferences;

/**
 * Created by sergio on 21/06/16.
 */
public interface ProfileView {

    void loadUser();

    void showUser(UserPreferences userPreferences);
}
