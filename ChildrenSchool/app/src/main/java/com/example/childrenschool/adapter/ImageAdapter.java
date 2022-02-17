package com.example.childrenschool.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.childrenschool.R;
import com.example.childrenschool.model.Upload;


import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    public Context context;
    public List <Upload> upload;

    public ImageAdapter(Context context, List<Upload> upload) {
        this.context = context;
        this.upload = upload;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Upload currentUpload = upload.get(position);
        holder.fileName.setText(currentUpload.getFileName());
//        Picasso.get().load(currentUpload.getImageUrl()).placeholder(R.mipmap.ic_launcher).fit().centerCrop().into(holder.image);
        Glide.with(context).load(upload.get(position).getImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return upload.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView fileName;
        public ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fileName = itemView.findViewById(R.id.image_name);
            image = itemView.findViewById(R.id.image);
        }
    }
}
