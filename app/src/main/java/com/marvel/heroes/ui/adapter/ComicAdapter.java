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

import java.util.List;

/**
 * Created by sergio on 21/06/16.
 */
public class ComicAdapter extends CustomAdapter<Comics> {


    private OnClickListenerItemAdapter listenerComicsAdapter;
    private List<Comics> comicsList;



    public ComicAdapter(List<Comics> data) {
        super(data, false, true);
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

    class ItemViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView imageView;
        TextView textView;
        LinearLayout itemRow;

        public ItemViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            imageView=(ImageView)itemView.findViewById(R.id.comic_image);
            textView = (TextView)itemView.findViewById(R.id.comic_number);
            itemRow = (LinearLayout)itemView.findViewById(R.id.item_row);
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
