package com.marvel.heroes.domain.data.error;

/**
 * Created by sergio on 21/06/16.
 */
public class ComicsNotFoundException extends Exception {

    public ComicsNotFoundException() {
        super();
    }

    public ComicsNotFoundException(final String message) {
        super(message);
    }

    public ComicsNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ComicsNotFoundException(final Throwable cause) {
        super(cause);
    }

}
