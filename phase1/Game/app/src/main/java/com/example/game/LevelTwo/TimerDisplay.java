package com.example.game.LevelTwo;

import com.example.game.GameObject;
import java.util.ArrayList;

public class TimerDisplay extends GameObject {

    private int second;

    /**
     * Initializes a TimerDisplay object.
     *
     * @param x      x coordinate of top left corner
     * @param y      y coordinate of top left corner
     * @param second the current second of the game's runtime countdown
     */
    public TimerDisplay(int x, int y, int second) {
        super(x, y);
        this.second = second;
    }

    /**
     * Draws a TimerDisplay.
     *
     * @return an arraylist that contains x, y and shouldDisplay;
     */
    public ArrayList<Integer> draw() {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(getX());
        temp.add(getY());
        return temp;
    }
}

