package com.example.game;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * An interface for level presenters.
 */
public interface LevelPresenterInterface {

    /**
     * Pause the current level.
     */
    void pauseGame();

    /**
     * Unpause the current level.
     */
    void unpauseGame();

    /**
     * Update the current level (move/create objects, etc.)
     */
    void updateGame();

    /**
     * Draw the objects of the level.
     */
    void drawGame();

    /**
     * Tell the level what to do when a tap is detected.
     */
    void tapEvent(float x, float y);

}
