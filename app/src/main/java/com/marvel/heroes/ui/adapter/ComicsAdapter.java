package com.marvel.heroes.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
public class ComicsAdapter extends RecyclerView.Adapter<AbstractRecyclerViewHolder> {

    private List<Comics> comicsList;
    private OnClickListenerItemAdapter listenerComicsAdapter;
    private static final int FOOTER = 0;
    private static final int ITEM = 1;
    private final int countFooter = 1;
    private boolean mustBeVisible;
    public ComicsAdapter(OnClickListenerItemAdapter listenerComicsAdapter,boolean mustBeVisible){
        this.listenerComicsAdapter = listenerComicsAdapter;
        comicsList = new ArrayList<>();
        this.mustBeVisible = mustBeVisible;
    }

    @Override
    public AbstractRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(FOOTER == viewType){
            View viewFooter = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_footer, parent, false);
            return new FooterViewHolder(viewFooter);

        }else{
            View view= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.comic_item, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(AbstractRecyclerViewHolder holder, int position) {

        if (holder instanceof FooterViewHolder) {
            FooterViewHolder footer = (FooterViewHolder) holder;
            ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            if (lp instanceof StaggeredGridLayoutManager.LayoutParams) {
                    ((StaggeredGridLayoutManager.LayoutParams) lp).setFullSpan(true);

            }
        } else if (holder instanceof  ViewHolder) {
            Comics comics=null;
            if(position<this.comicsList.size()) {
                comics = comicsList.get(position);
                ViewHolder viewHolder = (ViewHolder)holder;
                viewHolder.textView.setText(String.format("#%d", (int)comics.issueNumber));
                Glide.with(viewHolder.view.getContext())
                        .load(comics.thumbnail.getPathPortraitMedium())
                        .into(viewHolder.imageView);
                final Comics finalComics = comics;
                viewHolder.itemRow.setOnClickListener(v -> {
                    if(listenerComicsAdapter!=null){
                        listenerComicsAdapter.setItemClick(finalComics);
                    }
                });
            }
        }
    }

    private boolean isFooter(int position){
        Log.d(getClass().getSimpleName(),"couint "+getItemCount());
        int lastPosition;
        return position == getItemCount()-1;
    }

    @Override
    public int getItemViewType(int position) {
        if(isFooter(position) && mustBeVisible) {
            return FOOTER;
        } else {
            return ITEM;
        }
    }
    @Override
    public int getItemCount() {
        int count = (this.comicsList != null) ? this.comicsList.size() : 0;
        if(mustBeVisible)
            count += 1;

        return count;
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
        @BindView(R.id.item_row)
        LinearLayout itemRow;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
    public class FooterViewHolder extends AbstractRecyclerViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);

        }
    }
}

