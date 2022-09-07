package com.example.gameaggregator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gameaggregator.R;
import com.google.android.material.textfield.TextInputLayout;

public class SearchActivity extends AppCompatActivity {
    private Button forwardButton, backButton;
    private TextInputLayout textInputLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        forwardButton = (Button) findViewById(R.id.forward);
        backButton = (Button) findViewById(R.id.back);

        textInputLayout = findViewById(R.id.search_input_layout);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(SearchActivity.this, MainActivity.class);
                goBack.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(goBack);
            }
        });
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String request = textInputLayout.getEditText().getText().toString();
                Intent goNext = new Intent(SearchActivity.this, FilteredGamesActivity.class);
                goNext.putExtra("searchType", "name");
                goNext.putExtra("request", request);
                startActivity(goNext);
            }
        });
    }
}