package com.marvel.heroes.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.ui.viewholder.AbstractRecyclerViewHolder;

import java.util.List;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ViewHolder> {

    private List<Comics> comicsList;

    public ComicsAdapter(List<Comics> comicsList) {
        this.comicsList = comicsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return comicsList.size();
    }

    public class ViewHolder extends AbstractRecyclerViewHolder {

        View view;


        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}

