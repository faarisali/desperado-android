package com.example.game.LevelOne;

import java.util.ArrayList;

/** A coin in level 1*/
public class Coin extends TappableObject {

    /** Constructor for a new coin object*/
    public Coin(int newX, int newY) {
        super(newX, newY, 50, 50);
    }

    @Override
    /** Draw this coin*/
    public void draw(LevelOnePresenter presenter) {
        presenter.drawCoin(super.x, super.y);
    }

    public ArrayList<Integer> tapResponse(){
        ArrayList<Integer> response = new ArrayList<>();
        response.add(1);
        response.add(100);
        response.add(0);
        return response;
    }

}
