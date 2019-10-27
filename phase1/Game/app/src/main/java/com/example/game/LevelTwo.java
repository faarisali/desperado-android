package com.example.game;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

public class LevelTwo extends GenericLevel {

    private float movementSpeed;
    private PlayerLevelTwo player = new PlayerLevelTwo();

    /**
     * Constructs a GenericLevel
     *
     * @param backgroundImage background image for this level.
     * @param lives           the number of lives the player starts with on this level.
     */
    public LevelTwo(Drawable backgroundImage, int lives) {

    }

    /**
     * Need to draw background, character and obstacles.
     *
     * @param canvas where the img is drawn
     */
    @Override
    public void draw(Canvas canvas) {

    }


    /**
     * Spawn a new obstacle (may depend on player has ran so far)
     */
    public void spawnObstacle() {

    }

    @Override
    public void tapEvent(MotionEvent event) {

    }

    /**
     * update movement of player (jumps), spawning of obstacles and update
     */
    @Override
    public void update() {

    }


}
