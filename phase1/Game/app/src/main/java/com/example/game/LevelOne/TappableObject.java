package com.example.game.LevelOne;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.game.GameObject;

import java.util.ArrayList;

public abstract class TappableObject extends GameObject {
    /**
     * length of hitbox.
     */
    private int length;
    /**
     * height of hitbox.
     */
    private int height;

    private final int hitboxBuffer = 25;

    public TappableObject(int newX, int newY, int newLength, int newHeight) {
        super(newX, newY);
        length = newLength;
        height = newHeight;
    }

    public boolean tapped(float x, float y) {
        if (this.x - hitboxBuffer <= x && x <= this.x + length + hitboxBuffer) {
            return this.y -hitboxBuffer <= y && y <= this.y + height + hitboxBuffer;
        } else {
            return false;
        }
    }

    public abstract ArrayList<Integer> tapResponse();

    public abstract void draw(LevelOnePresenter presenter);

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
