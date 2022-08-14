package com.example.gameaggregator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameViewHolder>{
    private LayoutInflater inflater;
    private List<Game> gameList;

    public GameAdapter(Context context, List<Game> games) {
        this.gameList = games;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.game_in_search, parent, false);
        return new GameViewHolder(view);
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
