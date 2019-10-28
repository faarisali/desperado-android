package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;


public class ShootingPosition extends TappableObject {
    private boolean selected;
    private Rect myRect;

    public ShootingPosition(int newX, int newY, int newLength, int newHeight) {
        super(newX, newY, newLength, newHeight);
        myRect =  new Rect(x, y, x + newLength, y + newHeight);
        selected = false;
    }

    /**
     * Finds whether the button is targeted
     * @return selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * returns the rectangle that defines this ShootingPosition
     * @return myRect
     */
    public Rect getMyRect() {
        return myRect;
    }

    /**
     * Sets position to selected/unselected
     * @param selected whether this position is selected
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * Draw the player.
     */
    public void draw(Canvas canvas) {
        Paint paintText = new Paint();
        paintText.setTextSize(60);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        paintText.setColor(Color.BLUE);
        //left top right bottom
        if (isSelected()) {
            paintText.setColor(Color.RED);
        }
        canvas.drawRect(myRect, paintText);

    }

    public boolean isTapped(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        return myRect.contains((int)x, (int)y);
    }
}
