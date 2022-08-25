package com.example.gameaggregator;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gameaggregator.R;

public class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView gameName;
    public ItemClickListener listener;

    public GameViewHolder(View itemView, ItemClickListener listener)
    {
        super(itemView);

        this.gameName = itemView.findViewById(R.id.game_name);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View view)
    {
        listener.onClick(getAdapterPosition());
    }
    public void bind(Game game) {
        gameName.setText(game.getName());
    }

}