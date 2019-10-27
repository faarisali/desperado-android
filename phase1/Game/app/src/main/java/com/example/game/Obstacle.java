package com.example.game;

import android.media.Image;

public class Obstacle {
    //what it looks like (We can just make this a a random shape for now)
    private Image model;
    //Where it is
    private int x, y;
    //How fast it should be moving towards the player (negative value)
    private float Vx;

    public Obstacle(float moveSpeed) {
    }

    //Update the obstacles position according to its speed
    public void move() {
    }

    public void draw() {
    }


}
