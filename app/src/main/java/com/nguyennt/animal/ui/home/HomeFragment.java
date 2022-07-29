package com.nguyennt.animal.ui.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.nguyennt.animal.AnimalModel;
import com.nguyennt.animal.DetailActivity;
import com.nguyennt.animal.GridAdapter;
import com.nguyennt.animal.MainActivity;
import com.nguyennt.animal.R;
import com.nguyennt.animal.ui.gallery.GalleryFragment;
import com.nguyennt.animal.ui.slideshow.SlideshowFragment;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    private static final int REQUEST_CODE = 333;
    private GridView gridView;
    GridAdapter gridAdapter;
    ArrayList<AnimalModel> listModel = new ArrayList<AnimalModel>();
//    Toolbar toolbar;
//    ActionBarDrawerToggle toggle;
//    DrawerLayout drawerLayout;
//    NavigationView navigationView;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        gridView = view.findViewById(R.id.gridView);


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
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listModel.get(position).liked = true;
                Intent i = new Intent(view.getContext(), DetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("index", position);

                bundle.putInt("image", listModel.get(position).resource);
                bundle.putString("title", listModel.get(position).name);
                i.putExtras(bundle);
                startActivityForResult(i, REQUEST_CODE);

                startActivity(i);
            }
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