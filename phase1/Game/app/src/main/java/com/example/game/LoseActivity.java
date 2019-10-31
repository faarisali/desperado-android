package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        Intent intent = getIntent(); //get the data from sender
        int pointsValue = intent.getIntExtra("Points", 0);
        int goldValue = intent.getIntExtra("Gold", 0);

        displayStats(pointsValue, goldValue);

    }

    /**
     * Displays the relevant stats for a player who has lost.
     * @param pointsValue the amount of points they got
     * @param goldValue the amount of gold they got
     */
    void displayStats(int pointsValue, int goldValue) {
        TextView goldBox = findViewById(R.id.goldVariableBox);
        goldBox.setText(goldValue);

        TextView pointsBox = findViewById(R.id.pointsVariableBox);
        goldBox.setText(pointsValue);
    }

    /**
     * restarts the game from level 1.
     * @param view the relevant view.
     */
    public void restart(View view) {
        // TODO: send an intent to level 1
    }

    /**
     * Send the user back to the main menu.
     * @param view the relevant view.
     */
    public void mainMenu(View view) {
        //TODO: send an intent to main menu.
        //Intent intent = new Intent(this, LevelThreeActivity.class);
    }
}
