package com.example.game.LevelTwo;

import com.example.game.GameObject;

import java.util.ArrayList;

public class Points extends GameObject {
    private int points;

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Initializes a Points object.
     *
     * @param x      x coordinate of top left corner
     * @param y      y coordinate of top left corner
     * @param points points earned
     */
    public Points(int x, int y, int points) {
        super(x, y);
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    /**
     * Draws a Points object.
     *
     * @return an arraylist that contains x, y
     */
    public ArrayList<Integer> draw() {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(getX());
        temp.add(getY());
        return temp;
    }
}
