package com.example.game;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.MotionEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

    private ArrayList<ShootingPosition> cpuPositions;
    private ArrayList<ShootingPosition> playerPositions;
    private TappableObject start;

    public LevelThree(Drawable backgroundImage, int lives) {
        super(backgroundImage, lives);
        playerPosition = 1;
        playerTarget = 1;
        buildGameObjects();
    }

    public LevelThree() {
        super();
        playerPosition = 1;
        playerTarget = 1;
        buildGameObjects();
    }


    /**
     * Creates all the objects within level 3.
     */
    private void buildGameObjects() {
        ShootingPosition cpuPos0 = new ShootingPosition(100,200,250,250);//top 3 positions (targets)
        ShootingPosition cpuPos1 = new ShootingPosition(425,200,250,250);
        ShootingPosition cpuPos2 = new ShootingPosition(750,200,250,250);

        super.addGameObject(cpuPos0);
        super.addGameObject(cpuPos1);
        super.addGameObject(cpuPos2);

        ShootingPosition playerPos0 = new ShootingPosition(100,1000,250,250); //bottom 3 positions
        ShootingPosition playerPos1 = new ShootingPosition(425,1000,250,250); //bottom 3 positions
        ShootingPosition playerPos2 = new ShootingPosition(750,1000,250,250); //bottom 3 positions

        super.addGameObject(playerPos0);
        super.addGameObject(playerPos1);
        super.addGameObject(playerPos2);


        start = new TappableObject(425,1500,250,250); //start button
        super.addGameObject(start);

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
        ArrayList<GameObject> objs = super.getGameObjects();
        for (GameObject item : objs) {
            item.draw(canvas);
        }
    }

    public void update() {
        //TODO
    }

    /**
     * What Level 3 does when the user taps the screen.
     * @param event the tap event registered.
     */
    @Override
    public void tapEvent(MotionEvent event) {
        ArrayList<GameObject> objs = super.getGameObjects();
        for (GameObject item : objs) {
            TappableObject newItem = (TappableObject) item;
            newItem.isTapped(event);
        }



    }
}
