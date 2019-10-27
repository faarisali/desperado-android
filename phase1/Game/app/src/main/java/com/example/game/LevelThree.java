package com.example.game;

import android.graphics.Canvas;

import java.util.Random;

public class LevelThree extends GenericLevel{
    private int playerPosition;
    private int playerTarget;
    private int playerLives;

    public LevelThree() {
        playerPosition = 1;
        playerTarget = 1;
        playerLives = 3; //FOR NOW; WILL EVENTUALLY BE INHERITED???
    }

    public void runRound() {
        if (playerLives > 0) {
            Random randomNum = new Random();
            int computerTarget = randomNum.nextInt(3);
            int computerPosition = randomNum.nextInt(3);

            if (computerTarget == playerPosition) {
                if (playerLives == 1) {
                    loseGame();
                } else {
                    playerLives -= 1;
                }
            }
            if (playerTarget == computerPosition) {
                winGame();
            }

        }

    }

    private void winGame() {
        //TODO
    }

    private void loseGame() {
        //TODO
    }

    public void draw(Canvas canvas) {
        //TODO
    }

    public void update() {
        //TODO
    }
}
