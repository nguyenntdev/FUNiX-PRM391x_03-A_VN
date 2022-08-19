package com.nguyennt.animal;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.nguyennt.animal.ui.detail.DetailFragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {
    // viewpager adapter

    private Context context;
    ArrayList<AnimalModel> listModel;

    // Constructor of our ViewPager2Adapter class
    public ViewPagerAdapter(Context context, ArrayList listModel) {
        this.context = context;
        this.listModel = listModel;
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
        // This will set the images in imageview
        holder.imageView.setImageResource(listModel.get(position).resource);
        holder.tvTitle.setText(listModel.get(position).name);
        holder.tvDes.setText(listModel.get(position).detail);
        holder.likedState = listModel.get(position).liked;
        holder.liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listModel.get(position).liked = !listModel.get(position).liked;
                notifyDataSetChanged();
            }
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
        ImageView imageView;
        TextView tvTitle;
        TextView tvDes;
        ImageView liked;
        Boolean likedState;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDes = itemView.findViewById(R.id.tvDes);
            liked = itemView.findViewById(R.id.favorite);
        }
    }
}
