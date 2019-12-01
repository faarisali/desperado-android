package com.example.game.LevelTwo;

import android.graphics.Point;

import com.example.game.GameObject;

public class LevelTwoBackground extends GameObject {

    private boolean reversedFirst = false;
    int x, y;

    public LevelTwoBackground(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    public Point draw() {
        return (new Point(this.x, this.y));
    }

    public void update(int xIncrement) {
        x = x + xIncrement;
    }

    public boolean isReversedFirst() {
        return reversedFirst;
    }


    public void setReversedFirst(boolean reversedFirst) {
        this.reversedFirst = reversedFirst;
    }

}
