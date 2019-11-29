package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.Login.LoginAndroidMapDatabase;
import com.example.game.Login.User;

public class LoseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        Intent intent = getIntent(); //get the data from sender
        int pointsValue = intent.getIntExtra("Points", 0);
        int goldValue = intent.getIntExtra("Gold", 0);

        Button mainMenu = findViewById(R.id.mainMenuButton);
        mainMenu.setOnClickListener(this);

        Button restart = findViewById(R.id.restartButton);
        restart.setOnClickListener(this);

        displayStats(pointsValue, goldValue);

        // Update user info
        User currentUser = LoginAndroidMapDatabase.getSingleton().getCurrentUser();
        currentUser.setTotalPoints(currentUser.getTotalPoints() + pointsValue);
        currentUser.setTotalGold(currentUser.getTotalGold() + goldValue);
        currentUser.setTotalLivesLost(currentUser.getTotalLivesLost() + 3);
        LoginAndroidMapDatabase.getSingleton().addUser(currentUser);

    }

    /**
     * Displays the relevant stats for a player who has lost.
     *
     * @param pointsValue the amount of points they got
     * @param goldValue   the amount of gold they got
     */
    void displayStats(int pointsValue, int goldValue) {
        TextView goldBox = findViewById(R.id.goldVariableBox);
        goldBox.setText(Integer.toString(goldValue));

        TextView pointsBox = findViewById(R.id.pointsVariableBox);
        pointsBox.setText(Integer.toString(pointsValue));
    }

    /**
     * Delegates the click to the correct button and sends it to the correct view.
     *
     * @param view the current view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainMenuButton:
                Intent intent = new Intent(this, MainMenu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                finish();
                break;
//            case R.id.restartButton: //For future when all activities are working
//                Intent intent2 = new Intent(this, LevelOneActivity.class);
//                intent2.putExtra("Points", 0);
//                intent2.putExtra("Gold", 0); //Temporary until all are converted to activities
//                intent2.putExtra("Lives", 3);
//                startActivity(intent2);
//                finish();
//                break;
        }
    }
}
