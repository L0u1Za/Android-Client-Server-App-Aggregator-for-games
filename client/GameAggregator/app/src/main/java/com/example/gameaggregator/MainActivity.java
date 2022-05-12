package com.example.gameaggregator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;

import org.json.JSONArray;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MainActivity extends AppCompatActivity {
    private void initializeDirectories() throws IOException {
        File dir = new File(getCacheDir(), "GameAggregator");
        boolean ok;
        if (!dir.exists()) {
            ok = dir.mkdir();
        }
        File favGames = new File(getCacheDir(), "GameAggregator/favourite_games_ids.json");
        if (!favGames.exists()) {
            ok = favGames.createNewFile();
        }
    }
    public void addFavouriteGame(int id)  {
        if (Data.FAVOURITE_GAMES_IDS.contains(id)) {
            return;
        }
        Data.FAVOURITE_GAMES_IDS.add(id);
        JSONArray jsonArray = new JSONArray(Data.FAVOURITE_GAMES_IDS);
        try {
            File file = new File(getCacheDir(), "GameAggregator/favourite_games_ids.json");
            Writer output = null;
            output = new BufferedWriter(new FileWriter(file));
            output.write(jsonArray.toString());
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            GamesLoader.loadFavourite(new FileInputStream(new File(getCacheDir(), "GameAggregator/favourite_games_ids.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void removeFavouriteGame(int id)  {
        if (!Data.FAVOURITE_GAMES_IDS.contains(id)) {
            return;
        }
        Data.FAVOURITE_GAMES_IDS.remove(id);
        JSONArray jsonArray = new JSONArray(Data.FAVOURITE_GAMES_IDS);
        try {
            File file = new File(getCacheDir(), "GameAggregator/favourite_games_ids.json");
            Writer output = null;
            output = new BufferedWriter(new FileWriter(file));
            output.write(jsonArray.toString());
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            GamesLoader.loadFavourite(new FileInputStream(new File(getCacheDir(), "GameAggregator/favourite_games_ids.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            initializeDirectories();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            GamesLoader.load(getAssets().open("game_list.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            GamesLoader.loadFavourite(new FileInputStream(new File(getCacheDir(), "GameAggregator/favourite_games_ids.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}