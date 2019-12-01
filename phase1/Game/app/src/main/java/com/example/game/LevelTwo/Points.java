package com.example.game.LevelTwo;

import com.example.game.GameObject;

import java.util.ArrayList;

public class Points extends GameObject {
    private int points;

    public void setPoints(int points) {
        this.points = points;
    }

    public Points(int x, int y, int points) {
        super(x, y);
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public ArrayList<Integer> draw() {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(getX());
        temp.add(getY());
        return temp;
    }
}
