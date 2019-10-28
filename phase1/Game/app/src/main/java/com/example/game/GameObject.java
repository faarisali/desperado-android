package com.example.game;

import android.graphics.Canvas;
import android.media.Image;

abstract class GameObject {
    int x;
    int y;
    private Image image;

    public GameObject(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public abstract void draw(Canvas canvas);

}
