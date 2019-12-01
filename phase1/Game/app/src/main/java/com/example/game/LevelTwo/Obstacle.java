package com.example.game.LevelTwo;

import android.graphics.Point;

import com.example.game.GameObject;

public class Obstacle extends GameObject {

    /**
     * How fast the obstacle should be moving towards the player (negative value)
     */
    private float Vx;

    /**
     * Whether this object is out od bounds.
     */
    private boolean outOfBounds;

    /**
     * whether this object has collided.
     */
    private boolean collided;

    /**
     * Create a new obstacle.
     *
     * @param moveSpeed how fast this obstacle is going to be moving
     */
    Obstacle(int x, int y, float moveSpeed) {
        super(x, y);
        this.Vx = moveSpeed;
        this.outOfBounds = false;
        this.collided = false;
    }


    /**
     * Move the obstacle according to to its speed Vx
     */
    void move() {
        x -= Vx;
        checkOutOfBounds();
    }

    /**
     * checks if this object is out of bounds.
     */
    private void checkOutOfBounds() {
        if (x <= -40) {
            this.outOfBounds = true;
        }
    }

    /**
     * Draws the obstacle at its x, y value.
     * @return the point at which the obstacle is at.
     */
    public Point draw() {
        return new Point(this.x, this.y);
    }

    /**
     * Communicates whether or not this object is out of bounds.
     * @return whether the obejct is out of bounds.
     */
    boolean isOutOfBounds() {
        return outOfBounds;
    }

    /**
     * Communicates whether or not this object has collided with anything.
     * @return whether a collision has occurred.
     */
    boolean isCollided() {
        return collided;
    }

    /**
     * sets whether not this object has been collided
     * @param collided the value of whether the object has collided.
     */
    void setCollided(boolean collided) {
        this.collided = collided;
    }
}
