package com.example.alchepharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    public int playerMoneyVal = 0;
    public int[][] ingredInventory = new int[100][2];
    public int[][] potionInventory = new int[100][2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent menuIntent = new Intent(view.getContext(), FollowerActivity.class);
                startActivityForResult(menuIntent, 0);
                finish();
            }
        });
    }
}
