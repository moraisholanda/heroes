package com.marvel.heroes.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.dto.Comics;

import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sergio on 21/06/16.
 */
public class ComicAdapter extends CustomAdapter<Comics> {


    private OnClickListenerComicsAdapter listenerComicsAdapter;
    private List<Comics> comicsList;



    public void setComicsList(List<Comics> comicsList) {

        notifyDataSetChanged();
    }
    private void validateComicsCollection(Collection<Comics> comicsCollection) {
        if (comicsCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    public ComicAdapter(List<Comics> data) {
        super(data, true, true);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            Comics comics = getItem(position);
            itemViewHolder.textView.setText(String.format("#%d", (int)comics.issueNumber));
            Glide.with(itemViewHolder.view.getContext())
                    .load(comics.thumbnail.path.concat("/portrait_medium.jpg"))
                    .into(itemViewHolder.imageView);
            itemViewHolder.itemRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listenerComicsAdapter!=null){
                        listenerComicsAdapter.setItemClick(comics);
                    }
                }
            });
        } else if (holder instanceof HeaderViewHolder) {

        } else if (holder instanceof FooterViewHolder) {

        }
    }

    //region Override Get ViewHolder
    @Override
    protected RecyclerView.ViewHolder getItemView(LayoutInflater inflater, ViewGroup parent) {
        return new ItemViewHolder(inflater.inflate(R.layout.comic_item, parent, false));
    }

    @Override
    protected RecyclerView.ViewHolder getHeaderView(LayoutInflater inflater, ViewGroup parent) {
        return null;
    }

    @Override
    protected RecyclerView.ViewHolder getFooterView(LayoutInflater inflater, ViewGroup parent) {
        return new FooterViewHolder(inflater.inflate(R.layout.item_footer, parent, false));
    }
    //endregion

    //region ViewHolder Header and Footer
    class ItemViewHolder extends RecyclerView.ViewHolder {
        View view;
        @BindView(R.id.comic_image)
        ImageView imageView;
        @BindView(R.id.comic_number)
        TextView textView;
        @BindView(R.id.item_row)
        LinearLayout itemRow;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
