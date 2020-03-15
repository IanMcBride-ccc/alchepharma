package com.example.alchepharma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;

public class IngredientActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);

        Button ingredButtonOne = findViewById(R.id.ingred_button_one);
        ingredButtonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(IngredientActivity.this, R.string.empty_toast, Toast.LENGTH_SHORT).show();
            }
        });

        Button ingredButtonTwo = findViewById(R.id.ingred_button_two);
        ingredButtonTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(IngredientActivity.this, R.string.empty_toast, Toast.LENGTH_SHORT).show();
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
}
