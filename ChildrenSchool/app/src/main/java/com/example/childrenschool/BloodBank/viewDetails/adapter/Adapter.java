package com.example.childrenschool.BloodBank.viewDetails.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.childrenschool.BloodBank.viewDetails.donorShowModel.ShowDonor;
import com.example.childrenschool.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class Adapter extends FirebaseRecyclerAdapter<ShowDonor, Adapter.ViewHolder> {

    public Adapter(@NonNull FirebaseRecyclerOptions<ShowDonor> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull ShowDonor model) {
        holder.batch.setText(model.getBatch());
        holder.bg.setText(model.getBg());
        holder.contact.setText(model.getContact());
        holder.name.setText(model.getName());
        holder.name.setText(model.getWeight());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_showbg, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView batch, bg, contact, name, weight;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            batch = itemView.findViewById(R.id.batch);
            bg = itemView.findViewById(R.id.bg);
            contact = itemView.findViewById(R.id.contact);
            name = itemView.findViewById(R.id.name);
            weight = itemView.findViewById(R.id.weight);
        }
    }
}


