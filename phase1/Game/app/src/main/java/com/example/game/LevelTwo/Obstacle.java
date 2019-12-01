package com.example.game.LevelTwo;

import android.graphics.Point;

import com.example.game.GameObject;

public class Obstacle extends GameObject {

    /**
     * How fast the obstacle should be moving towards the player (negative value)
     */
    private float Vx;
    private boolean outOfBounds;
    private boolean collided;

    /**
     * Create a new obstacle.
     *
     * @param moveSpeed how fast this obstacle is going to be moving
     */
    public Obstacle(int x, int y, float moveSpeed) {
        super(x, y);
        this.Vx = moveSpeed;
        this.outOfBounds = false;
        this.collided = false;
    }


    /**
     * Move the obstacle according to to its speed Vx
     */
    public void move() {
        setX(getX() - Math.round(Vx));
        checkOutOfBounds();
    }

    private void checkOutOfBounds() {
        if (getX() <= -40) {
            this.outOfBounds = true;
        }
    }

    public Point draw() {
        return new Point(getX(), getY());
    }

    public boolean isOutOfBounds() {
        return outOfBounds;
    }

    public boolean isCollided() {
        return collided;
    }

    public void setCollided(boolean collided) {
        this.collided = collided;
    }
}
