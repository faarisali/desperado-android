package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Intent intent = getIntent(); //get the data from sender
        int pointsValue = intent.getIntExtra("Points", 0);
        int goldValue = intent.getIntExtra("Gold", 0);
        int livesRemaining = intent.getIntExtra("Lives", 0);

        Button mainMenu = findViewById(R.id.mainMenuButton);
        mainMenu.setOnClickListener(this);

        Button restart = findViewById(R.id.restartButton);
        restart.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainMenuButton:
                Intent intent = new Intent(this, MainMenu.class);
                startActivity(intent);
            case R.id.restartButton:
                Intent intent2 = new Intent(this, LevelThreeActivity.class);
                intent2.putExtra("Points", 0);
                intent2.putExtra("Gold", 0); //Temporary until all are converted to activities
                intent2.putExtra("Lives", 3);
                startActivity(intent2);
        }
    }
}
