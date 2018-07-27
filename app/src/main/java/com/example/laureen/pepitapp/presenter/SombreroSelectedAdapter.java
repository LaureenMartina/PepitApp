package com.example.laureen.pepitapp.presenter;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.laureen.pepitapp.R;
import com.example.laureen.pepitapp.model.SombreroItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Chewbs on 21/07/2018.
 */

public class SombreroSelectedAdapter extends RecyclerView.Adapter<SombreroSelectedAdapter.ViewHolder> {
    private List<SombreroItem> list_cell;

    public SombreroSelectedAdapter(List<SombreroItem> list_cell) {
        this.list_cell = list_cell;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cell_sombrero, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SombreroSelectedAdapter.ViewHolder viewHolder, int position) {
        @DrawableRes int item_url = list_cell.get(position).getItem_url();
        @DrawableRes int color_url = list_cell.get(position).getColor_url();

        if (item_url != 0) {
            Picasso.get().load(item_url).resize(24, 12).into(viewHolder.item);
        }
        if (color_url != 0){
            Picasso.get().load(color_url).resize(24, 12).into(viewHolder.color);
        }

    }

    @Override
    public int getItemCount() {
        return list_cell.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView color;
        private ImageView item;
        ViewHolder(View view) {
            super(view);

            color = view.findViewById(R.id.color_cell);
            item = (ImageView) view.findViewById(R.id.item_cell);
        }
    }
}
