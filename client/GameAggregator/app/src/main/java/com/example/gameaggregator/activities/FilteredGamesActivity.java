package com.example.gameaggregator.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtered_games);

        gameList = Search.find(Data.CURRENT_CATEGORY);
        Log.d("gameList", gameList.toString());
        recyclerView = findViewById(R.id.games_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GameAdapter adapter = new GameAdapter(this, gameList, this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onClick(int position) {
        Intent intent = new Intent(FilteredGamesActivity.this, GameDetailsActivity.class);
        intent.putExtra("game", gameList.get(position));
        startActivity(intent);
    }
}