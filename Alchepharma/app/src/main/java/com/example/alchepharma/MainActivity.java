package com.example.alchepharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPref";
    public static final String PLAYER_MON = "";

    public int playerMoneyVal = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();

        Button startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent menuIntent = new Intent(view.getContext(), FollowerActivity.class);
                startActivityForResult(menuIntent, 0);
                finish();
            }
        });
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        playerMoneyVal = sharedPreferences.getInt(PLAYER_MON, 0);
        if (playerMoneyVal > 999999) { playerMoneyVal = 999999; }
    }
}
