package com.example.game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.game.LevelThree.LevelThreeActivity;
import com.example.game.Login.LoginActivity;
import com.example.game.Login.LoginAndroidMapDatabase;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        TextView usernameText = findViewById(R.id.usernameTextView);
        String username = LoginAndroidMapDatabase.getSingleton().getCurrentUser();
        usernameText.setText(username);
        customizeCharacter();
        toggleMusic();
    }

    /**
     * If a view object in this layout is clicked, decide what happens.
     *
     * @param v the view object that is clicked.
     */
    public void beginLevelOne(View v) {
        Intent levelOne = new Intent(this.getBaseContext(), MainActivity.class);
        startActivity(levelOne);
    }

    public void beginLevelTwo(View v) {
        Intent levelTwo = new Intent(this.getBaseContext(), PauseScreen.class);
        startActivity(levelTwo);
    }

    public void beginLevelThree(View v) {
        Intent levelThree = new Intent(this.getBaseContext(), LevelThreeActivity.class);
        startActivity(levelThree);
    }

    public void logOut(View v) {
        Intent logout = new Intent(this, LoginActivity.class);
        LoginAndroidMapDatabase.getSingleton().setCurrentUser("");
        startActivity(logout);
    }
}
