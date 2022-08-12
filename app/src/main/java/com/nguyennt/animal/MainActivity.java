package com.nguyennt.animal;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.nguyennt.animal.ui.gallery.GalleryFragment;
import com.nguyennt.animal.ui.home.HomeFragment;
import com.nguyennt.animal.ui.slideshow.SlideshowFragment;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
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

        fragmentTransaction.replace(R.id.content_frame, new HomeFragment());
        fragmentTransaction.commit();
        drawerLayout.closeDrawers();


        navigationView.setNavigationItemSelectedListener(item -> {
            FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.nav_home:
                    fragmentTransaction1.replace(R.id.content_frame, new HomeFragment());
                    fragmentTransaction1.commit();
                    drawerLayout.closeDrawers();
                    return true;
                case R.id.nav_gallery:
                    fragmentTransaction1.replace(R.id.content_frame, new GalleryFragment());
                    fragmentTransaction1.commit();
                    drawerLayout.closeDrawers();
                    return true;
                case R.id.nav_slideshow:
                    fragmentTransaction1.replace(R.id.content_frame, new SlideshowFragment());
                    fragmentTransaction1.commit();
                    drawerLayout.closeDrawers();
                    return true;
            }

            drawerLayout.openDrawer(GravityCompat.START);
            return false;
        });


    }


}