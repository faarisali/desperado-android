package com.example.game;


import java.util.Observable;
import java.util.Random;

public class LevelThree extends Observable {
    /**
     * The position the player is at.
     */
    private int playerPosition;
    /**
     * The position the player is targeting.
     */
    private int playerTarget;

    /**
     * The amount of lives the player has remaining.
     */
    private int lives;

    LevelThree(int lives) {
        this.lives = lives;
        playerPosition = 1;
        playerTarget = 1;
    }

    /**
     * Completes a round of the level with the present date for position, target and lives.
     */
    void runRound() {
        int playerLives = lives; //super.getLives();
        if (playerLives > 0) {
            Random randomNum = new Random();
            int computerTarget = randomNum.nextInt(3);
            int computerPosition = randomNum.nextInt(3);
            System.out.println("Computer Target" + computerTarget);
            System.out.println("Computer Position" + computerPosition);

            if (computerTarget == playerPosition) {
                lives -= 1;
                if (lives == 0) {
                    update(1); // Lose game
                }
            }
            if (playerTarget == computerPosition) {
                update(1); // Win game
            }
        }
        update(0);
    }

    /**
     * Sets the new player position.
     *
     * @param position the new position.
     */
    void setPlayerPosition(int position) {
        this.playerPosition = position;
        update(0);
    }

    /**
     * sets the new player target
     *
     * @param target the new target.
     */
    void setPlayerTarget(int target) {
        this.playerTarget = target;
        update(0);
    }

    /**
     * Will end the game using the observer pattern.
     */
    public void update(int finish) {
        setChanged();
        int[] data = {playerPosition, playerTarget, lives, finish};
        notifyObservers(data);
    }
}
