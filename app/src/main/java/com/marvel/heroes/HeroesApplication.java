package com.marvel.heroes;

import android.app.Application;

/**
 * Created by sergio on 21/06/16.
 */
public class HeroesApplication extends Application {
    private static HeroesApplication instance =null;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static HeroesApplication getInstance() {
        return instance;
    }
}
