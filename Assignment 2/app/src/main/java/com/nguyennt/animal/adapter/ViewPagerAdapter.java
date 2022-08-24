package com.nguyennt.animal.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyennt.animal.model.AnimalModel;
import com.nguyennt.animal.R;
import com.nguyennt.animal.ui.detail.DetailFragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {
    // viewpager adapter

    private final Context context;
    final ArrayList<AnimalModel> listModel;
    final DetailFragment detailFragment;


    // Constructor of our ViewPager2Adapter class
    public ViewPagerAdapter(Context context, ArrayList listModel, DetailFragment detailFragment) {
        this.context = context;
        this.listModel = listModel;
        this.detailFragment = detailFragment;
    }


    // This method returns our layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewpager2_item, parent, false);

        return new ViewHolder(view);
    }

    // This method binds the screen with the view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       Character.toUpperCase( listModel.get(position).name.charAt(0));
        // This will set the images in imageview
        holder.imageView.setImageResource(listModel.get(position).photo);
        holder.tvTitle.setText(listModel.get(position).name);
        holder.tvDes.setText(listModel.get(position).detail);
        holder.likedState = listModel.get(position).liked;
        detailFragment.toolbar.setTitle("Animal");
        holder.liked.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);

            listModel.get(position).liked = !listModel.get(position).liked;

            bundle.putBoolean("liked", listModel.get(position).liked);
            detailFragment.getParentFragmentManager().setFragmentResult("animalKey", bundle);

            notifyDataSetChanged();
        });
        if (holder.likedState) {
            holder.liked.setImageResource(R.drawable.ic_favorite);
        } else {
            holder.liked.setImageResource(R.drawable.ic_favorite_border);
        }
        
    }

    // This Method returns the size of the Array
    @Override
    public int getItemCount() {
        return listModel.size();
    }



    // The ViewHolder class holds the view
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView tvTitle;
        final TextView tvDes;
        final ImageView liked;
        Boolean likedState;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDes = itemView.findViewById(R.id.tvDes);
            liked = itemView.findViewById(R.id.liked);
        }
    }
}
