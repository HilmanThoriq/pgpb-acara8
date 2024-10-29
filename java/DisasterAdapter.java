package com.example.simpleapp7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DisasterAdapter extends RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder> {

    private List<com.example.simpleapp7.Disaster> disasterList;

    public DisasterAdapter(List<com.example.simpleapp7.Disaster> list) {
        disasterList = list;
    }

    @NonNull
    @Override
    public ItemDisasterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_disaster, parent, false);
        return new ItemDisasterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemDisasterViewHolder holder, int position) {
        holder.bind(disasterList.get(position));
    }

    @Override
    public int getItemCount() {
        return disasterList.size();
    }

    public static class ItemDisasterViewHolder extends RecyclerView.ViewHolder {
        private TextView destination;
        private TextView class_type;

        public ItemDisasterViewHolder(View itemView) {
            super(itemView);
            destination = itemView.findViewById(R.id.destination);
            class_type = itemView.findViewById(R.id.class_type);
        }

        public void bind(com.example.simpleapp7.Disaster data) {
            destination.setText(data.getDisasterName());
            class_type.setText(data.getDisasterType());
        }
    }
}
