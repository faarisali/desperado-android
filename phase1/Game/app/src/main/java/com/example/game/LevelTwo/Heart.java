package com.example.game.LevelTwo;

import android.graphics.Point;

import com.example.game.GameObject;

public class Heart extends GameObject {

    public Heart(int x, int y, int size, int color) {
        super(x, y);

    }

    public Point draw() {
        return new Point(this.x, this.y);
    }
}
