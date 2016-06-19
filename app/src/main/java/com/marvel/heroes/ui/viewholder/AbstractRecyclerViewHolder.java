package com.marvel.heroes.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by sergio on 19/06/16.
 */
public abstract class AbstractRecyclerViewHolder extends RecyclerView.ViewHolder {


    public AbstractRecyclerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
