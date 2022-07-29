package com.nguyennt.animal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private int dataImage;
    private ImageView img;
    private int address;
    private String title;
    private String detail;
    private boolean liked;

    private TextView tvTitle;
    private TextView tvDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        img = findViewById(R.id.imageView);
        Bundle bundle = getIntent().getExtras();
        dataImage = bundle.getInt("image");
        address = bundle.getInt("index", 0);
        title = bundle.getString("title");
        detail = bundle.getString("detail");
        liked = bundle.getBoolean("liked");
        tvTitle =findViewById(R.id.tvTitle);
        tvDes = findViewById(R.id.tvDes);
        img.setImageResource(dataImage);
        tvTitle.setText(title);
        tvDes.setText(detail);

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

    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}