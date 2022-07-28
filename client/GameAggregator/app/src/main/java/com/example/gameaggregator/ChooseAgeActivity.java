package com.example.gameaggregator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class ChooseAgeActivity extends AppCompatActivity {
    private CheckBox zero, six, twelve, sixteen, eighteen;
    private boolean isZero, isSix, isTwelve, isSixteen, isEighteen;
    private Button forwardButton, backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_age);

        isZero = false;
        isSix = false;
        isTwelve = false;
        isSixteen = false;
        isEighteen = false;

        zero = (CheckBox) findViewById(R.id.zero);
        six = (CheckBox) findViewById(R.id.six);
        twelve = (CheckBox) findViewById(R.id.twelve);
        sixteen = (CheckBox) findViewById(R.id.sixteen);
        eighteen = (CheckBox) findViewById(R.id.eighteen);

        forwardButton = (Button) findViewById(R.id.forward);
        backButton = (Button) findViewById(R.id.back);

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> lst = new ArrayList<String>();
                if (isZero) {
                    lst.add("zero");
                }
                if (isSix) {
                    lst.add("six");
                }
                if (isTwelve) {
                    lst.add("twelve");
                }
                if (isSixteen) {
                    lst.add("sixteen");
                }
                if (isEighteen) {
                    lst.add("eighteen");
                }
                Data.CURRENT_CATEGORY.getCategoryMap().put("AGE", lst);
                Log.d("AGE list", ((ArrayList<String>)Data.CURRENT_CATEGORY.getCategoryMap().get("AGE")).toString());
                Intent goNext = new Intent(ChooseAgeActivity.this, ChooseTypeActivity.class);
                startActivity(goNext);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(ChooseAgeActivity.this, ChooseEventActivity.class);
                goBack.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(goBack);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isZero ^= true;
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSix ^= true;
            }
        });
        twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTwelve ^= true;
            }
        });
        sixteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSixteen ^= true;
            }
        });
        eighteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEighteen ^= true;
            }
        });
    }
}