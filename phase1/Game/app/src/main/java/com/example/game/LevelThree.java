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
    private int lives = 2;

//    public LevelThree(Drawable backgroundImage, int lives) {
//        super(backgroundImage, lives);
//        playerPosition = 1;
//        playerTarget = 1;
//        buildGameObjects();
//    }

    LevelThree() {
        super();
        playerPosition = 1;
        playerTarget = 1;
        //buildGameObjects();
        update();
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
                if (playerLives == 1) {
                    loseGame();
                } else {
                    //super.setLives(playerLives - 1);
                    lives -= 1;
                }
            }
            if (playerTarget == computerPosition) {
                winGame();
            }
        }
        update();
    }

    /**
     * Sets the new player position.
     *
     * @param position the new position.
     */
    void setPlayerPosition(int position) {
        this.playerPosition = position;
        update();
    }

    /**
     * sets the new player target
     *
     * @param target the new target.
     */
    void setPlayerTarget(int target) {
        this.playerTarget = target;
        update();
    }

    private void winGame() {
        //TODO
    }

    private void loseGame() {
        //TODO
    }

    /**
     * Updates the game view using the observer pattern.
     */
    public void update() {
        setChanged();
        int[] data = {playerPosition, playerTarget, lives};
        notifyObservers(data);
    }
}
