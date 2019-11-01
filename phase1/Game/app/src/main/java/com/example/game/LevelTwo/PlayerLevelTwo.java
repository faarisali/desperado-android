package com.example.game.LevelTwo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.Image;

import com.example.game.GameObject;

/**
 * The player in Level Two, (will be update with context to other levels in future)
 */
public class PlayerLevelTwo extends GameObject {
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
    public int x, y;
    /**
     * How fast the player will jump
     */
    private double Vy;

    /**
     * Is the player in midair?
     */
    private boolean isFalling = false;

    private final double gravity = 1.6;
    private int ground = 600;
    private final double jumpStrength = -25;


    public PlayerLevelTwo(int ground) {
        super(10, 500);
        x = 10;
        this.ground = ground;
        y = ground;
        Vy = 0;
    }

    /**
     * Player performs a jump
     */
    public void jumpUp() {
        if (!isFalling) {
            Vy = jumpStrength;
            isFalling = true;
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
