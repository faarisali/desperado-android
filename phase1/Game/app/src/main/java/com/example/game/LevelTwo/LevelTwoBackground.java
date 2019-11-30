package com.example.game.LevelTwo;

import android.graphics.Canvas;
import android.graphics.Point;

import com.example.game.GameObject;

public class LevelTwoBackground extends GameObject {

    private boolean reversedFirst = false;
    int x, y;

    public LevelTwoBackground(int x, int y, int size, int color) {
        super(x, y, size, color);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    public Point draw() {
        return (new Point(this.x, this.y));
    }

    public void update(int xIncrement) {
        // x = x + xIncrement;
    }

    public boolean isReversedFirst() {
        return reversedFirst;
    }


    public void setReversedFirst(boolean reversedFirst) {
        this.reversedFirst = reversedFirst;
    }

}
