package com.marvel.heroes.domain.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.marvel.heroes.HeroesApplication;

/**
 * Created by sergio on 21/06/16.
 */
public class ConectivityUtil {

    public boolean isThereInternetConnection() {
        boolean isConnected;


        ConnectivityManager connectivityManager =
                (ConnectivityManager) HeroesApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
