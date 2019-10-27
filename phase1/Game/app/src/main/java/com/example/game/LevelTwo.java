package com.example.game;

import android.graphics.Canvas;
import android.media.Image;

public class LevelTwo extends GenericLevel {

    private float movementSpeed;

    /**
     * Constructs a GenericLevel
     *
     * @param backgroundImage background image for this level.
     * @param lives           the number of lives the player starts with on this level.
     */
    public LevelTwo(Image backgroundImage, int lives) {
        super(backgroundImage, lives);
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

    /**
     * update movement of player (jumps), spawning of obstacles and update
     */
    @Override
    public void update() {

    }


}
