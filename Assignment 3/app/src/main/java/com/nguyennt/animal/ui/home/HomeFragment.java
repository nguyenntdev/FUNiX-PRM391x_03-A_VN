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

        requireActivity().findViewById(R.id.toolbar).setVisibility(View.VISIBLE);


        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        if (changed) {
            listModel.clear();
            if (type == 3) {
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
                listModel.add(new AnimalModel(false, R.drawable.ic_crab, "Crab", "Crabs are decapod crustaceans of the infraorder Brachyura, which typically have a very short projecting \"tail\" (abdomen) (Greek: βραχύς, romanized: brachys = short,[2] οὐρά / οura = tail[3]), usually hidden entirely under the thorax. They live in all the world's oceans, in fresh water, and on land, are generally covered with a thick exoskeleton, and have a single pair of pincers. They first appeared during the Jurassic Period.", R.drawable.bg_crab));
                listModel.add(new AnimalModel(false, R.drawable.ic_dolphin, "Dolphin", "A dolphin is an aquatic mammal within the infraorder Cetacea. Dolphin species belong to the families Delphinidae (the oceanic dolphins), Platanistidae (the Indian river dolphins), Iniidae (the New World river dolphins), Pontoporiidae (the brackish dolphins), and the extinct Lipotidae (baiji or Chinese river dolphin). There are 40 extant species named as dolphins.", R.drawable.bg_dolphin));
                listModel.add(new AnimalModel(false, R.drawable.ic_jellyfish, "Jellyfish", "Jellyfish and sea jellies are the informal common names given to the medusa-phase of certain gelatinous members of the subphylum Medusozoa, a major part of the phylum Cnidaria. Jellyfish are mainly free-swimming marine animals with umbrella-shaped bells and trailing tentacles, although a few are anchored to the seabed by stalks rather than being mobile. The bell can pulsate to provide propulsion for highly efficient locomotion. The tentacles are armed with stinging cells and may be used to capture prey and defend against predators. ", R.drawable.bg_jellyfish));
                listModel.add(new AnimalModel(false, R.drawable.ic_octopus, "Octopus", "An octopus (pl: octopuses or octopodes, see below for variants) is a soft-bodied, eight-limbed mollusc of the order Octopoda (/ɒkˈtɒpədə/, ok-TOP-ə-də[3]). The order consists of some 300 species and is grouped within the class Cephalopoda with squids, cuttlefish, and nautiloids. Like other cephalopods, an octopus is bilaterally symmetric with two eyes and a beaked mouth at the center point of the eight limbs.", R.drawable.bg_octopus));
                listModel.add(new AnimalModel(false, R.drawable.ic_red_snapper, "Red snapper", "The northern red snapper (Lutjanus campechanus) is a species of marine ray-finned fish, a snapper belonging to the family Lutjanidae. It is native to the western Atlantic Ocean, the Caribbean Sea, and the Gulf of Mexico, where it inhabits environments associated with reefs. This species is commercially important and is also sought-after as a game fish.[2]", R.drawable.bg_red_snapper));
                listModel.add(new AnimalModel(false, R.drawable.ic_shark, "Shark", "Sharks are a group of elasmobranch fish characterized by a cartilaginous skeleton, five to seven gill slits on the sides of the head, and pectoral fins that are not fused to the head. Modern sharks are classified within the clade Selachimorpha (or Selachii) and are the sister group to the rays. However, the term \"shark\" is also used to refer to extinct shark-like members of the subclass Elasmobranchii, such as hybodonts, that lie outside the modern group.", R.drawable.bg_shark));
                listModel.add(new AnimalModel(false, R.drawable.ic_squid, "Squid", "A squid is a mollusc with an elongated soft body, large eyes, eight arms, and two tentacles in the superorder Decapodiformes. Like all other cephalopods, squid have a distinct head, bilateral symmetry, and a mantle. They are mainly soft-bodied, like octopuses, but have a small internal skeleton in the form of a rod-like gladius or pen, made of chitin.", R.drawable.bg_squid));
                listModel.add(new AnimalModel(false, R.drawable.ic_swordfish, "Swordfish", "Swordfish (Xiphias gladius), also known as broadbills in some countries, are large, highly migratory predatory fish characterized by a long, flat, pointed bill. They are a popular sport fish of the billfish category, though elusive. Swordfish are elongated, round-bodied, and lose all teeth and scales by adulthood. These fish are found widely in tropical and temperate parts of the Atlantic, Pacific, and Indian Oceans, and can typically be found from near the surface to a depth of 550 m (1,800 ft), and exceptionally up to depths of 2,234 m.", R.drawable.bg_swordfish));
                listModel.add(new AnimalModel(false, R.drawable.ic_whale, "Whale", "Whales are a widely distributed and diverse group of fully aquatic placental marine mammals. They are an informal grouping within the infraorder Cetacea, which usually excludes dolphins and porpoises. Whales, dolphins and porpoises belong to the order Cetartiodactyla, which consists of even-toed ungulates. Their closest non-cetacean living relatives are the hippopotamuses, from which they and other cetaceans diverged about 54 million years ago. ", R.drawable.bg_whale));

            } else if (type == 1) {
                listModel.add(new AnimalModel(false, R.drawable.ic_eagle, "Eagle", "Eagle is the common name for many large birds of prey of the family Accipitridae. Eagles belong to several groups of genera, some of which are closely related. Most of the 60 species of eagle are from Eurasia and Africa.[1] Outside this area, just 14 species can be found—2 in North America, 9 in Central and South America, and 3 in Australia.", R.drawable.bg_eagle));
                listModel.add(new AnimalModel(false, R.drawable.ic_falcon, "Falcon", "Falcons (/ˈfɒlkən, ˈfɔːl-, ˈfæl-/) are birds of prey in the genus Falco, which includes about 40 species. Falcons are widely distributed on all continents of the world except Antarctica, though closely related raptors did occur there in the Eocene.[1]\n" +
                        "\n" +
                        "Adult falcons have thin, tapered wings, which enable them to fly at high speed and change direction rapidly. Fledgling falcons, in their first year of flying, have longer flight feathers, which make their configuration more like that of a general-purpose bird such as a broad wing. This makes flying easier while learning the exceptional skills required to be effective hunters as adults.", R.drawable.bg_falcon));
                listModel.add(new AnimalModel(false, R.drawable.ic_hawk, "Hawk", "Hawks are birds of prey of the family Accipitridae. They are widely distributed and are found on all continents except Antarctica.[1]\n" +
                        "\n" +
                        "The subfamily Accipitrinae includes goshawks, sparrowhawks, sharp-shinned hawks and others. This subfamily are mainly woodland birds with long tails and high visual acuity. They hunt by dashing suddenly from a concealed perch.[2]\n" +
                        "In America, members of the Buteo group are also called hawks; this group is called buzzards in other parts of the world. Generally, buteos have broad wings and sturdy builds. They are relatively larger-winged, shorter-tailed and fly further distances in open areas than accipiters. Buteos descend or pounce on their prey rather than hunting in a fast horizontal pursuit.", R.drawable.bg_hawk));
                listModel.add(new AnimalModel(false, R.drawable.ic_parrot, "Parrot", "Parrots, also known as psittacines (/ˈsɪtəsaɪnz/),[1][2] are birds of the roughly 398 species[3] in 92 genera comprising the order Psittaciformes (/ˈsɪtəsɪfɔːrmiːz/), found mostly in tropical and subtropical regions. The order is subdivided into three superfamilies: the Psittacoidea (\"true\" parrots), the Cacatuoidea (cockatoos), and the Strigopoidea (New Zealand parrots). ", R.drawable.bg_parrot));
                listModel.add(new AnimalModel(false, R.drawable.ic_peacock, "Peacock", "Peafowl is a common name for three bird species in the genera Pavo and Afropavo within the tribe Pavonini of the family Phasianidae, the pheasants and their allies. Male peafowl are referred to as peacocks, and female peafowl are referred to as peahens, even though peafowl of either sex are often referred to colloquially as \"peacocks\".[1]", R.drawable.bg_peacock));
                listModel.add(new AnimalModel(false, R.drawable.ic_penguin, "Penguin", "Penguins (order Sphenisciformes /sfɪˈnɪsɪfɔːrmiːz/, family Spheniscidae /sfɪˈnɪsɪdiː/) are a group of aquatic flightless birds. They live almost exclusively in the Southern Hemisphere: only one species, the Galápagos penguin, is found north of the Equator. Highly adapted for life in the water, penguins have countershaded dark and white plumage and flippers for swimming.", R.drawable.bg_penguin));
                listModel.add(new AnimalModel(false, R.drawable.ic_raven, "Raven", "A raven is any of several larger-bodied bird species of the genus Corvus. These species do not form a single taxonomic group within the genus. There is no consistent distinction between \"crows\" and \"ravens\", and these appellations have been assigned to different species chiefly on the basis of their size.", R.drawable.bg_raven));
                listModel.add(new AnimalModel(false, R.drawable.ic_sparrow, "Sparrow", "Old World sparrows are a group of small passerine birds forming the family Passeridae. They are also known as true sparrows, a name also used for a particular genus of the family, Passer.[1] They are distinct from both the New World sparrows, in the family Passerellidae, and from a few other birds sharing their name, such as the Java sparrow of the family Estrildidae.", R.drawable.bg_sparrow));
                listModel.add(new AnimalModel(false, R.drawable.ic_woodpecker, "Woodpecker", "Woodpeckers are part of the family Picidae, which also includes the piculets, wrynecks, and sapsuckers. Members of this family are found worldwide, except for Australia, New Guinea, New Zealand, Madagascar, and the extreme polar regions. Most species live in forests or woodland habitats, although a few species are known that live in treeless areas, such as rocky hillsides and deserts, and the Gila woodpecker specialises in exploiting cacti.", R.drawable.bg_woodpecker));

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