package com.nguyennt.animal;

import android.content.Intent;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    private int dataImage;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        img = findViewById(R.id.imageView);
        Bundle bundle = getIntent().getExtras();
        dataImage = bundle.getInt("image");
        img.setImageResource(dataImage);

    }
}