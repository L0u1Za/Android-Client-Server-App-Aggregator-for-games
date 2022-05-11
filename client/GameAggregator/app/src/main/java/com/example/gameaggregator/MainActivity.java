package com.example.gameaggregator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            GamesLoader.load(getAssets().open("game_list.json"), Data.GAMES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}