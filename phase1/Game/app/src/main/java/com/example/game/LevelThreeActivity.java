package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelThreeActivity extends AppCompatActivity implements View.OnClickListener, LevelThreeView {
    //private LevelThree levelThree;
    private LevelThreePresenter presenter;
    private List<ToggleButton> playerPositions;
    private List<ToggleButton> targetPositions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three);

        presenter = new LevelThreePresenter(this, new LevelThreeInteractor(new LevelThree()));

        buildGameButtons();
    }

    public void buildGameButtons() {
        ToggleButton pos0 = findViewById(R.id.position0);
        pos0.setOnClickListener(this);
        ToggleButton pos1 = findViewById(R.id.position1);
        pos0.setOnClickListener(this);
        ToggleButton pos2 = findViewById(R.id.position2);
        pos0.setOnClickListener(this);

        playerPositions = Arrays.asList(pos0, pos1, pos2);

        ToggleButton tar0= findViewById(R.id.target0);
        pos0.setOnClickListener(this);
        ToggleButton tar1 = findViewById(R.id.target1);
        pos0.setOnClickListener(this);
        ToggleButton tar2 = findViewById(R.id.target2);
        pos0.setOnClickListener(this);

        targetPositions = Arrays.asList(tar0, tar1, tar2);

        Button start= findViewById(R.id.startButton);
        start.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startButton:
                presenter.runRound();
            case R.id.position0:
                presenter.setPositionValue(0);
                break;
            case R.id.target0:
                presenter.setTargetValue(0);
                break;
        }
    }

    public void setPositionSelected(int target) {
        for (int i = 0; i < playerPositions.size(); i++) {
            if (i == target) {
                playerPositions.get(i).setSelected(true);
            } else {
                playerPositions.get(i).setSelected(false);
            }
        }
    }

    public void setTargetSelected(int target) {
        for (int i = 0; i < targetPositions.size(); i++) {
            if (i == target) {
                targetPositions.get(i).setSelected(true);
            } else {
                targetPositions.get(i).setSelected(false);
            }
        }
    }
}
