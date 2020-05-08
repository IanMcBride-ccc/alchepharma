package com.example.alchepharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.os.*;

public class StirringActivity extends IngredientActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;

    private int stirFry = 0;
    private int pointerX = 0;
    private int scaleX = 1;

    private TextView testStirView;

    private TextView userTimerView;
    private CountDownTimer stirTimer;
    private int userTimeLeft = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stirring);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        userTimerView = findViewById(R.id.timerReminder);
        testStirView = findViewById(R.id.stir_review);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stirFryUpdater();
                button1.setEnabled(false);
                button2.setEnabled(true);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stirFryUpdater();
                button2.setEnabled(false);
                button3.setEnabled(true);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stirFryUpdater();
                button3.setEnabled(false);
                button4.setEnabled(true);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stirFryUpdater();
                button4.setEnabled(false);
                button5.setEnabled(true);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stirFryUpdater();
                button5.setEnabled(false);
                button6.setEnabled(true);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stirFryUpdater();
                button6.setEnabled(false);
                button1.setEnabled(true);
            }
        });

        startTimer();
    }

    @Override
    public void onPause() {
        super.onPause();
        stateFailed = true;
        finish();
    }

    @Override
    public void onStop() {
        super.onStop();
        stateFailed = true;
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stateFailed = true;
        finish();
    }

    public void startTimer() {
        stirTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                userTimeLeft--;
                String timeLeftText = "" + userTimeLeft;
                userTimerView.setText(timeLeftText);

                if (stirFry > 0) { stirFry--; }
                stirTestUpdate();
                pointerX = stirFry;
            }

            @Override
            public void onFinish() {
                if (stirFry <= maxVal && stirFry >= minVal) {
                    stateFailed = false;
                    playerMoneyVal = playerMoneyVal + 100;
                    Toast.makeText(getApplicationContext(), "You won!", Toast.LENGTH_SHORT).show();
                } else {
                    stateFailed = true;
                    Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        }.start();
    }

    public void stirFryUpdater () {
        if (stirOnce = false) { stirOnce = true; }
        stirFry = stirFry + 2;
        stirTestUpdate();
        if (stirFry > 109) { Toast.makeText(getApplicationContext(), R.string.fail_toast, Toast.LENGTH_SHORT).show(); stateFailed = true; finish(); }
    }

    public void stirTestUpdate() {
        String stirReview = "" + stirFry;
        testStirView.setText(stirReview);
    }
}
