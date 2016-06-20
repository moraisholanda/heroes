package com.marvel.heroes.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.ui.viewholder.AbstractRecyclerViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ViewHolder> {

    private List<Comics> comicsList;

    public ComicsAdapter(){
        comicsList = new ArrayList<>();
    }
    public ComicsAdapter(List<Comics> comicsList) {
        this.comicsList = comicsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comic_item, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comics comics = comicsList.get(position);

        holder.textView.setText(String.format("#%d", (int)comics.issueNumber));
        Glide.with(holder.view.getContext())
                .load(comics.thumbnail.path.concat("/portrait_medium.jpg"))
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return (this.comicsList != null) ? this.comicsList.size() : 0;
    }

    public void setComicsList(List<Comics> comicsList) {
        this.validateComicsCollection(comicsList);
        this.comicsList =  comicsList;
        this.notifyDataSetChanged();
    }
    private void validateComicsCollection(Collection<Comics> comicsCollection) {
        if (comicsCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    public class ViewHolder extends AbstractRecyclerViewHolder {

        View view;
        @BindView(R.id.comic_image)
        ImageView imageView;
        @BindView(R.id.comic_number)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}

