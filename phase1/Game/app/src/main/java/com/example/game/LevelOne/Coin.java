package com.example.game.LevelOne;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;

/** A coin in level 1*/
public class Coin extends TappableObject {

    /** The style of this coin*/
    private Paint paint;

    /** Constructor for a new coin object*/
    public Coin(int newX, int newY) {
        super(newX, newY, 150, 150);
        this.paint = new Paint();
        paint.setTextSize(60);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setColor(Color.YELLOW);
    }

    /** Draw this coin*/
    public void draw(Canvas canvas) {
        canvas.drawCircle(super.x + 25, super.y + 25, 25, paint);
    }

    /** Response of this coin when tapped*/
    public boolean tapped(int x, int y) {
        if (super.x <= x && x <= super.x + super.getLength()) {
            return super.y <= y && y <= super.y + super.getLength();
        } else {
            return false;
        }
    }
}
