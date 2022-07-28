package com.example.gameaggregator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class ChooseEventActivity extends AppCompatActivity {
    private CheckBox party, family, alone, road, child;
    private boolean isParty, isFamily, isAlone, isRoad, isChild;
    private Button forwardButton, backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_event);

        Data.CURRENT_CATEGORY = new Category();

        isParty = false;
        isFamily = false;
        isAlone = false;
        isRoad = false;
        isChild = false;

        party = (CheckBox) findViewById(R.id.party);
        family  = (CheckBox) findViewById(R.id.family);
        alone = (CheckBox) findViewById(R.id.alone);
        road = (CheckBox) findViewById(R.id.road);
        child = (CheckBox) findViewById(R.id.child);

        forwardButton = (Button) findViewById(R.id.forward);
        backButton = (Button) findViewById(R.id.back);

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> lst = new ArrayList<String>();
                if (isParty) {
                    lst.add("party");
                }
                if (isFamily) {
                    lst.add("family");
                }
                if (isAlone) {
                    lst.add("alone");
                }
                if (isRoad) {
                    lst.add("road");
                }
                if (isChild) {
                    lst.add("child");
                }
                Data.CURRENT_CATEGORY.getCategoryMap().put("EVENT", lst);
                Log.d("EVENT list", ((ArrayList<String>)Data.CURRENT_CATEGORY.getCategoryMap().get("EVENT")).toString());
                Intent goNext = new Intent(ChooseEventActivity.this, ChooseAgeActivity.class);
                startActivity(goNext);
            }
        });
        party.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isParty ^= true;
            }
        });
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFamily ^= true;
            }
        });
        alone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAlone ^= true;
            }
        });
        road.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRoad ^= true;
            }
        });
        child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isChild ^= true;
            }
        });
    }
}