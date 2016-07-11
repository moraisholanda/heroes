package com.marvel.heroes.ui.viewholder;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sergio on 11/07/16.
 */
public class FooterViewHolder extends AbstractRecyclerViewHolder {


    public FooterViewHolder(View itemView) {
        super(itemView);
        setFullSpanIfNecessary(itemView);
    }

    private void setFullSpanIfNecessary(View view){
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }


}
