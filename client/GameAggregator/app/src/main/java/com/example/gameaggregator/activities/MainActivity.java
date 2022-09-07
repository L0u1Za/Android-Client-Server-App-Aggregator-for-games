package com.example.gameaggregator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gameaggregator.Data;
import com.example.gameaggregator.GamesLoader;
import com.example.gameaggregator.R;

import org.json.JSONArray;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MainActivity extends AppCompatActivity {
    private Button searchNameButton, searchFilteredButton;

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
        searchNameButton = (Button) findViewById(R.id.name_search);
        searchFilteredButton = (Button) findViewById(R.id.filtered_search);
        searchNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(start);
            }
        });
        searchFilteredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(MainActivity.this, ChooseEventActivity.class);
                startActivity(start);
            }
        });

    }
}