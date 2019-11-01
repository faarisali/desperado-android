package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Intent intent = getIntent(); //get the data from sender
        int pointsValue = intent.getIntExtra("Points", 0);
        int goldValue = intent.getIntExtra("Gold", 0);
        int livesRemaining = intent.getIntExtra("Lives", 0);

        displayStats(pointsValue, goldValue, livesRemaining);

    }
    private void displayStats(int pointsValue, int goldValue, int livesRemaining) {
        TextView goldBox = findViewById(R.id.goldVariable);
        goldBox.setText(Integer.toString(goldValue));

        TextView pointsBox = findViewById(R.id.pointsVariable);
        pointsBox.setText(Integer.toString(pointsValue));

        TextView livesBox = findViewById(R.id.livesVariable);
        livesBox.setText(Integer.toString(livesRemaining));
    }
}
