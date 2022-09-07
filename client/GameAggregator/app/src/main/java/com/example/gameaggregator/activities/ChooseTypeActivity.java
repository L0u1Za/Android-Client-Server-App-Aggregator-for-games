package com.example.gameaggregator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.gameaggregator.Data;
import com.example.gameaggregator.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ChooseTypeActivity extends AppCompatActivity {
    private CheckBox online, offline;
    private boolean isOnline, isOffline;
    private Button forwardButton, backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_type);

        isOnline = false;
        isOffline = false;

        online = (CheckBox) findViewById(R.id.online);
        offline  = (CheckBox) findViewById(R.id.offline);

        forwardButton = (Button) findViewById(R.id.forward);
        backButton = (Button) findViewById(R.id.back);

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> lst1 = new ArrayList<String>();
                ArrayList<String> lst2 = new ArrayList<String>();
                if (isOnline) {
                    lst1.add("online");
                }
                if (isOffline) {
                    lst2.add("offline");
                }
                Data.CURRENT_CATEGORY.getCategoryMap().put("GAME_TYPE", new HashMap<String, Object> (){
                    {
                        put("ONLINE", lst1);
                        put("OFFLINE", lst2);
                    }
                });
                //Log.d("ONLINE list", ((ArrayList<String>)Data.CURRENT_CATEGORY.getCategoryMap().get("GAME_TYPE").get("ONLINE")).toString());
                Intent goNext = new Intent(ChooseTypeActivity.this, FilteredGamesActivity.class);
                goNext.putExtra("searchType", "categories");
                startActivity(goNext);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(ChooseTypeActivity.this, ChooseAgeActivity.class);
                goBack.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(goBack);
            }
        });
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOnline ^= true;
            }
        });
        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOffline ^= true;
            }
        });
    }
}