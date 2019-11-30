package com.example.game.LevelOne;

import android.graphics.Canvas;

import java.util.ArrayList;

/** A bomb that harms the player in level 1*/
public class Bomb extends TappableObject {


    /** Constructor for a new bomb object*/
    public Bomb(int newX, int newY) {
        super(newX, newY, 50, 50);
    }

    @Override
    /** Draw this bomb*/
    public void draw(LevelOnePresenter presenter) {
        presenter.drawBomb(super.x, super.y);
    }

    public ArrayList<Integer> tapResponse(){
        ArrayList<Integer> response = new ArrayList<>();
        response.add(0);
        response.add(-1000);
        response.add(-1);
        return response;
    }
}
