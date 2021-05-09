package com.example.chandiwalaapp.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chandiwalaapp.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.holder> {

    String keys[];

    public RecyclerViewAdapter(String[] keys) {
        this.keys = keys;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View customView = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_layout, parent, false);
        return new holder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.date.setText(keys[position]);

    }

    @Override
    public int getItemCount() {
        return keys.length;
    }

    class holder extends RecyclerView.ViewHolder {

        TextView date;

        public holder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.dateTextView);

        }
    }
}
