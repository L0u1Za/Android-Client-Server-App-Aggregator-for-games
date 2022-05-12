package com.example.gameaggregator;

//import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Data {
    static public List<Game> GAMES = new ArrayList<Game>();
    static public List<Game> FAVOURITE_GAMES = new ArrayList<Game>();
    static public Set<Integer> FAVOURITE_GAMES_IDS = new HashSet<>();
    //static public FirebaseFirestore db = FirebaseFirestore.getInstance();
}
