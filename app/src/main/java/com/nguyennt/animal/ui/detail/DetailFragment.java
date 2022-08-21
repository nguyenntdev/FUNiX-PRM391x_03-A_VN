package com.nguyennt.animal.ui.detail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import com.nguyennt.animal.R;
import com.nguyennt.animal.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class DetailFragment extends Fragment {


    private int position;
    private ViewPager2 viewPager2;
    private ArrayList listModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public DetailFragment(Bundle savedInstanceState) {
        position = savedInstanceState.getInt("position", position);
        listModel = savedInstanceState.getParcelableArrayList("listModel");
    }


    public void newInstance(Bundle savedInstanceState) {
        savedInstanceState.getInt("position", position);
        listModel = savedInstanceState.getParcelableArrayList("listModel");

    }

    public ActionBar actionBar;
    public Toolbar toolbar;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        FrameLayout detailsLayout = new FrameLayout(getContext());
        detailsLayout.setVisibility(View.GONE);

        ImageView backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        toolbar = ((AppCompatActivity)getActivity()).findViewById(R.id.toolbar2);

        toolbar.setTitle("title");
//        // calling the action bar
//        actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
//        actionBar.setTitle("title");
        // showing the back button in action bar
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity)requireActivity()).getSupportActionBar() != null){
            ((AppCompatActivity)requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity)requireActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        viewPager2 = view.findViewById(R.id.viewPager2);



        // Object of ViewPager2Adapter
        // this will passes the
        // context to the constructor
        // of ViewPager2Adapter
        ViewPagerAdapter viewPager2Adapter = new ViewPagerAdapter(getContext(), listModel, this);

        // adding the adapter to viewPager2
        // to show the views in recyclerview
        viewPager2.setAdapter(viewPager2Adapter);
        viewPager2.setCurrentItem(position, false);

        // To get swipe event of viewpager2
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            // This method is triggered when there is any scrolling activity for the current page
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            // triggered when you select a new page
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            // triggered when there is
            // scroll state will be changed
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();


        super.onViewCreated(view, savedInstanceState);

        // or  (ImageView) view.findViewById(R.id.foo);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }


//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            Intent intent = new Intent();
//            intent.putExtra("index", address);
//            intent.putExtra("liked", liked);
//            requireActivity().setResult(2, intent);
//            requireActivity().finish();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}