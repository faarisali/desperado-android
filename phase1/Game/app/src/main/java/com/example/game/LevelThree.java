package com.example.game;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.MotionEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

    private ArrayList<ShootingPosition> cpuPositions;
    private ArrayList<ShootingPosition> playerPositions;
    private ShootingPosition start;

    private int lives = 3;

//    public LevelThree(Drawable backgroundImage, int lives) {
//        super(backgroundImage, lives);
//        playerPosition = 1;
//        playerTarget = 1;
//        buildGameObjects();
//    }

    public LevelThree() {
        super();
        playerPosition = 1;
        playerTarget = 1;
        //buildGameObjects();
    }


    /**
     * Creates all the objects within level 3.
     */
//    private void buildGameObjects() {
//        cpuPositions = new ArrayList<>();
//        playerPositions = new ArrayList<>();
//
//        ShootingPosition cpuPos0 = new ShootingPosition(100, 200, 250, 250);//top 3 positions (targets)
//        ShootingPosition cpuPos1 = new ShootingPosition(425, 200, 250, 250);
//        ShootingPosition cpuPos2 = new ShootingPosition(750, 200, 250, 250);
//        super.addGameObject(cpuPos0); cpuPositions.add(cpuPos0);
//        super.addGameObject(cpuPos1); cpuPositions.add(cpuPos1);
//        super.addGameObject(cpuPos2); cpuPositions.add(cpuPos2);
//
//        ShootingPosition playerPos0 = new ShootingPosition(100, 1000, 250, 250); //bottom 3 positions
//        ShootingPosition playerPos1 = new ShootingPosition(425, 1000, 250, 250);
//        ShootingPosition playerPos2 = new ShootingPosition(750, 1000, 250, 250);
//
//        super.addGameObject(playerPos0); playerPositions.add(playerPos0);
//        super.addGameObject(playerPos1); playerPositions.add(playerPos1);
//        super.addGameObject(playerPos2); playerPositions.add(playerPos2);
//
//        ShootingPosition startButton = new ShootingPosition(425, 1500, 250, 250);
//        start = startButton;
//        super.addGameObject(startButton);
//
//    }

    public void runRound() {
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

    void setPlayerPosition (int position) {
        this.playerPosition = position;
        update();
    }

    void setPlayerTarget (int target) {
        this.playerTarget = target;
        update();
    }

    private void winGame() {
        //TODO
    }

    private void loseGame() {
        //TODO
    }

//    public void draw(Canvas canvas) {
//        //TODO
//        ArrayList<GameObject> objs = super.getGameObjects();
//        for (GameObject item : objs) {
//            item.draw(canvas);
//        }
//        Paint paintText = new Paint();
//        paintText.setTextSize(60);
//        paintText.setTypeface(Typeface.DEFAULT_BOLD);
//        paintText.setColor(Color.GREEN);
//        canvas.drawText(Integer.toString(getLives()), 50, 50, paintText);
//
//        canvas.drawText(Integer.toString(playerTarget), 50, 100, paintText);
//        canvas.drawText(Integer.toString(playerPosition), 50, 150, paintText);
//    }

    public void update() {
        setChanged();
        int[] data = {playerPosition, playerTarget};
        notifyObservers(data);
    }

    /**
     * Makes sure that only one target from each section is selected at a time.
     * @param selectedIndex the item that will be selected.
     * @param objs the items to reset.
     */
    private void resetOtherTargets(int selectedIndex, ArrayList<ShootingPosition> objs) {
        for (int i = 0; i < objs.size(); i++) {
            if (i != selectedIndex) {
                ShootingPosition item = objs.get(i);
                item.setSelected(false);
            }
        }
    }

    /**
     * Checks if event event happened in arraylist objects and returns the index of the event
     * it happened to if found. If not, return -1.
     * @param objects shooting positions beaing searched for an event.
     * @param event event being searched for.
     * @return index of object if found.
     */
    private int checkTapEvents(ArrayList<ShootingPosition> objects, MotionEvent event) {
        for (int i = 0; i < objects.size(); i++) {
            ShootingPosition item = objects.get(i);
            if (item.isTapped(event)) {
                item.setSelected(true);
                //playerParam = i;
                resetOtherTargets(i, objects);
                return i;
            }
        }
        return -1;
    }

    /**
     * What Level 3 does when the user taps the screen.
     *
     * @param event the tap event registered.
     */
//    @Override
//    public void tapEvent(MotionEvent event) {
//        int newTarget = checkTapEvents(cpuPositions, event);
//        if (newTarget != -1) {
//            playerTarget = newTarget;
//        }
//        //playerTarget = checkTapEvents(cpuPositions, event);
//
//        int newPosition = checkTapEvents(playerPositions, event);
//        if (newPosition != -1) {
//            playerPosition = newPosition;
//        }
//        //playerPosition = checkTapEvents(playerPositions, event);
//
//        if (start.isTapped(event)) {
//            runRound();
//        }
//    }
}
