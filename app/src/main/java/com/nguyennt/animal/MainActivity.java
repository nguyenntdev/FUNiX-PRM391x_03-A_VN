package com.nguyennt.animal;

import android.Manifest;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.nguyennt.animal.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private IntentFilter mIntentFilter;

    @Override
    protected void onStart() {
        super.onStart();
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(TelephonyManager.EXTRA_STATE);
        Intent serviceIntent = new Intent(this, MyService.class);
        startService(serviceIntent); // nhận được cuộc gọi đến + sdt gọi
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 0;
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.READ_PHONE_STATE)) {
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_PHONE_STATE}, MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
            }
        }
        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_LONG).show();
        else Toast.makeText(MainActivity.this, "Permission Denied   ", Toast.LENGTH_LONG).show();

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();

        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_white_menu_24);
        }
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.syncState();

        drawerLayout.closeDrawers();


        LinearLayout mammalmenu = findViewById(R.id.mammalmenu);
        LinearLayout birdsmenu = findViewById(R.id.birdsmenu);
        LinearLayout seamenu = findViewById(R.id.seamenu);
        ImageView imageViewTitle = findViewById(R.id.titleImageView);

        mammalmenu.setOnClickListener(v -> {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.content_frame, new HomeFragment(1));
            fragmentTransaction.commit();
            drawerLayout.closeDrawers();
            imageViewTitle.setVisibility(View.GONE);
        });
        seamenu.setOnClickListener(v -> {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.content_frame, new HomeFragment(2));
            fragmentTransaction.commit();
            drawerLayout.closeDrawers();
            imageViewTitle.setVisibility(View.GONE);

        });
        birdsmenu.setOnClickListener(v -> {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, new HomeFragment(3));
            fragmentTransaction.commit();
            drawerLayout.closeDrawers();
            imageViewTitle.setVisibility(View.GONE);

        });
    }
}

