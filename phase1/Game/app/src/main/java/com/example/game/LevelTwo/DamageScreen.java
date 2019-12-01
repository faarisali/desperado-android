package com.example.game.LevelTwo;

import com.example.game.GameObject;

import java.util.ArrayList;

public class DamageScreen extends GameObject {

    int x, y;

    /**
     * Integer acting as a boolean for whether or not the damage screen should be drawn
     */
    int shouldDisplay = 0;

    /**
     * Instantiates a DamageScreen game object.
     *
     * @param x x coordinate of top left corner
     * @param y y coordinate of top left corner
     */
    public DamageScreen(int x, int y) {
        super(x, y);
    }

    /**
     * Draws for the damage screen for 4 cycles of drawing
     */
    public void buffer() {
        if (shouldDisplay >= 1) {
            shouldDisplay++;
            if (shouldDisplay == 4) {
                shouldDisplay = 0;
            }
        }
    }

    /**
     *
     * @return an array list contain x, y and shouldDisplay;
     */
    public ArrayList<Integer> draw() {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(x);
        temp.add(y);
        temp.add(shouldDisplay);
        return temp;
    }

}
