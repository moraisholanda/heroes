package com.marvel.heroes.ui.adapter;

import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsLayoutManager extends StaggeredGridLayoutManager {
    public ComicsLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public ComicsLayoutManager(int spanCount, int orientation) {
        super(spanCount, orientation);
    }

}

