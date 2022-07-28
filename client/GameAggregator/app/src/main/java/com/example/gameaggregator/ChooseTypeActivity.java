package com.example.gameaggregator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

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
                ArrayList<String> lst = new ArrayList<String>();
                if (isOnline) {
                    lst.add("online");
                }
                if (isOffline) {
                    lst.add("offline");
                }
                Data.CURRENT_CATEGORY.getCategoryMap().put("TYPE", lst);
                Log.d("TYPE list", ((ArrayList<String>)Data.CURRENT_CATEGORY.getCategoryMap().get("TYPE")).toString());
                //Intent goNext = new Intent(ChooseAgeActivity.this, ChooseTypeActivity.class);
                //startActivity(goNext);
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