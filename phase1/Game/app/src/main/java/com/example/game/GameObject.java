package com.example.game;

import android.graphics.Canvas;
import android.media.Image;

public abstract class GameObject {
    public int x;
    public int y;
    private Image image;

    public GameObject(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public abstract void draw(Canvas canvas);

}
