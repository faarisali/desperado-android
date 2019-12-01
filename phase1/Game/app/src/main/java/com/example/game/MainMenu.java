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
import com.example.game.LevelTwo.LevelTwoReplayActivity;
import com.example.game.Login.LoginActivity;
import com.example.game.Login.LoginAndroidMapDatabase;
import com.example.game.Login.User;

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
            R.drawable.cowboy_bandit,
            R.drawable.clown,
            R.drawable.bucket_man
    };

    /** The switch that toggles the music*/
    private Switch musicSwitch;

    /** The menu music player*/
    private MediaPlayer player;

    /** The switch that toggles night mode*/
    private Switch nightModeSwitch;

    /** The menu layout*/
    private ConstraintLayout menuBackground;

    /**
     * List of text fields in this activity.
     */
    private ArrayList<TextView> viewsList = new ArrayList<>();

    /**
     * The database used to access data stored on this android device by this application.
     */
    private LoginAndroidMapDatabase db;

    /**
     * The user that is currently logged in.
     */
    private User currentUser;

    /**
     * Initializes this activity.
     *
     * @param savedInstanceState if not null, contains information about last activity instance.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        TextView usernameText = findViewById(R.id.usernameTextView);

        db = LoginAndroidMapDatabase.getSingleton(this);

        currentUser = db.getCurrentUser();
        String username = currentUser.getUsername();
        usernameText.setText(username);
        setupCostumeComponent();
        setupMusicComponent();
        setupNightModeComponent();
        updateStats();
        populateViewsList();

        // sets users preferences
        boolean isDark = currentUser.isDarkTheme();
        nightModeSwitch.setChecked(isDark);
        boolean isPlaying = currentUser.isMusicPlaying();
        musicSwitch.setChecked(isPlaying);
        currentCostume = currentUser.getCostume();
        setCurrentCostume();
    }

    /**
     * Sets up the costume display and costume change button.
     */
    public void setupCostumeComponent() {
        character = findViewById(R.id.costume);
        customizeButton = findViewById(R.id.costumeButton);
        customizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentCostume++;
                setCurrentCostume();
            }
        });
    }

    /**
     * Sets the current costume to this currentCostume and saves it in the user.
     */
    private void setCurrentCostume() {
        currentCostume = currentCostume % costumes.length;
        character.setImageResource(costumes[currentCostume]);
        saveCurrentCostume(currentCostume);
    }

    /**
     * Plays music in the background.
     */
    public void playMusic() {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.music);
            player.setLooping(true);
        }
        player.start();
    }

    /**
     * Stops the music if its playing in the background.
     */
    public void stopMusic() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    /**
     * Sets up the music toggle button.
     */
    public void setupMusicComponent() {
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
            saveIsMusicPlaying(isChecked);
          }
        });
    }

    /**
     * Sets up the night mode toggle button.
     */
    public void setupNightModeComponent() {
        nightModeSwitch = findViewById(R.id.nightModeSwitch);
        menuBackground = findViewById(R.id.menu);
    nightModeSwitch.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if (isChecked) {
                menuBackground.setBackgroundColor(Color.BLACK);
                setTextColor(Color.WHITE);
            } else {
                menuBackground.setBackgroundColor(Color.WHITE);
                setTextColor(Color.BLACK);
            }
            saveDarkMode(isChecked);
          }
        });
    }

    /**
     * Sets the color of all text fields in this viewList
     * @param color the color to change all the text fields in this activity to
     */
    private void setTextColor(int color) {
        for (TextView v : this.viewsList) {
            v.setTextColor(color);
        }
    }

    /**
     * Populates viewList with all the text fields present in this activity.
     */
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

    /**
     * Updates this activity on resume.
     */
    @Override
    protected void onResume() {
        super.onResume();
        updateStats();
    }

    /**
     * Update the displayed user stats to match the values in the database.
     */
    private void updateStats() {
        User currentUser = db.getCurrentUser();
        TextView points = findViewById(R.id.totalPoints);
        points.setText(String.valueOf(currentUser.getTotalPoints()));
        TextView gold = findViewById(R.id.totalGold);
        gold.setText(String.valueOf(currentUser.getTotalGold()));
        TextView livesLost = findViewById(R.id.totalLivesLost);
        livesLost.setText(String.valueOf(currentUser.getTotalLivesLost()));
    }

    /**
     * Initializes Level One for the user to play.
     *
     * @param v the view object that is clicked.
     */
    public void beginLevelOne(View v) {
        Intent levelOne = new Intent(this.getBaseContext(), LevelOneActivity.class);
        levelOne.putExtra("spriteID", costumes[currentCostume]);
        if (nightModeSwitch.isChecked()) {
            levelOne.putExtra("Time", 1);
        } else {
            levelOne.putExtra("Time", 0);
        }
        startActivity(levelOne);
    }

    /**
     * Initializes Level Two for the user to play.
     *
     * @param v the view object that is clicked.
     */
    public void beginLevelTwo(View v) {
        Intent levelTwo = new Intent(this.getBaseContext(), LevelTwoActivity.class);
        levelTwo.putExtra("spriteID", costumes[currentCostume]);
        if (nightModeSwitch.isChecked()) {
            levelTwo.putExtra("Time", 1);
        } else {
            levelTwo.putExtra("Time", 0);
        }
        startActivity(levelTwo);
    }

    /**
     * Initializes Level Three for the user to play.
     *
     * @param v the view object that is clicked.
     */
    public void beginLevelThree(View v) {
        Intent levelThree = new Intent(this.getBaseContext(), LevelThreeActivity.class);
        levelThree.putExtra("spriteID", costumes[currentCostume]);
        if (nightModeSwitch.isChecked()) {
            levelThree.putExtra("Time", 1);
        } else {
            levelThree.putExtra("Time", 0);
        }
        startActivity(levelThree);
    }

    /**
     * Initializes Replay for the user to play.
     *
     * @param v the view object that is clicked.
     */
    public void beginReplay(View v) {
        String replayString = db.load("$replay");

        if (replayString != null) {
            Intent replay = new Intent(this.getBaseContext(), LevelTwoReplayActivity.class);
            replay.putExtra("spriteID", costumes[currentCostume]);
            if (nightModeSwitch.isChecked()) {
                replay.putExtra("Time", 1);
            } else {
                replay.putExtra("Time", 0);
            }
            startActivity(replay);
        }
    }

    /**
     * Begins the logout process.
     * @param v the view that was clicked.
     */
    public void logOut(View v) {
        Intent logout = new Intent(this, LoginActivity.class);
        db.setCurrentUser(null);
        startActivity(logout);
        stopMusic();
        finish();
    }

    /**
     * Saves user's dark mode preference.
     * @param isDark true iff user prefers dark mode to be on.
     */
    public void saveDarkMode(boolean isDark) {
        currentUser.setDarkTheme(isDark);
        db.updateCurrentUser(currentUser);
    }

    /**
     * Saves user's music preference.
     * @param isMusicPlaying true iff user prefers music to be playing.
     */
    public void saveIsMusicPlaying(boolean isMusicPlaying) {
        currentUser.setMusicIsPlaying(isMusicPlaying);
        db.updateCurrentUser(currentUser);
    }

    /**
     * Saves user's costume preference.
     * @param currentCostume represents the index of the costume that the user prefers from
     *                       this costumes integer array.
     */
    public void saveCurrentCostume (int currentCostume) {
        currentUser.setCostume(currentCostume);
        db.updateCurrentUser(currentUser);
    }
}
