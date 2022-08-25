package com.nguyennt.animal.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyennt.animal.R;
import com.nguyennt.animal.adapter.GridAdapter;
import com.nguyennt.animal.model.AnimalModel;
import com.nguyennt.animal.ui.detail.DetailFragment;
import com.nguyennt.animal.ui.main.MainActivity;
import com.nguyennt.animal.util.RecyclerItemListener;

import java.util.ArrayList;
import java.util.Objects;


public class HomeFragment extends Fragment {


    static ArrayList<AnimalModel> listModel = new ArrayList<>();

    private static final int REQUEST_CODE = 333;
    private GridAdapter adapter;

    private int type;

    public HomeFragment() {
    }

    public HomeFragment(Bundle bundle) {

        listModel = bundle.getParcelableArrayList("listModel");
        type = bundle.getInt("type");

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        requireActivity().findViewById(R.id.toolbar).setVisibility(View.VISIBLE);
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);


        adapter = new GridAdapter(listModel);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemListener(getContext(), (view1, position) -> {

//                        Intent i = new Intent(view.getContext(), DetailActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("position", position);
                    bundle.putParcelableArrayList("listModel", listModel);

                    // Set Fragmentclass Arguments
                    DetailFragment fragment = new DetailFragment(bundle);
                    Objects.requireNonNull(getActivity()).findViewById(R.id.toolbar).setVisibility(View.GONE);

                    FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction
                            .setCustomAnimations(R.anim.fade_in, 0, 0, R.anim.fade_out)
                            .replace(R.id.content_frame, new DetailFragment(bundle))
                            .addToBackStack("name")
                            .commit();
                }));

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("listModel", listModel);
        bundle.putInt("type", type);
        MainActivity activity = (MainActivity) getActivity();
        Objects.requireNonNull(activity).setBundle(bundle);


        super.onViewCreated(view, savedInstanceState);

        // or  (ImageView) view.findViewById(R.id.foo);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("animalKey", this, (requestKey, bundle) -> {
            // We use a String here, but any type that can be put in a Bundle is supported
            // Do something with the result
            int position = bundle.getInt("position");

            listModel.get(position).liked = bundle.getBoolean("liked");

            adapter.notifyDataSetChanged();
//                adapter.notifyItemChanged(position);

        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == 2) {
                int position = Objects.requireNonNull(data).getIntExtra("index", 0);
                AnimalModel currentData = listModel.get(position);
                boolean dataLiked = data.getBooleanExtra("liked", true);
                listModel.set(position, new AnimalModel(dataLiked, currentData.resource, currentData.name, currentData.detail, currentData.photo));
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


}