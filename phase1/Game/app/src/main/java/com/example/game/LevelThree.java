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
    private ShootingPosition start;

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
        cpuPositions = new ArrayList<>();
        playerPositions = new ArrayList<>();

        ShootingPosition cpuPos0 = new ShootingPosition(100, 200, 250, 250);//top 3 positions (targets)
        ShootingPosition cpuPos1 = new ShootingPosition(425, 200, 250, 250);
        ShootingPosition cpuPos2 = new ShootingPosition(750, 200, 250, 250);
        super.addGameObject(cpuPos0); cpuPositions.add(cpuPos0);
        super.addGameObject(cpuPos1); cpuPositions.add(cpuPos1);
        super.addGameObject(cpuPos2); cpuPositions.add(cpuPos2);

        ShootingPosition playerPos0 = new ShootingPosition(100, 1000, 250, 250); //bottom 3 positions
        ShootingPosition playerPos1 = new ShootingPosition(425, 1000, 250, 250);
        ShootingPosition playerPos2 = new ShootingPosition(750, 1000, 250, 250);

        super.addGameObject(playerPos0); playerPositions.add(playerPos0);
        super.addGameObject(playerPos1); playerPositions.add(playerPos1);
        super.addGameObject(playerPos2); playerPositions.add(playerPos2);

        ShootingPosition startButton = new ShootingPosition(425, 1500, 250, 250);
        start = startButton;
        super.addGameObject(startButton);

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
        Paint paintText = new Paint();
        paintText.setTextSize(60);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        paintText.setColor(Color.GREEN);
        canvas.drawText(Integer.toString(getLives()), 50, 50, paintText);
        canvas.drawText(Integer.toString(playerPosition), 50, 100, paintText);
        canvas.drawText(Integer.toString(playerTarget), 50, 150, paintText);


    }

    public void update() {
        //TODO
    }

    /**
     * Makes sure that only one target from each section is selected at a time.
     * @param selectedIndex the item that will be selected.
     * @param objs the items to reset.
     */
    public void resetOtherTargets(int selectedIndex, ArrayList<ShootingPosition> objs) {
        for (int i = 0; i < objs.size(); i++) {
            if (i != selectedIndex) {
                ShootingPosition item = objs.get(i);
                item.setSelected(false);
            }
        }
    }

    /**
     * What Level 3 does when the user taps the screen.
     *
     * @param event the tap event registered.
     */
    @Override
    public void tapEvent(MotionEvent event) {
        ArrayList<GameObject> objs = super.getGameObjects();

        for (int i = 0; i < cpuPositions.size(); i++) {
            ShootingPosition item = cpuPositions.get(i);

            if (item.isTapped(event)) {
                item.setSelected(true);
                playerTarget = i;
                resetOtherTargets(i, cpuPositions);
            }
        }
        for (int i = 0; i < playerPositions.size(); i++) {
            ShootingPosition item = playerPositions.get(i);

            if (item.isTapped(event)) {
                item.setSelected(true);
                System.out.println(i);
                playerPosition = i;
                resetOtherTargets(i, playerPositions);
            }
        }
        if (start.isTapped(event)) {
            runRound();
        }

    }
}
