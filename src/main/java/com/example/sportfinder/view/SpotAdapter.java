package com.example.sportfinder.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sportfinder.R;
import com.example.sportfinder.data.localdatabase.SpotItem;

import java.util.List;

public class SpotAdapter extends RecyclerView.Adapter<SpotAdapter.SpotViewHolder> {
    private List<SpotItem> spotList;
    private Context context;
    private OnSpotItemClickListener onSpotItemClickListener;

    public SpotAdapter(Context context, List<SpotItem> SpotList) {
        this.context = context;
        this.spotList = SpotList;
    }

    public class SpotViewHolder extends RecyclerView.ViewHolder {
        TextView spotNameTextView;
        ImageView spotImageView;

        public SpotViewHolder(View itemView) {
            super(itemView);
            spotNameTextView = itemView.findViewById(R.id.spot_name);
            spotImageView = itemView.findViewById(R.id.spot_image);
        }
    }

    @NonNull
    @Override
    public SpotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spot_autocomplete_row, parent, false);
        return new SpotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpotViewHolder holder, int position) {
        SpotItem spot = spotList.get(position);

        holder.spotNameTextView.setText(spot.getSpotName());

        Glide.with(context)
                .load(spot.getFlagImage())
                .into(holder.spotImageView);

        holder.itemView.setOnClickListener(v -> {
            if (onSpotItemClickListener != null) {
                onSpotItemClickListener.onSpotItemClick(spot);
            }
        });
    }

    @Override
    public int getItemCount() {
        return spotList.size();
    }

    public void updateList(List<SpotItem> newList) {
        spotList.clear();
        spotList.addAll(newList);
        notifyDataSetChanged();
    }

    public void setOnSpotItemClickListener(OnSpotItemClickListener listener) {
        this.onSpotItemClickListener = listener;
    }

    public interface OnSpotItemClickListener {
        void onSpotItemClick(SpotItem spotItem);
    }
}