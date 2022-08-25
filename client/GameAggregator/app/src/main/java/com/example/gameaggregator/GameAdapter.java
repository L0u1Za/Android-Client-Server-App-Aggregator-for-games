package com.example.gameaggregator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gameaggregator.activities.ChooseTypeActivity;
import com.example.gameaggregator.activities.FilteredGamesActivity;
import com.example.gameaggregator.activities.GameDetailsActivity;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameViewHolder>{
    private ItemClickListener listener;

    private LayoutInflater inflater;
    private List<Game> gameList;

    public GameAdapter(Context context, List<Game> games, ItemClickListener listener) {
        this.gameList = games;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.game_in_search, parent, false);
        return new GameViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        holder.bind(gameList.get(position));
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }
}
