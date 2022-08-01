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
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();

        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_white_menu_24);
        }
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.syncState();

        fragmentTransaction.replace(R.id.content_frame, new HomeFragment());
        fragmentTransaction.commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragmentTransaction.replace(R.id.content_frame, new HomeFragment());
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_gallery:
                        fragmentTransaction.replace(R.id.content_frame, new GalleryFragment());
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.nav_slideshow:
                        fragmentTransaction.replace(R.id.content_frame, new SlideshowFragment());
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        return true;
                }

                drawerLayout.openDrawer(GravityCompat.START);
                return false;
            }
        });


    }


}