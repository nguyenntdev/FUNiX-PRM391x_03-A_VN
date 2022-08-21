package com.nguyennt.animal.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyennt.animal.R;
import com.nguyennt.animal.adapter.GridAdapter;
import com.nguyennt.animal.model.AnimalModel;
import com.nguyennt.animal.ui.detail.DetailFragment;
import com.nguyennt.animal.util.RecyclerItemListener;

import java.util.ArrayList;
import java.util.Objects;


public class HomeFragment extends Fragment {


    static final ArrayList<AnimalModel> listModel = new ArrayList<>();
    private static final int REQUEST_CODE = 333;
    private GridAdapter adapter;
    private GridAdapter gridAdapter;
    private boolean changed;

    private int type;

    public HomeFragment() {
    }

    public HomeFragment(int type) {
        if (this.type != type) {
            this.type = type;
            changed = true;
        } else {
            changed = false;
        }
    }


    public static HomeFragment newInstance() {


        return new HomeFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        getActivity().findViewById(R.id.toolbar).setVisibility(View.VISIBLE);


        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        if (changed) {
            listModel.clear();
            if (type == 1) {
                listModel.add(new AnimalModel(false, R.drawable.ic_dog, "dog", "The dog or domestic dog (Canis familiaris[4][5] or Canis lupus familiaris[5]) is a domesticated descendant of the wolf. The dog is derived from an ancient, extinct wolf,[6][7] and the modern wolf is the dog's nearest living relative.[8] The dog was the first species to be domesticated,[9][8] by hunter–gatherers over 15,000 years ago,[7] before the development of agriculture.[1] Due to their long association with humans, dogs have expanded to a large number of domestic individuals[10] and gained the ability to thrive on a starch-rich diet that would be inadequate for other canids.[11]", R.drawable.bg_dog));
                listModel.add(new AnimalModel(false, R.drawable.ic_goose, "goose", "", R.drawable.bg_goose));
                listModel.add(new AnimalModel(false, R.drawable.ic_ladybug, "ladybug", "", R.drawable.bg_ladybug));
                listModel.add(new AnimalModel(false, R.drawable.ic_elephant, "elephant", "", R.drawable.bg_elephant));
                listModel.add(new AnimalModel(false, R.drawable.ic_dolphin, "dolphin", "", R.drawable.bg_dolphin));
                listModel.add(new AnimalModel(false, R.drawable.ic_turtle, "turtle", "", R.drawable.bg_turtle));
                listModel.add(new AnimalModel(false, R.drawable.ic_pig, "pig", "", R.drawable.bg_pig));
                listModel.add(new AnimalModel(false, R.drawable.ic_dragonfly, "dragonfly", "", R.drawable.bg_dragonfly));
                listModel.add(new AnimalModel(false, R.drawable.ic_penguin, "penguin", "", R.drawable.bg_penguin));
            } else if (type == 2) {
                listModel.add(new AnimalModel(false, R.drawable.ic_dog, "dog", "The dog or domestic dog (Canis familiaris[4][5] or Canis lupus familiaris[5]) is a domesticated descendant of the wolf. The dog is derived from an ancient, extinct wolf,[6][7] and the modern wolf is the dog's nearest living relative.[8] The dog was the first species to be domesticated,[9][8] by hunter–gatherers over 15,000 years ago,[7] before the development of agriculture.[1] Due to their long association with humans, dogs have expanded to a large number of domestic individuals[10] and gained the ability to thrive on a starch-rich diet that would be inadequate for other canids.[11]", R.drawable.bg_dog));
                listModel.add(new AnimalModel(false, R.drawable.ic_goose, "goose", "", R.drawable.bg_goose));
                listModel.add(new AnimalModel(false, R.drawable.ic_ladybug, "ladybug", "", R.drawable.bg_ladybug));
                listModel.add(new AnimalModel(false, R.drawable.ic_elephant, "elephant", "", R.drawable.bg_elephant));
                listModel.add(new AnimalModel(false, R.drawable.ic_dolphin, "dolphin", "", R.drawable.bg_dolphin));
                listModel.add(new AnimalModel(false, R.drawable.ic_turtle, "turtle", "", R.drawable.bg_turtle));

            } else if (type == 3) {
                listModel.add(new AnimalModel(false, R.drawable.ic_dog, "dog", "The dog or domestic dog (Canis familiaris[4][5] or Canis lupus familiaris[5]) is a domesticated descendant of the wolf. The dog is derived from an ancient, extinct wolf,[6][7] and the modern wolf is the dog's nearest living relative.[8] The dog was the first species to be domesticated,[9][8] by hunter–gatherers over 15,000 years ago,[7] before the development of agriculture.[1] Due to their long association with humans, dogs have expanded to a large number of domestic individuals[10] and gained the ability to thrive on a starch-rich diet that would be inadequate for other canids.[11]", R.drawable.bg_dog));
                listModel.add(new AnimalModel(false, R.drawable.ic_goose, "goose", "", R.drawable.bg_goose));
                listModel.add(new AnimalModel(false, R.drawable.ic_ladybug, "ladybug", "", R.drawable.bg_ladybug));

            }
        }
        adapter = new GridAdapter(getContext(), listModel);

        LinearLayoutCompat linearLayoutCompat = view.findViewById(R.id.LinearLayoutCompat);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemListener(getContext(), new RecyclerItemListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

//                        Intent i = new Intent(view.getContext(), DetailActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putInt("position", position);
                        bundle.putParcelableArrayList("listModel", listModel);
                        // Set Fragmentclass Arguments
                        DetailFragment fragment = new DetailFragment(bundle);
                        getActivity().findViewById(R.id.toolbar).setVisibility(View.GONE);

                        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction
                                .addToBackStack("name")
                                .replace(R.id.content_frame, new DetailFragment(bundle))
                                .setCustomAnimations(R.anim.fade_in, 0, 0, R.anim.fade_out)
                                .commit();
//                        i.putExtras(bundle);
//                        startActivityForResult(i, REQUEST_CODE);
                    }
                }));

        super.onViewCreated(view, savedInstanceState);

        // or  (ImageView) view.findViewById(R.id.foo);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("animalKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                // We use a String here, but any type that can be put in a Bundle is supported
                // Do something with the result
                int position = bundle.getInt("position");
                boolean liked = bundle.getBoolean("liked");

                listModel.get(position).liked = liked;
                adapter.notifyDataSetChanged();
//                adapter.notifyItemChanged(position);

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == 2) {
                int position = Objects.requireNonNull(data).getIntExtra("index", 0);
                AnimalModel currentData = listModel.get(position);
                boolean dataLiked = data.getBooleanExtra("liked", true);
                listModel.set(position, new AnimalModel(dataLiked, currentData.resource, currentData.name, currentData.detail, currentData.photo));
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


}