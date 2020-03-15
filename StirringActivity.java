package com.example.alchepharma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;

public class StirringActivity extends IngredientActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stirring);

        Button backButton = findViewById(R.id.follower_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent backIntent = new Intent(view.getContext(), FollowerActivity.class);
                startActivityForResult(backIntent, 0);
            }
        });
    }
}
