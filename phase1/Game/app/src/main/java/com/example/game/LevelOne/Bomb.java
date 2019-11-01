package com.example.game.LevelOne;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;

/** A bomb that harms the player in level 1*/
public class Bomb extends TappableObject {

    /** The style of this bomb*/
    private Paint paint;

    /** Constructor for a new bomb object*/
    public Bomb(int newX, int newY) {
        super(newX, newY, 50, 50);
        this.paint = new Paint();
        paint.setTextSize(60);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setColor(Color.GRAY);
    }

    /** Draw this bomb*/
    public void draw(Canvas canvas) {
        canvas.drawCircle(super.x + 25, super.y + 25, 25, paint);
    }

    /** Response of this bomb when tapped*/
    public boolean tapped(int x, int y) {
        if (super.x <= x && x <= super.x + super.getLength()) {
            return super.y <= y && y <= super.y + super.getLength();
        } else {
            return false;
        }
    }
}
