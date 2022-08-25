package com.example.gameaggregator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gameaggregator.Game;
import com.example.gameaggregator.ItemClickListener;
import com.example.gameaggregator.R;

import java.util.List;

public class GameDetailsActivity extends AppCompatActivity{
    private Button homeButton;

    private TextView gameName;
    private TextView gameDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        Bundle data = getIntent().getExtras();
        Game game = data.getParcelable("game");

        gameName = findViewById(R.id.game_name);
        gameDescription = findViewById(R.id.game_description);

        gameName.setText(game.getName());
        gameDescription.setText(game.getDescription());

        homeButton = findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goHome = new Intent(GameDetailsActivity.this, MainActivity.class);
                //goHome.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(goHome);
            }
        });
    }
}