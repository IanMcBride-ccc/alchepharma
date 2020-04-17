package com.example.alchepharma;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;

public class GatherActivity extends IngredientActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gather);
        
        Button finishButton = findViewById(R.id.finish_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingredBox = 0;
                finish();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        finish();
    }
}
