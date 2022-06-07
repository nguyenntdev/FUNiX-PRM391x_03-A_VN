package com.nguyennt.animal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private int dataImage;
    private ImageView img;
    private int address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        img = findViewById(R.id.imageView);
        Bundle bundle = getIntent().getExtras();
        dataImage = bundle.getInt("image");
        address = bundle.getInt("index", 0);
        img.setImageResource(dataImage);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent data = new Intent();
                data.putExtra("ABC", address);

                setResult(900, data);

                finish();
            }
        });

    }
}