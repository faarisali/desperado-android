package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;


public class ShootingPosition extends TappableObject {
    private boolean selected;

    public ShootingPosition(int newX, int newY, int newLength, int newHeight) {
        super(newX, newY, newLength, newHeight);
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
        //Rect rectangle = new Rect(x, y, super.getLength(), super.getHeight());
        Rect rectangle = new Rect(x, y, x + super.getLength(), y + super.getHeight());
        canvas.drawRect(rectangle, paintText);

    }
}
