package com.nguyennt.animal.item;

import com.nguyennt.animal.R;
import com.nguyennt.animal.model.AnimalModel;

import java.util.ArrayList;

public class ItemModel {
    private ArrayList<AnimalModel> listBird = new ArrayList<>();
    private ArrayList<AnimalModel> listSea = new ArrayList<>();
    private ArrayList<AnimalModel> listMammal = new ArrayList<>();

    public ItemModel() {
        listBird.add(new AnimalModel(false, R.drawable.ic_dog, "dog", "The dog or domestic dog (Canis familiaris[4][5] or Canis lupus familiaris[5]) is a domesticated descendant of the wolf. The dog is derived from an ancient, extinct wolf,[6][7] and the modern wolf is the dog's nearest living relative.[8] The dog was the first species to be domesticated,[9][8] by hunter–gatherers over 15,000 years ago,[7] before the development of agriculture.[1] Due to their long association with humans, dogs have expanded to a large number of domestic individuals[10] and gained the ability to thrive on a starch-rich diet that would be inadequate for other canids.[11]", R.drawable.bg_dog));
        listBird.add(new AnimalModel(false, R.drawable.ic_goose, "goose", "", R.drawable.bg_goose));
        listBird.add(new AnimalModel(false, R.drawable.ic_ladybug, "ladybug", "", R.drawable.bg_ladybug));
        listBird.add(new AnimalModel(false, R.drawable.ic_elephant, "elephant", "", R.drawable.bg_elephant));
        listBird.add(new AnimalModel(false, R.drawable.ic_dolphin, "dolphin", "", R.drawable.bg_dolphin));
        listBird.add(new AnimalModel(false, R.drawable.ic_turtle, "turtle", "", R.drawable.bg_turtle));
        listBird.add(new AnimalModel(false, R.drawable.ic_pig, "pig", "", R.drawable.bg_pig));
        listBird.add(new AnimalModel(false, R.drawable.ic_dragonfly, "dragonfly", "", R.drawable.bg_dragonfly));
        listBird.add(new AnimalModel(false, R.drawable.ic_penguin, "penguin", "", R.drawable.bg_penguin));
//
//        listSea.add(new AnimalModel(false, R.drawable.bg_dolphin, "fish", "", R.drawable.bg_fish));
//        listSea.add(new AnimalModel(false, R.drawable.bg_dolphin, "fish", "", R.drawable.bg_fish));
//        listSea.add(new AnimalModel(false, R.drawable.bg_dolphin, "fish", "", R.drawable.bg_fish));
//        listSea.add(new AnimalModel(false, R.drawable.bg_dolphin, "fish", "", R.drawable.bg_fish));
//        listSea.add(new AnimalModel(false, R.drawable.bg_dolphin, "fish", "", R.drawable.bg_fish));
//        listSea.add(new AnimalModel(false, R.drawable.bg_dolphin, "fish", "", R.drawable.bg_fish));
//        listSea.add(new AnimalModel(false, R.drawable.bg_dolphin, "fish", "", R.drawable.bg_fish));
//        listSea.add(new AnimalModel(false, R.drawable.bg_dolphin, "fish", "", R.drawable.bg_fish));
//        listSea.add(new AnimalModel(false, R.drawable.bg_dolphin, "fish", "", R.drawable.bg_fish));
//        listSea.add(new AnimalModel(false, R.drawable.bg_dolphin, "fish", "", R.drawable.bg_fish));
//        listSea.add(new AnimalModel(false, R.drawable.bg_dolphin, "fish", "", R.drawable.bg_fish));
//        listSea.add(new AnimalModel(false, R.drawable.bg_dolphin, "fish", "", R.drawable.bg_fish));

    }
}
