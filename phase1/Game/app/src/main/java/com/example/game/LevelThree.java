package com.example.game;

import android.graphics.Canvas;
import android.media.Image;

import java.util.Random;

public class LevelThree extends GenericLevel {
    /**
     * The position the player is at.
     */
    private int playerPosition;
    /**
     * The position the player is targeting.
     */
    private int playerTarget;

    public LevelThree(Image backgroundImage, int lives) {
        super(backgroundImage, lives);
        playerPosition = 1;
        playerTarget = 1;
    }

    public void runRound() {
        int playerLives = super.getLives();
        if (playerLives > 0) {
            Random randomNum = new Random();
            int computerTarget = randomNum.nextInt(3);
            int computerPosition = randomNum.nextInt(3);

            if (computerTarget == playerPosition) {
                if (playerLives == 1) {
                    loseGame();
                } else {
                    super.setLives(playerLives - 1);
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
