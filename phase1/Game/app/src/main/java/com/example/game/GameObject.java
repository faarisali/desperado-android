package com.example.game;

public abstract class GameObject {
    /**
     * the X coordinate of this GameObject.
     */
    public int x;

    /**
     * the Y coordinate of this GameObject.
     */
    public int y;

    public GameObject(int newX, int newY) {
        x = newX;
        y = newY;
    }

    /**
     * gets the x value for this object.
     *
     * @return this object's X coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * gets the y value for this object.
     *
     * @return this object's Y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * sets the value of this objects X coordinate.
     *
     * @param x the new X coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * sets the value of this objects Y coordinate.
     *
     * @param y the new Y coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }
}
