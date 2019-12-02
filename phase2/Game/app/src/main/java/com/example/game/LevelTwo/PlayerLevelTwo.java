package com.example.game.LevelTwo;

import java.util.ArrayList;

/**
 * The player in Level Two
 */
public class PlayerLevelTwo {
    /**
     * The current vertical velocity of the player.
     */
    private double Vy;

    /**
     * Is the player in midair?
     */
    private boolean isFalling = false;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * The x,y coordinates of the player.
     */
    private int x, y;
    /**
     * How fast the player falls to the ground.
     */
    private final double gravity = 1.6;
    /**
     * The location of the ground, where player will be running.
     */
    private int ground;

    private double jumpStrength;

    public PlayerLevelTwo(int x, int y) {
        this.x = x;
        this.y = y + 15;
        this.ground = y + 15;
        Vy = 0;
        jumpStrength = -25;
    }

    public PlayerLevelTwo(int x, int y, int jumpStrength) {
        this.x = x;
        this.y = y + 15;
        this.ground = y + 15;
        Vy = 0;
        this.jumpStrength = jumpStrength;
    }

    /**
     * Player performs a jump. The player cannot jump again until it hits the ground.
     */
    public void jumpUp() {
        if (!isFalling) {
            Vy = jumpStrength;
            isFalling = true;
        }
    }

    /**
     * Returns whether the player is airborne.
     *
     * @return
     */
    private int isJumping() {
        if (y >= ground) {
            return 0;
        }
        return 1;
    }

    /**
     * Update the players velocity w.r.t gravity.
     */
    private void fall() {
        Vy += gravity;
    }

    /**
     * Make the player move according to its Vy (vertical) velocity.
     */
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
     * Return the drawing information for the player.
     */
    public ArrayList<Integer> draw() {
        //canvas.drawText("O", this.x, this.y, getPaintText());
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(x);
        temp.add(y);
        temp.add(isJumping());
        return temp;
    }
}
