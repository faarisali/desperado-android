package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;

public class Coin extends TappableObject {
    private Paint paintText;

    public Coin(int newX, int newY, int newLength, int newHeight) {
        super(newX, newY, 50, 50);
        this.paintText = new Paint();
        paintText.setTextSize(60);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        paintText.setColor(Color.YELLOW);
    }

    public void draw(Canvas canvas) {
        canvas.drawText("O", x, y, paintText);
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
