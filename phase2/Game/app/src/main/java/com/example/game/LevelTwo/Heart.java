package com.example.game.LevelTwo;

import android.graphics.Point;

import com.example.game.GameObject;

public class Heart extends GameObject {

    /**
     * Initializes a Heart.
     */
    public Heart(int x, int y) {
        super(x, y);

    }

    /**
     * Draws a Heart.
     *
     * @return the point (x, y) at which the heart is at
     */
    public Point draw() {
        return new Point(getX(), getY());
    }
}
