package com.example.game;

import android.media.Image;

public class Obstacle {
    /**
     * what it looks like (We can just make this a a random shape for now)
     */
    private Image model;

    /**
     * x and y location of the object
     */
    private int x, y;
    /**
     * How fast the obstacle should be moving towards the player (negative value)
     */
    private float Vx;

    /**
     * Create a new obstacle.
     *
     * @param moveSpeed how fast this obstacle is going to be moving
     */
    public Obstacle(float moveSpeed) {
    }

    /**
     * Move the obstacle according to to its speed Vx
     */
    public void move() {
    }

    /**
     * Draw the obstacle.
     */
    public void draw() {
    }


}
