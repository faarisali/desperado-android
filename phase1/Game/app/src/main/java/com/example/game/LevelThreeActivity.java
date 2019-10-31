package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.Arrays;
import java.util.List;

public class LevelThreeActivity extends AppCompatActivity implements View.OnClickListener, LevelThreeView {
    /**
     * The presenter responsible for this activity.
     */
    private LevelThreePresenter presenter;
    /**
     * The list of buttons representing the players position.
     */
    private List<ToggleButton> playerPositions;
    /**
     * The list of buttons representing the players target.
     */
    private List<ToggleButton> targetPositions;
    /**
     * The list of images representing the players lives remaining.
     */
    private List<ImageView> playerHearts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three);

        presenter = new LevelThreePresenter(this, new LevelThreeInteractor(new LevelThree()));

        buildGameObjects();
    }

    /**
     * Creates all the buttons, image views, etc necessary for the level.
     */
    public void buildGameObjects() {
        ToggleButton pos0 = findViewById(R.id.position0);
        pos0.setOnClickListener(this);
        ToggleButton pos1 = findViewById(R.id.position1);
        pos1.setOnClickListener(this);
        ToggleButton pos2 = findViewById(R.id.position2);
        pos2.setOnClickListener(this);

        playerPositions = Arrays.asList(pos0, pos1, pos2);

        ToggleButton tar0 = findViewById(R.id.target0);
        tar0.setOnClickListener(this);
        ToggleButton tar1 = findViewById(R.id.target1);
        tar1.setOnClickListener(this);
        ToggleButton tar2 = findViewById(R.id.target2);
        tar2.setOnClickListener(this);

        targetPositions = Arrays.asList(tar0, tar1, tar2);

        Button start = findViewById(R.id.startButton);
        start.setOnClickListener(this);

        ImageView heart1 = findViewById(R.id.heart1);
        ImageView heart2 = findViewById(R.id.heart2);
        ImageView heart3 = findViewById(R.id.heart3);
        playerHearts = Arrays.asList(heart1, heart2, heart3);


    }

    /**
     * Detects when a button was clicked and determines what to do.
     *
     * @param view the view in which the button was pressed.
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startButton:
                presenter.runRound();
            case R.id.position0:
                presenter.setPositionValue(0);
                break;
            case R.id.position1:
                presenter.setPositionValue(1);
                break;
            case R.id.position2:
                presenter.setPositionValue(2);
                break;
            case R.id.target0:
                presenter.setTargetValue(0);
                break;
            case R.id.target1:
                presenter.setTargetValue(1);
                break;
            case R.id.target2:
                presenter.setTargetValue(2);
                break;
        }
    }

    /**
     * sets the players targeted position as selected and the un-selects the other positions.
     *
     * @param target the target position that the user wants to be at.
     */
    public void setPositionSelected(int target) {
        for (int i = 0; i < playerPositions.size(); i++) {
            if (i == target) {
                playerPositions.get(i).setChecked(true);
            } else {
                playerPositions.get(i).setChecked(false);

            }
        }
    }

    /**
     * sets the players desired position asn selected and un-selects the other positions.
     *
     * @param target the target the user wants to target.
     */
    public void setTargetSelected(int target) {
        for (int i = 0; i < targetPositions.size(); i++) {
            if (i == target) {
                targetPositions.get(i).setChecked(true);
            } else {
                targetPositions.get(i).setChecked(false);
            }
        }
    }

    /**
     * Sets the visible life bar of the player to the appropriate amount.
     *
     * @param newLives the new amount of lives to be displayed.
     */
    @Override
    public void setPlayerLives(int newLives) {
        for (int i = 0; i < playerHearts.size(); i++) {
            if (i >= newLives) {
                playerHearts.get(i).setVisibility(View.GONE);
            }
        }
    }
}
