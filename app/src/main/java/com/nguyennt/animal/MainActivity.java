package com.nguyennt.animal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.gridView = findViewById(R.id.gridView);// Ok roi nha
// dung chua
        ArrayList<AnimalModel> listModel = new ArrayList<AnimalModel>();
        listModel.add(new AnimalModel(true, R.drawable.ic_dog));
        listModel.add(new AnimalModel(false, R.drawable.ic_goose));
        listModel.add(new AnimalModel(true, R.drawable.ic_ladybug));
        listModel.add(new AnimalModel(false, R.drawable.ic_elephant));
        listModel.add(new AnimalModel(false, R.drawable.ic_dolphin));
//        int[] images = {R.drawable.ic_dog, R.drawable.ic_dolphin, R.drawable.ic_dragonfly, R.drawable.ic_elephant, R.drawable.ic_goose, R.drawable.ic_ladybug, R.drawable.ic_penguin, R.drawable.ic_pig, R.drawable.ic_turtle};
        GridAdapter gridAdapter = new GridAdapter(MainActivity.this, listModel);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listModel.get(position).liked = true;
                Toast.makeText(MainActivity.this, "Clicked item: " + listModel.get(position).liked, Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(view.getContext(), DetailActivity.class);
//                Bundle bundle = new Bundle();
//
//                bundle.putInt("index", position);
//                bundle.putInt("image", listModel[position].resource);
//                i.putExtras(bundle);
//                startAc
            }
        });
    }
}

class AnimalModel {
    boolean liked;
    int resource;

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

    AnimalModel(boolean like, int r) {
        this.liked = like;
        this.resource = r;
    }
}