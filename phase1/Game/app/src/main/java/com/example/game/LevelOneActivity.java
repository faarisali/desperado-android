package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class LevelOneActivity extends AppCompatActivity {

    /** List of tappable objects inside the level.*/
    private List<Button> tappables;

    /** The list of images representing the players lives remaining.*/
    private List<ImageView> playerHearts;

    /** Number of coins accumulated.*/
    private int numOfCoins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
    }
}
