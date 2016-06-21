package com.marvel.heroes.domain.data.error;

import android.content.Context;

import com.marvel.heroes.R;

/**
 * Created by sergio on 21/06/16.
 */
public class ErrorMessageFactory {
    private ErrorMessageFactory() {

    }
    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.exception_message_generic);

        if (exception instanceof NetworkConnectionException) {
            message = context.getString(R.string.exception_network_connection);
        } else if (exception instanceof ComicsNotFoundException) {
            message = context.getString(R.string.exception_message_comics_not_found);
        }
         else if (exception instanceof RetrofitException) {
         message = exception.getMessage();
    }

        return message;
    }
}
