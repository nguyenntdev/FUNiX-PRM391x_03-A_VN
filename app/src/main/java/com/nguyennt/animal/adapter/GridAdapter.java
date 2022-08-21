package com.nguyennt.animal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyennt.animal.model.AnimalModel;
import com.nguyennt.animal.R;

import java.util.ArrayList;

public class GridAdapter extends  RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private  ArrayList<AnimalModel>  listData;
    private Context context;
    private Fragment fragment;

    public GridAdapter(Context context, ArrayList<AnimalModel> listData) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.ViewHolder holder, int position) {
        int REQUEST_CODE = 333;
        holder.gridImage.setImageResource(listData.get(position).getResource());
//        holder.gridImage.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(context, DetailActivity.class);
////                intent.putExtra("image", listData.get(position).getResource());
////                intent.putExtra("name", listData.get(position).name);
////                intent.putExtra("description", listData.get(position).detail);
////                fragment.showDetails(context, intent);
////            }
//        });

        if (listData.get(position).isLiked()) {
            holder.favoriteImage.setImageResource(R.drawable.ic_favorite);
        } else {
            holder.favoriteImage.setImageResource(R.drawable.ic_favorite_border);
        }
        }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView gridImage;
        private final ImageView favoriteImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gridImage = itemView.findViewById(R.id.gridImage);
            favoriteImage = itemView.findViewById(R.id.favorite);
        }

    }
}

