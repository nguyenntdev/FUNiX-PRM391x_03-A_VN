package com.nguyennt.animal.ui.detail;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.widget.Toolbar;

import com.nguyennt.animal.R;
import com.nguyennt.animal.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class DetailFragment extends Fragment {


    private int position;
    private ArrayList listModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public DetailFragment(Bundle savedInstanceState) {
        position = savedInstanceState.getInt("position", position);
        listModel = savedInstanceState.getParcelableArrayList("listModel");
    }


    public Toolbar toolbar;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FrameLayout detailsLayout = new FrameLayout(getContext());
        detailsLayout.setVisibility(View.GONE);


        toolbar = ((AppCompatActivity) requireActivity()).findViewById(R.id.toolbar2);

        toolbar.setTitle("title");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity)requireActivity()).getSupportActionBar() != null){
            Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setDisplayShowHomeEnabled(true);
        }

        toolbar.setNavigationOnClickListener(view1 -> requireActivity().onBackPressed());

        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager2);

        ViewPagerAdapter viewPager2Adapter = new ViewPagerAdapter(getContext(), listModel, this);

        viewPager2.setAdapter(viewPager2Adapter);
        viewPager2.setCurrentItem(position, false);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).show();

        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

}