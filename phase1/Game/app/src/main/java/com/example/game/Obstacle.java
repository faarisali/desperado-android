package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.Image;

public class Obstacle extends GameObject {

    /**
     * How fast the obstacle should be moving towards the player (negative value)
     */
    private float Vx;

    /**
     * Create a new obstacle.
     *
     * @param moveSpeed how fast this obstacle is going to be moving
     */
    public Obstacle(int x, int y, float moveSpeed) {
        super(x, y);
        this.Vx = moveSpeed;
    }

    /**
     * Move the obstacle according to to its speed Vx
     */
    public void move() {
        x -= Vx;
    }

    /**
     * Draw the obstacle.
     */
    @Override
    public void draw(Canvas canvas) {
        Paint paintText = new Paint();
        paintText.setTextSize(60);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        paintText.setColor(Color.GREEN);

        canvas.drawText("[]", x, y, paintText);
    }


}
