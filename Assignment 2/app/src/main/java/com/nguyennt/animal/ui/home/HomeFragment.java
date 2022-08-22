package com.nguyennt.animal.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyennt.animal.R;
import com.nguyennt.animal.adapter.GridAdapter;
import com.nguyennt.animal.model.AnimalModel;
import com.nguyennt.animal.ui.detail.DetailFragment;
import com.nguyennt.animal.util.RecyclerItemListener;

import java.util.ArrayList;
import java.util.Objects;


public class HomeFragment extends Fragment {


    static final ArrayList<AnimalModel> listModel = new ArrayList<>();
    private static final int REQUEST_CODE = 333;
    private GridAdapter adapter;
    private GridAdapter gridAdapter;
    private boolean changed;

    private int type;

    public HomeFragment() {
    }

    public HomeFragment(int type) {
        if (this.type != type) {
            this.type = type;
            changed = true;
        } else {
            changed = false;
        }
    }


    public static HomeFragment newInstance() {


        return new HomeFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Objects.requireNonNull(getActivity()).findViewById(R.id.toolbar).setVisibility(View.VISIBLE);


        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        if (changed) {
            listModel.clear();
            if (type == 1) {
                listModel.add(new AnimalModel(false, R.drawable.ic_cat, "Cat", "The cat (Felis catus) is a domestic species of small carnivorous mammal.[1][2] It is the only domesticated species in the family Felidae and is often referred to as the domestic cat to distinguish it from the wild members of the family.[4] A cat can either be a house cat, a farm cat or a feral cat; the latter ranges freely and avoids human contact.[5] Domestic cats are valued by humans for companionship and their ability to kill rodents. About 60 cat breeds are recognized by various cat registries.[6]", R.drawable.bg_cat));
                listModel.add(new AnimalModel(false, R.drawable.ic_dog, "Dog", "The dog or domestic dog (Canis familiaris[4][5] or Canis lupus familiaris[5]) is a domesticated descendant of the wolf. The dog is derived from an ancient, extinct wolf,[6][7] and the modern wolf is the dog's nearest living relative.[8] The dog was the first species to be domesticated,[9][8] by hunter–gatherers over 15,000 years ago,[7] before the development of agriculture.[1] Due to their long association with humans, dogs have expanded to a large number of domestic individuals[10] and gained the ability to thrive on a starch-rich diet that would be inadequate for other canids.[11]", R.drawable.bg_dog));
                listModel.add(new AnimalModel(false, R.drawable.ic_hippotamus, "Hippopotamus", "The hippopotamus (/ˌhɪpəˈpɒtəməs/ HIP-ə-POT-ə-məs;[3] Hippopotamus amphibius), also called the hippo, common hippopotamus, or river hippopotamus, is a large semiaquatic mammal native to sub-Saharan Africa. It is one of only two extant species in the family Hippopotamidae, the other being the pygmy hippopotamus (Choeropsis liberiensis or Hexaprotodon liberiensis). Its name comes from the ancient Greek for \"river horse\" (ἱπποπόταμος).", R.drawable.bg_hippotamus));
                listModel.add(new AnimalModel(false, R.drawable.ic_lion, "Lion", "The lion (Panthera leo) is a large cat of the genus Panthera native to Africa and India. It has a muscular, broad-chested body, short, rounded head, round ears, and a hairy tuft at the end of its tail. It is sexually dimorphic; adult male lions are larger than females and have a prominent mane. It is a social species, forming groups called prides. A lion's pride consists of a few adult males, related females, and cubs. Groups of female lions usually hunt together, preying mostly on large ungulates. The lion is an apex and keystone predator; although some lions scavenge when opportunities occur and have been known to hunt humans, the species typically does not actively seek out and prey on humans.", R.drawable.bg_lion));
                listModel.add(new AnimalModel(false, R.drawable.ic_monkey, "Monkey", "Monkey is a common name that may refer to most mammals of the infraorder Simiiformes, also known as the simians. Traditionally, all animals in the group now known as simians are counted as monkeys except the apes, which constitutes an incomplete paraphyletic grouping; however, in the broader sense based on cladistics, apes (Hominoidea) are also included, making the terms monkeys and simians synonyms in regards to their scope.[citation needed][3]", R.drawable.bg_monkey));
                listModel.add(new AnimalModel(false, R.drawable.ic_rabbit, "Rabbit", "Rabbits, also known as bunnies or bunny rabbits, are small mammals in the family Leporidae (which also contains the hares) of the order Lagomorpha (which also contains the pikas). Oryctolagus cuniculus includes the European rabbit species and its descendants, the world's 305 breeds[1] of domestic rabbit. Sylvilagus includes 13 wild rabbit species, among them the seven types of cottontail. The European rabbit, which has been introduced on every continent except Antarctica, is familiar throughout the world as a wild prey animal and as a domesticated form of livestock and pet. With its widespread effect on ecologies and cultures, the rabbit is, in many areas of the world, a part of daily life—as food, clothing, a companion, and a source of artistic inspiration.", R.drawable.bg_rabbit));
                listModel.add(new AnimalModel(false, R.drawable.ic_tiger, "Tiger", "The tiger (Panthera tigris) is the largest living cat species and a member of the genus Panthera. It is most recognisable for its dark vertical stripes on orange fur with a white underside. An apex predator, it primarily preys on ungulates, such as deer and wild boar. It is territorial and generally a solitary but social predator, requiring large contiguous areas of habitat to support its requirements for prey and rearing of its offspring. Tiger cubs stay with their mother for about two years and then become independent, leaving their mother's home range to establish their own.", R.drawable.bg_tiger));
                listModel.add(new AnimalModel(false, R.drawable.ic_turtle, "Turtle", "Turtles are an order of reptiles known as Testudines, characterized by a shell developed mainly from their ribs. Modern turtles are divided into two major groups, the side-necked turtles and hidden neck turtles, which differ in the way the head retracts. There are 360 living and recently extinct species of turtles, including land-dwelling tortoises and freshwater terrapins. They are found on most continents, some islands and, in the case of sea turtles, much of the ocean. Like other reptiles, birds, and mammals, they breathe air and do not lay eggs underwater, although many species live in or around water. Genetic evidence typically places them in close relation to crocodilians and birds.", R.drawable.bg_turtle));
                listModel.add(new AnimalModel(false, R.drawable.ic_zibra, "Zebra", "Zebras (US: /ˈziːbrəz/, UK: /ˈzɛbrəz, ˈziː-/)[1] (subgenus Hippotigris) are African equines with distinctive black-and-white striped coats. There are three living species: the Grévy's zebra (Equus grevyi), plains zebra (E. quagga), and the mountain zebra (E. zebra). Zebras share the genus Equus with horses and asses, the three groups being the only living members of the family Equidae.", R.drawable.bg_zebra));

            } else if (type == 2) {
                listModel.add(new AnimalModel(false, R.drawable.ic_goose, "goose", "", R.drawable.bg_goose));
                listModel.add(new AnimalModel(false, R.drawable.ic_ladybug, "ladybug", "", R.drawable.bg_ladybug));
                listModel.add(new AnimalModel(false, R.drawable.ic_elephant, "elephant", "", R.drawable.bg_elephant));
                listModel.add(new AnimalModel(false, R.drawable.ic_dolphin, "dolphin", "", R.drawable.bg_dolphin));
                listModel.add(new AnimalModel(false, R.drawable.ic_turtle, "turtle", "", R.drawable.bg_turtle));

            } else if (type == 3) {
                listModel.add(new AnimalModel(false, R.drawable.ic_dog, "dog", "The dog or domestic dog (Canis familiaris[4][5] or Canis lupus familiaris[5]) is a domesticated descendant of the wolf. The dog is derived from an ancient, extinct wolf,[6][7] and the modern wolf is the dog's nearest living relative.[8] The dog was the first species to be domesticated,[9][8] by hunter–gatherers over 15,000 years ago,[7] before the development of agriculture.[1] Due to their long association with humans, dogs have expanded to a large number of domestic individuals[10] and gained the ability to thrive on a starch-rich diet that would be inadequate for other canids.[11]", R.drawable.bg_dog));
                listModel.add(new AnimalModel(false, R.drawable.ic_goose, "goose", "", R.drawable.bg_goose));
                listModel.add(new AnimalModel(false, R.drawable.ic_ladybug, "ladybug", "", R.drawable.bg_ladybug));

            }
        }
        adapter = new GridAdapter(getContext(), listModel);

        LinearLayoutCompat linearLayoutCompat = view.findViewById(R.id.LinearLayoutCompat);


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
                    getActivity().findViewById(R.id.toolbar).setVisibility(View.GONE);

                    FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction
                            .setCustomAnimations(R.anim.slide_in, 0, 0, 0)
                            .replace(R.id.content_frame, new DetailFragment(bundle))
                            .addToBackStack("name")
                            .commit();
                }));

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