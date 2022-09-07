package com.example.gameaggregator.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gameaggregator.Data;
import com.example.gameaggregator.Game;
import com.example.gameaggregator.GameAdapter;
import com.example.gameaggregator.ItemClickListener;
import com.example.gameaggregator.R;
import com.example.gameaggregator.Search;

import java.util.ArrayList;
import java.util.List;

public class FilteredGamesActivity extends AppCompatActivity implements ItemClickListener {
    private List<Game> gameList;
    private RecyclerView recyclerView;
    private Button homeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtered_games);
        Bundle data = getIntent().getExtras();
        String searchType = data.getString("searchType");
        if (searchType.equals("categories")) {
            gameList = Search.find(Data.CURRENT_CATEGORY);
        } else if (searchType.equals("name")) {
            String request = data.getString("request");
            gameList = Search.find(request);
        }
        Log.d("gameList", gameList.toString());
        recyclerView = findViewById(R.id.games_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GameAdapter adapter = new GameAdapter(this, gameList, this);
        recyclerView.setAdapter(adapter);

        homeButton = findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goHome = new Intent(FilteredGamesActivity.this, MainActivity.class);
                //goHome.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(goHome);
            }
        });
    }
    @Override
    public void onClick(int position) {
        Intent intent = new Intent(FilteredGamesActivity.this, GameDetailsActivity.class);
        intent.putExtra("game", gameList.get(position));
        startActivity(intent);
    }
}