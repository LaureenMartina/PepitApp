package com.example.laureen.pepitapp.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.laureen.pepitapp.R;
import com.example.laureen.pepitapp.model.Level;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Chewbs on 20/07/2018.
 */

public class SombreroListAdapter extends RecyclerView.Adapter<SombreroListAdapter.ViewHolder> {

    private List<Level> levelList;
    private Listener listener;

    public SombreroListAdapter(List<Level> levelList) {
        this.levelList = levelList;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_sombrero, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Level level = levelList.get(position);
        holder.name.setText(level.getName());
        holder.difficulty.setText(String.valueOf(level.getDifficulty()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (listener != null) {
                    listener.onLevelClick(level);
                }
            }
        });
    }

    @Override public int getItemCount() {
        return levelList == null ? 0 : levelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name_tv) TextView name;
        @BindView(R.id.difficulty_tv) TextView difficulty;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface Listener {
        void onLevelClick(Level level);
    }
}
