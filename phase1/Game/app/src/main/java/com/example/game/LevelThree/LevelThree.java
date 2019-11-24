package com.example.game.LevelThree;


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
     * The position the cpu is currently targeting.
     */
    private int computerTarget;

    /**
     * the position the cpu is currently at.
     */
    private int computerPosition;



    /**
     * The amount of lives the player has remaining.
     */
    private int lives;

    LevelThree(int lives) {
        this.lives = lives;
        setPlayerPosition(1);
        setPlayerTarget(1);
    }

    /**
     * Completes a round of the level with the present date for position, target and lives.
     * Generates two random ints for computer target/position and compares them with the players'.
     */
    void runRound() {
        int playerLives = lives; //super.getLives();
        if (playerLives > 0) {
            Random randomNum = new Random();
             computerTarget = randomNum.nextInt(3);
             computerPosition = randomNum.nextInt(3);

            if (computerTarget == playerPosition) {
                lives -= 1;
                if (lives == 0) {
                    update(true, true); // Lose game
                }
            }
            if (playerTarget == computerPosition) {
                update(true, true); // Win game
            }
        }
        update(false, true);
    }

    /**
     * Sets the new player position.
     *
     * @param position the new position.
     */
    void setPlayerPosition(int position) {
        this.playerPosition = position;
        update(false, false);
    }

    /**
     * sets the new player target
     *
     * @param target the new target.
     */
    void setPlayerTarget(int target) {
        this.playerTarget = target;
        update(false, false);
    }

    /**
     * Will update the game using the observer pattern.
     */
    public void update(boolean finish, boolean animate) {
        setChanged();
        Object[] data = {playerPosition, playerTarget, lives, computerTarget, computerPosition, finish, animate};
        notifyObservers(data);
    }
}
