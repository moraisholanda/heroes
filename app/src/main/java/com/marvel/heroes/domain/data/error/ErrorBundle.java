package com.marvel.heroes.domain.data.error;

/**
 * Created by sergio on 21/06/16.
 */
public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
