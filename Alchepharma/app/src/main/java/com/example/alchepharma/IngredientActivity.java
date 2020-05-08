package com.example.alchepharma;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;

public class IngredientActivity extends MainActivity {

    public boolean stateFailed = false;
    public boolean stirOnce = false;
    public boolean ingredBox = true;
    public static final String ingredBoxText = "ingredient";
    public int ingredValOne = 0;
    public static final String VarOne = "varOne";
    public int ingredValTwo = 0;
    public static final String VarTwo = "varTwo";
    public int minVal = 40;
    public int maxVal = 70;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);
        if (stateFailed = true) { playerMoneyVal = playerMoneyVal; }
        unpackIntent();
        saveData();

        Button ingredButtonOne = findViewById(R.id.ingred_button_one);
        ingredButtonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ingredBox = true;
                Intent gatherIntent = new Intent(view.getContext(), GatherActivity.class);
                gatherIntent.putExtra(ingredBoxText, ingredBox);
                gatherIntent.putExtra(VarOne, ingredValOne);
                startActivityForResult(gatherIntent, 0);
            }
        });

        Button ingredButtonTwo = findViewById(R.id.ingred_button_two);
        ingredButtonTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ingredBox = false;
                Intent gatherIntent = new Intent(view.getContext(), GatherActivity.class);
                gatherIntent.putExtra(ingredBoxText, ingredBox);
                gatherIntent.putExtra(VarTwo, ingredValTwo);
                startActivityForResult(gatherIntent, 0);
            }
        });

        Button startButton = findViewById(R.id.stir_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent stirIntent = new Intent(view.getContext(), StirringActivity.class);
                startActivityForResult(stirIntent, 0);
            }
        });

        Button backButton = findViewById(R.id.follower_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent backIntent = new Intent(view.getContext(), FollowerActivity.class);
                startActivityForResult(backIntent, 0);
            }
        });
    }

    public void unpackIntent() {
        Intent appIntent = getIntent();
        appIntent.getBooleanExtra(ingredBoxText, ingredBox);
        if (ingredBox = true) { appIntent.getIntExtra(VarOne, ingredValOne); }
        else { appIntent.getIntExtra(VarTwo, ingredValTwo); }
        ingredBox = true;
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(PLAYER_MON, playerMoneyVal);
        editor.apply();
    }
}
