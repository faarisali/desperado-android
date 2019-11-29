package com.example.game.LevelTwo;

import android.graphics.Canvas;
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
    public Obstacle(int x, int y, int size, int color, float moveSpeed) {
        super(x, y, size, color);
        this.Vx = moveSpeed;
        this.outOfBounds = false;
        this.collided = false;
    }


    /**
     * Move the obstacle according to to its speed Vx
     */
    public void move() {
        x -= Vx;
        checkOutOfBounds();
    }

    private void checkOutOfBounds() {
        if (x <= -40) {
            this.outOfBounds = true;
        }
    }
    /**
     * Draw the obstacle.
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.drawText("{}", x, y, getPaintText());
    }

    public Point draw() {
        return new Point(this.x, this.y);
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
