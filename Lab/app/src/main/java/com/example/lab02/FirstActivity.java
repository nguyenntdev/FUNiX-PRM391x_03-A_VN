package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class FirstActivity extends AppCompatActivity {

    private Button buttonSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        buttonSwitch = findViewById(R.id.buttonSwitch);
        buttonSwitch.setOnClickListener(v -> {
            String value = "Transaction Succeeded";
            Intent i = new Intent(FirstActivity.this, SecondActivity.class);
            i.putExtra("value", value);
            startActivity(i);
        });
    }
}