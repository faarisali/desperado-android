package com.example.game;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.game.LevelOne.LevelOneActivity;
import com.example.game.LevelThree.LevelThreeActivity;
import com.example.game.LevelTwo.LevelTwoActivity;
import com.example.game.Login.LoginActivity;
import com.example.game.Login.LoginAndroidMapDatabase;
import com.example.game.Login.User;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {

    /** The character display*/
    private ImageView character;

    /** The customization button*/
    private Button customizeButton;

    /** The current costume of the character*/
    private int currentCostume;

    /** A list of costumes*/
    private int[] costumes = {
            R.drawable.cowboy_yellow,
            R.drawable.cowboy_blue,
            R.drawable.cowboy_sheriff,
            R.drawable.cowboy_bandit
    };

    /** The switch that toggles the music*/
    private Switch musicSwitch;

    /** The menu music player*/
    private MediaPlayer player;

    /** The switch that toggles night mode*/
    private Switch nightModeSwitch;

    /** The menu layout*/
    private ConstraintLayout menuBackground;

    private ArrayList<TextView> viewsList = new ArrayList<>();

    public static final String USERNAME = "username";

    public void customizeCharacter() {
        character = findViewById(R.id.costume);
        customizeButton = findViewById(R.id.costumeButton);
        customizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentCostume++;
                currentCostume = currentCostume % costumes.length;
                character.setImageResource(costumes[currentCostume]);
            }
        });
    }

    public void playMusic() {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.music);
            player.setLooping(true);
        }
        player.start();
    }

    public void stopMusic() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    public void toggleMusic() {
        musicSwitch = findViewById(R.id.musicSwitch);
    musicSwitch.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if (isChecked) {
              playMusic();
            } else {
                stopMusic();
            }
          }
        });
    }

    public void toggleNightMode() {
        nightModeSwitch = findViewById(R.id.nightModeSwitch);
        menuBackground = findViewById(R.id.menu);
    nightModeSwitch.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if (isChecked) {
              menuBackground.setBackgroundColor(Color.parseColor("#000000"));
                setTextColor(Color.WHITE);
            } else {
              menuBackground.setBackgroundColor(Color.parseColor("#ffffff"));
                setTextColor(Color.BLACK);

            }
          }
        });
    }

    private void setTextColor(int color) {
        for (TextView v : this.viewsList) {
            v.setTextColor(color);
        }
    }

    private void populateViewsList() {
        viewsList.add((TextView) findViewById(R.id.livesLostPlaceHolder));
        viewsList.add((TextView) findViewById(R.id.welcomeTextView));
        viewsList.add((TextView) findViewById(R.id.usernameTextView));
        viewsList.add((TextView) findViewById(R.id.textMenu));
        viewsList.add((TextView) findViewById(R.id.totalPointsPlaceHolder));
        viewsList.add((TextView) findViewById(R.id.totalGoldPlaceHolder));
        viewsList.add((TextView) findViewById(R.id.totalPoints));
        viewsList.add((TextView) findViewById(R.id.totalGold));
        viewsList.add((TextView) findViewById(R.id.totalLivesLost));
        viewsList.add((TextView) findViewById(R.id.nightModeSwitch));
        viewsList.add((TextView) findViewById(R.id.musicSwitch));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        TextView usernameText = findViewById(R.id.usernameTextView);
        User currentUser = LoginAndroidMapDatabase.getSingleton().getCurrentUser();
        String username = currentUser.getUsername();
        usernameText.setText(username);
        customizeCharacter();
        toggleMusic();
        toggleNightMode();
        updateStats();
        populateViewsList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateStats();
    }

    private void updateStats() {
        User currentUser = LoginAndroidMapDatabase.getSingleton().getCurrentUser();
        TextView points = findViewById(R.id.totalPoints);
        points.setText(String.valueOf(currentUser.getTotalPoints()));
        TextView gold = findViewById(R.id.totalGold);
        gold.setText(String.valueOf(currentUser.getTotalGold()));
        TextView livesLost = findViewById(R.id.totalLivesLost);
        livesLost.setText(String.valueOf(currentUser.getTotalLivesLost()));
    }

    /**
     * If a view object in this layout is clicked, decide what happens.
     *
     * @param v the view object that is clicked.
     */
    public void beginLevelOne(View v) {
        Intent levelOne = new Intent(this.getBaseContext(), LevelOneActivity.class);
        startActivity(levelOne);
    }

    public void beginLevelTwo(View v) {
        Intent levelTwo = new Intent(this.getBaseContext(), LevelTwoActivity.class);
        startActivity(levelTwo);
    }

    public void beginLevelThree(View v) {
        Intent levelThree = new Intent(this.getBaseContext(), LevelThreeActivity.class);
        startActivity(levelThree);
    }

    public void logOut(View v) {
        Intent logout = new Intent(this, LoginActivity.class);
        LoginAndroidMapDatabase.getSingleton().setCurrentUser(null);
        startActivity(logout);
    }
}
