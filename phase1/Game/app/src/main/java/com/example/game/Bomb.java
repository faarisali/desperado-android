package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;

/** A bomb that harms the player in level 1*/
public class Bomb extends TappableObject {
    private Paint paint;

    public Bomb(int newX, int newY) {
        super(newX, newY, 50, 50);
        this.paint = new Paint();
        paint.setTextSize(60);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setColor(Color.GRAY);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(super.x + 25, super.y + 25, 25, paint);
    }

    public boolean isTapped(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        if (super.x <= x && x <= super.x + super.getLength()) {
            return super.y <= y && x <= super.y + super.getHeight();
        } else {
            return false;
        }
    }

    public boolean tapped(int x, int y) {
        if (super.x <= x && x <= super.x + super.getLength()) {
            return super.y <= y && y <= super.y + super.getLength();
        } else {
            return false;
        }
    }
}
