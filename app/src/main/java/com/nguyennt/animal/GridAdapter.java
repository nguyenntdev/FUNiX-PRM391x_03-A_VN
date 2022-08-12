package com.nguyennt.animal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    final Context context;
    final ArrayList<AnimalModel> images;
    LayoutInflater inflater;

    public GridAdapter(Context context, ArrayList<AnimalModel> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item, null);
        }
        ImageView imageView = convertView.findViewById(R.id.gridImage);
        imageView.setImageResource(images.get(position).resource);
        ImageView favorite = convertView.findViewById(R.id.favorite);
        if (images.get(position).liked) {
            favorite.setImageResource(R.drawable.ic_favorite);
        }
        return convertView;
    }
}


