package com.nguyennt.animal.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyennt.animal.AnimalModel;
import com.nguyennt.animal.GridAdapter;
import com.nguyennt.animal.R;
import com.nguyennt.animal.RecyclerItemListener;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    public SlideshowFragment() {}
    private static final int REQUEST_CODE = 333;
    GridAdapter gridAdapter;
    final ArrayList<AnimalModel> listModel = new ArrayList<>();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        GridAdapter adapter = new GridAdapter(getContext(), listModel);

        listModel.add(new AnimalModel(false, R.drawable.ic_dog, "dog", "The dog or domestic dog (Canis familiaris[4][5] or Canis lupus familiaris[5]) is a domesticated descendant of the wolf. The dog is derived from an ancient, extinct wolf,[6][7] and the modern wolf is the dog's nearest living relative.[8] The dog was the first species to be domesticated,[9][8] by hunter–gatherers over 15,000 years ago,[7] before the development of agriculture.[1] Due to their long association with humans, dogs have expanded to a large number of domestic individuals[10] and gained the ability to thrive on a starch-rich diet that would be inadequate for other canids.[11]", R.drawable.bg_dog));
        listModel.add(new AnimalModel(false, R.drawable.ic_goose, "goose", "", R.drawable.bg_goose));
        listModel.add(new AnimalModel(false, R.drawable.ic_ladybug, "ladybug", "", R.drawable.bg_ladybug));
        listModel.add(new AnimalModel(false, R.drawable.ic_elephant, "elephant", "", R.drawable.bg_elephant));
        listModel.add(new AnimalModel(false, R.drawable.ic_dolphin, "dolphin", "", R.drawable.bg_dolphin));
        listModel.add(new AnimalModel(false, R.drawable.ic_turtle, "turtle", "", R.drawable.bg_turtle));
        listModel.add(new AnimalModel(false, R.drawable.ic_pig, "pig", "", R.drawable.bg_pig));
        listModel.add(new AnimalModel(false, R.drawable.ic_dragonfly, "dragonfly", "", R.drawable.bg_dragonfly));
        listModel.add(new AnimalModel(false, R.drawable.ic_penguin, "penguin", "", R.drawable.bg_penguin));

        recyclerView.setAdapter(gridAdapter);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
//        gridView.setOnItemClickListener((parent, view1, position, id) -> {
//            Intent i = new Intent(view1.getContext(), DetailActivity.class);
//
//            Bundle bundle = new Bundle();
//            bundle.putInt("index", position);
//            bundle.putBoolean("liked", listModel.get(position).liked);
//            bundle.putString("detail", listModel.get(position).detail);
//            bundle.putInt("image", listModel.get(position).photo);
//            bundle.putString("title", listModel.get(position).name);
//            i.putExtras(bundle);
//            startActivityForResult(i, REQUEST_CODE);
//
//
//        });

        recyclerView.addOnItemTouchListener(
                new RecyclerItemListener(getContext(), new RecyclerItemListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {


                        Bundle bundle = new Bundle();
                        bundle.putInt("index", position);
                        bundle.putBoolean("liked", listModel.get(position).liked);
                        bundle.putString("detail", listModel.get(position).detail);
                        bundle.putInt("image", listModel.get(position).photo);
                        bundle.putString("title", listModel.get(position).name);

                    }
                }));

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