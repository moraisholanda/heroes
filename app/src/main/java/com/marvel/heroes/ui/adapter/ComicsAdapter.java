package com.marvel.heroes.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.ui.viewholder.AbstractRecyclerViewHolder;
import com.marvel.heroes.ui.viewholder.ComicsViewHolder;
import com.marvel.heroes.ui.viewholder.FooterViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by sergio on 19/06/16.
 */
public class ComicsAdapter extends RecyclerView.Adapter<AbstractRecyclerViewHolder> {

    private List<Comics> items;
    private OnClickListenerItemAdapter listenerComicsAdapter;
    private static final int FOOTER = 0;
    private static final int ITEM = 1;
    private final int countFooter = 1;
    private boolean mustBeVisible;

    public ComicsAdapter(OnClickListenerItemAdapter listenerComicsAdapter, boolean mustBeVisible) {
        this.listenerComicsAdapter = listenerComicsAdapter;
        items = new ArrayList<>();
        this.mustBeVisible = mustBeVisible;
    }

    @Override
    public AbstractRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (FOOTER == viewType) {
            return new FooterViewHolder(inflater.inflate(R.layout.item_footer, parent, false));
        } else {
            return new ComicsViewHolder(inflater.inflate(R.layout.comic_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(AbstractRecyclerViewHolder holder, int position) {
        if (holder instanceof FooterViewHolder) {
            ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            if (lp instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) lp).setFullSpan(true);
            }
        } else {
            ((ComicsViewHolder) holder).bind(items.get(position), listenerComicsAdapter);
        }
    }

    private boolean isFooter(int position) {
        return position == getItemCount() - 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isFooter(position) && mustBeVisible) {
            return FOOTER;
        } else {
            return ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return items.size() + (mustBeVisible ? 1 : 0);
    }

    public void setItems(List<Comics> items) {
        this.validateComicsCollection(items);
        this.items = items;
        this.notifyDataSetChanged();
    }

    private void validateComicsCollection(Collection<Comics> comicsCollection) {
        if (comicsCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }
}

