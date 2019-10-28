package com.example.game;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

public class LevelTwo extends GenericLevel {

    private final int ground = 600;
    private float movementSpeed = 7;
    private PlayerLevelTwo player = new PlayerLevelTwo(ground);
    private Obstacle cactus = new Obstacle(1500, ground, movementSpeed);
    /**
     * Constructs a GenericLevel
     *
     * @param backgroundImage background image for this level.
     * @param lives           the number of lives the player starts with on this level.
     */
    public LevelTwo(Drawable backgroundImage, int lives) {

    }

    public LevelTwo() {
    }

    /**
     * Need to draw background, character and obstacles.
     *
     * @param canvas where the img is drawn
     */
    @Override
    public void draw(Canvas canvas) {
        player.draw(canvas);
        spawnObstacle(canvas);
    }


    /**
     * Spawn a new obstacle (may depend on player has ran so far)
     */
    public void spawnObstacle(Canvas canvas) {
        cactus.draw(canvas);
    }

    @Override
    public void tapEvent(MotionEvent event) {
        player.jumpUp();
    }

    /**
     * update movement of player (jumps), spawning of obstacles and update
     */
    @Override
    public void update() {

        player.move();
        cactus.move();
    }


}
