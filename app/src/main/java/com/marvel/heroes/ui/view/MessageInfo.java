package com.marvel.heroes.ui.view;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.marvel.heroes.R;

/**
 * Created by sergio on 21/06/16.
 */
public class MessageInfo {

    public static void showMessage(String message, int layoutId, Activity context) {
        Snackbar snackbar = Snackbar
                .make(context.findViewById(layoutId), message, Snackbar.LENGTH_LONG);

        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(ContextCompat.getColor(context,R.color.snackBar));
        TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(context, R.color.white));
        snackbar.show();
    }
}
