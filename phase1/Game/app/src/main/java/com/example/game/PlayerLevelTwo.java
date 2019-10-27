package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.Image;

/**
 * The player in Level Two, (will be update with context to other levels in future)
 */
public class PlayerLevelTwo {
    /**
     * How the object looks (2 states to accomodate running)
     */
    private Image modelState1;

    /**
     * How the object looks (2 states to accomodate running)
     */
    private Image modelState2;
    /**
     * Player's locaton
     */
    private int x, y;
    /**
     * How fast the player will jump
     */
    private double Vy;
    private boolean isFalling = false;

    private final double gravity = 1;
    private final int ground = 500;
    private final double jumpStrength = -25;
    private boolean isJumping;


    public PlayerLevelTwo() {
        x = 10;
        y = ground;
        Vy = 0;
    }

    /**
     * Player performs a jump
     */
    public void jumpUp() {
        if (!isJumping) {
            isFalling = true;
            Vy = jumpStrength;
        }

    }

    private void fall() {
        Vy += gravity;
    }

    public void move() {
        if (Vy + y <= ground) {
            y += Vy;
        } else {
            y = ground;
            Vy = 0;
            isFalling = false;
        }
        if (isFalling) {
            this.fall();
        }

    }

    /**
     * Draw the player.
     */
    public void draw(Canvas canvas) {
        Paint paintText = new Paint();
        paintText.setTextSize(60);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        paintText.setColor(Color.BLUE);

        canvas.drawText("O", x, y, paintText);

    }
}
