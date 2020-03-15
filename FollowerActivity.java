package com.example.alchepharma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.*;
import android.view.*;
import android.widget.*;

public class FollowerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower);

        Button jobButton = findViewById(R.id.job_button);
        jobButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(FollowerActivity.this, R.string.empty_toast, Toast.LENGTH_SHORT).show();
            }
        });

        Button potionButton = findViewById(R.id.potion_button);
        potionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)  {
                Intent potionIntent = new Intent(view.getContext(), IngredientActivity.class);
                startActivityForResult(potionIntent, 0);
            }
        });

        Button menuButton = findViewById(R.id.menu_button);
        menuButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent menuIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(menuIntent, 0);
            }
        });

        Button optionButton = findViewById(R.id.option_button);
        optionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent optionIntent = new Intent(view.getContext(), OptionActivity.class);
                startActivityForResult(optionIntent, 0);
            }
        });
    }
}
