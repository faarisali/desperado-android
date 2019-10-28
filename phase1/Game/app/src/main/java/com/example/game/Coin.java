package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;

public class Coin extends TappableObject {
    private Paint paint;

    public Coin(int newX, int newY) {
        super(newX, newY, 50, 50);
        this.paint = new Paint();
        paint.setTextSize(60);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setColor(Color.YELLOW);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(super.x, super.y, 25, paint);
    }

    public void move() {
        y++;
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
