package com.marvel.heroes.ui.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marvel.heroes.R;
import com.marvel.heroes.domain.data.dto.Comics;
import com.marvel.heroes.ui.adapter.OnClickListenerItemAdapter;

import butterknife.BindView;

/**
 * Created by sergio on 11/07/16.
 */
public class ComicsViewHolder extends AbstractRecyclerViewHolder {

    View view;
    @BindView(R.id.comic_image)
    ImageView imageView;
    @BindView(R.id.comic_number)
    TextView textView;
    @BindView(R.id.item_row)
    LinearLayout itemRow;

    public ComicsViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;
    }

    public void bind(final Comics comics, final OnClickListenerItemAdapter listenerItemAdapter){
        textView.setText(String.format("#%d",comics.issueNumber));
        Glide.with(view.getContext())
                .load(comics.thumbnail.getPathPortraitMedium())
                .into(imageView);
        itemRow.setOnClickListener(v -> {
            if(listenerItemAdapter!=null){
                listenerItemAdapter.setItemClick(comics);
            }
        });
    }
}
