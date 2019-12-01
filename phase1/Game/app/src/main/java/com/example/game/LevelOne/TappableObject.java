package com.example.game.LevelOne;

import com.example.game.GameObject;

import java.util.ArrayList;

abstract class TappableObject extends GameObject {
    /**
     * length of hitbox.
     */
    private int length;
    /**
     * height of hitbox.
     */
    private int height;

    TappableObject(int newX, int newY, int newLength, int newHeight) {
        super(newX, newY);
        length = newLength;
        height = newHeight;
    }

    /**
     * returns whether the user's tap at coordinates x,y correspond with this TappableObject
     *
     * @param x the x value of the user's tap.
     * @param y the y value of the user's tap.
     * @return whether the tap was within the bounds of this TappableObject.
     */
    boolean tapped(float x, float y) {
        int hitboxBuffer = 25; //defines a zone around the tappable object that will still register a tap
        if (this.x - hitboxBuffer <= x && x <= this.x + length + hitboxBuffer) {
            return this.y - hitboxBuffer <= y && y <= this.y + height + hitboxBuffer;
        } else {
            return false;
        }
    }

    /**
     * Generates the 'response' to a TappableObject  getting tapped, i.e. how it affects game stats (lives, coins, points).
     *
     * @return an ArrayList where the 1st element is the change in gold, 2nd change in points, 3rd change in lives.
     */
    abstract ArrayList<Integer> tapResponse();

    /**
     * Communicates with the presenter to draw a TappableObject at its x and y location.
     */
    abstract void draw(LevelOnePresenterInterface presenter);

    /**
     * Moves the tappable object down the screen.
     */
    void move() {
        y = y + 5;
    }

    /**
     * sets the length of the tappable object.
     *
     * @param newLength the new length.
     */
    void setLength(int newLength) {
        length = newLength;
    }

    /**
     * Gets the length of the tappable object.
     *
     * @return the length of the tappable object.
     */
    int getLength() {
        return length;
    }

    /**
     * sets the height of the tappable object.
     *
     * @param newHeight the new height being set to.
     */
    void setHeight(int newHeight) {
        length = newHeight;
    }

    /**
     * gets the height of the tappable object.
     *
     * @return the height of this object.
     */
    int getHeight() {
        return height;
    }
}
