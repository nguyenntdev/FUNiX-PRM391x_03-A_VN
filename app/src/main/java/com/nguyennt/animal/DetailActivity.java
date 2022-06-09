package com.nguyennt.animal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private int dataImage;
    private ImageView img;
    private int address;
    private String title;
    private TextView tvTitle;
    private TextView tvDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        img = findViewById(R.id.imageView);
        Bundle bundle = getIntent().getExtras();
        dataImage = bundle.getInt("image");
        address = bundle.getInt("index", 0);
        title = bundle.getString("title");
        tvTitle =findViewById(R.id.tvTitle);
        tvDes = findViewById(R.id.tvDes);
        img.setImageResource(dataImage);
        tvTitle.setText(title);
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