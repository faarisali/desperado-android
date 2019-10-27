package com.example.game;

import android.view.MotionEvent;

public class TappableObject extends GameObject {
    private int length;
    private int height;

    public TappableObject(int newX, int newY, int newLength, int newHeight) {
        super(newX, newY);
        length = newLength;
        height = newHeight;
    }

    public boolean isTapped(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        if (super.x <= x && x <= super.x + length) {
            return super.y <= y && x <= super.y + height;
        } else {
            return false;
        }
    }
}
