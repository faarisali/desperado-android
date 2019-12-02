package com.example.game.LevelTwo;

import android.graphics.Point;

import com.example.game.GameObject;

public class LevelTwoBackground extends GameObject {

    int x, y;

    /**
     * Initializes a LevelTwoBackground.
     *
     * @param x x coordinate of top left corner
     * @param y y coordinate of top left corner
     */
    public LevelTwoBackground(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    /**
     * Draws a LevelTwoBackground.
     *
     * @return the point (x, y) at which the heart is at
     */
    public Point draw() {
        return (new Point(this.x, this.y));
    }

    /**
     * Moves background in the x direction by xIncrement amount.
     *
     * @param xIncrement amount to move in x direction.
     */
    public void update(int xIncrement) {
        x = x + xIncrement;
    }

}
