package com.nguyennt.animal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 333;
    private GridView gridView;
    GridAdapter gridAdapter;
    ArrayList<AnimalModel> listModel = new ArrayList<AnimalModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.gridView = findViewById(R.id.gridView);// Ok roi nha
// dung chua

        listModel.add(new AnimalModel(false, R.drawable.ic_dog, "dog", "", R.drawable.bg_dog));
        listModel.add(new AnimalModel(false, R.drawable.ic_goose, "goose", "", R.drawable.bg_goose));
        listModel.add(new AnimalModel(false, R.drawable.ic_ladybug, "ladybug", "", R.drawable.bg_ladybug));
        listModel.add(new AnimalModel(false, R.drawable.ic_elephant, "elephant", "", R.drawable.bg_elephant));
        listModel.add(new AnimalModel(false, R.drawable.ic_dolphin, "dolphin", "", R.drawable.bg_dolphin));
//        t[] images = {R.drawable.ic_dog, R.drawable.ic_dolphin, R.drawable.ic_dragonfly, R.drawable.ic_elephant, R.drawable.ic_goose, R.drawable.ic_ladybug, R.drawable.ic_penguin, R.drawable.ic_pig, R.drawable.ic_turtle};
        gridAdapter = new GridAdapter(MainActivity.this, listModel);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                listModel.get(position).liked = true;
//                Toast.makeText(MainActivity.this, "Clicked item: " + listModel.get(position).liked, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(view.getContext(), DetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("index", position);

                bundle.putInt("image", listModel.get(position).resource);
                bundle.putString("title", listModel.get(position).name);
                i.putExtras(bundle);
                startActivityForResult(i, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == 900) {
                String key = "ABC";
                final int result = Objects.requireNonNull(data).getIntExtra(key, 0);
                listModel.get(result).liked = true;
                gridAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Result: " + result, Toast.LENGTH_LONG).show();
            }
        }
    }
}


class AnimalModel {
    boolean liked;
    int resource;

    String name;
    String detail;
    int photo;

    AnimalModel(boolean like, int r, String name, String detail, int photo) {
        this.liked = like;
        this.resource = r;
        this.name = name;
        this.detail = detail;
        this.photo = photo;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}