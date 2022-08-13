package com.nguyennt.animal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.nguyennt.animal.ui.gallery.GalleryFragment;
import com.nguyennt.animal.ui.home.HomeFragment;
import com.nguyennt.animal.ui.slideshow.SlideshowFragment;

public class MainActivity extends AppCompatActivity {


    public static final String mBroadcastAction = "STRING_BROADCAST_ACTION";
    private DrawerLayout drawerLayout;
    private IntentFilter mIntentFilter;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        String state, number, message;

        @Override

        public void onReceive(Context context, Intent intent) {
            state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                message = "phone is ringing";
                Toast.makeText(context, "Incoming Call From:" + number, Toast.LENGTH_SHORT).show();
            }
            if ((state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))) {
                Toast.makeText(context, "Call Received", Toast.LENGTH_SHORT).show();
            }
            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                message += "phone is idled";
                Toast.makeText(context, "Idled", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //Start MyService cùng với IntentFilter
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(mBroadcastAction);
        Intent serviceIntent = new Intent(this, MyService.class);
        startService(serviceIntent);
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

        mammalmenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.content_frame, new HomeFragment());
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();
                imageViewTitle.setVisibility(View.GONE);
            }
        });
        seamenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.content_frame, new GalleryFragment());
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();
                imageViewTitle.setVisibility(View.GONE);

            }
        });
        birdsmenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, new SlideshowFragment());
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();
                imageViewTitle.setVisibility(View.GONE);

            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(mReceiver);
        super.onPause();
    }
}

