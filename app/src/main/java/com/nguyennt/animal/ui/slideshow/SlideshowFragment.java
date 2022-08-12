package com.nguyennt.animal.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nguyennt.animal.AnimalModel;
import com.nguyennt.animal.DetailActivity;
import com.nguyennt.animal.GridAdapter;
import com.nguyennt.animal.R;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    public SlideshowFragment() {}
    private static final int REQUEST_CODE = 333;
    GridAdapter gridAdapter;
    final ArrayList<AnimalModel> listModel = new ArrayList<>();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        GridView gridView = view.findViewById(R.id.gridView);


        listModel.add(new AnimalModel(false, R.drawable.ic_dog, "dog", "", R.drawable.bg_dog));
        listModel.add(new AnimalModel(false, R.drawable.ic_goose, "goose", "", R.drawable.bg_goose));
        listModel.add(new AnimalModel(false, R.drawable.ic_ladybug, "ladybug", "", R.drawable.bg_ladybug));
        listModel.add(new AnimalModel(false, R.drawable.ic_elephant, "elephant", "", R.drawable.bg_elephant));
        listModel.add(new AnimalModel(false, R.drawable.ic_dolphin, "dolphin", "", R.drawable.bg_dolphin));
        listModel.add(new AnimalModel(false, R.drawable.ic_turtle, "turtle", "", R.drawable.bg_turtle));
        listModel.add(new AnimalModel(false, R.drawable.ic_pig, "pig", "", R.drawable.bg_pig));
        listModel.add(new AnimalModel(false, R.drawable.ic_dragonfly, "dragonfly", "", R.drawable.bg_dragonfly));
        listModel.add(new AnimalModel(false, R.drawable.ic_penguin, "penguin", "", R.drawable.bg_penguin));

        gridAdapter = new GridAdapter(view.getContext(), listModel);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener((parent, view1, position, id) -> {
            listModel.get(position).liked = true;
            Intent i = new Intent(view1.getContext(), DetailActivity.class);

            Bundle bundle = new Bundle();
            bundle.putInt("index", position);

            bundle.putInt("image", listModel.get(position).resource);
            bundle.putString("title", listModel.get(position).name);
            i.putExtras(bundle);
            startActivityForResult(i, REQUEST_CODE);

        });

        super.onViewCreated(view, savedInstanceState);

        // or  (ImageView) view.findViewById(R.id.foo);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}