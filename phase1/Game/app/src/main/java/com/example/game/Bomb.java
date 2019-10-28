package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;

/** A bomb that harms the player in level 1*/
public class Bomb extends TappableObject {
    private Paint paintText;

    public Bomb(int newX, int newY, int newLength, int newHeight) {
        super(newX, newY, newLength, newHeight);
        this.paintText = new Paint();
        paintText.setTextSize(60);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        paintText.setColor(Color.GRAY);
    }

    public void draw(Canvas canvas) {
        canvas.drawText("X", x, y, paintText);
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
}
