package com.example.game;

import android.graphics.Canvas;
import android.view.MotionEvent;

public class TappableObject extends GameObject {
    /**
     * length of hitbox.
     */
    private int length;
    /**
     * height of hitbox.
     */
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

    public boolean tapped(int x, int y) {
        if (this.x <= x && x <= this.x + length) {
            return this.y <= y && x <= this.y + height;
        } else {
            return false;
        }
    }

    @Override
    public void draw(Canvas canvas) {

    }
    public void move() {
        y = y + 5;
    }

    public void setLength(int newLength) {
        length = newLength;
    }

    public int getLength() {
        return length;
    }

    public void setHeight(int newHeight) {
        length = newHeight;
    }

    public int getHeight() {
        return height;
    }

//    public boolean outOfBounds() {
//
//    }
}
