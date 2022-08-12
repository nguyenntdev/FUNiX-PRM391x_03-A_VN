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

    private int address;
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
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        ImageView img = findViewById(R.id.imageView);
        Bundle bundle = getIntent().getExtras();
        int dataImage = bundle.getInt("image");
        address = bundle.getInt("index", 0);
        String title = bundle.getString("title");
        detail = bundle.getString("detail");
        liked = bundle.getBoolean("liked");
        tvTitle = findViewById(R.id.tvTitle);
        tvDes = findViewById(R.id.tvDes);
        img.setImageResource(dataImage);
        tvTitle.setText(title);
        tvDes.setText(detail);

        ImageView liked2 = findViewById(R.id.liked);

        liked2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!liked) {
                    liked2.setImageResource(R.drawable.ic_favorite);
                    liked = true;
                } else {
                    liked2.setImageResource(R.drawable.ic_favorite_border);
                    liked = false;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent();
            intent.putExtra("index", address);
            intent.putExtra("liked", liked);
            setResult(2, intent);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}