package com.example.game.LevelOne;


import java.util.ArrayList;

/**
 * A bomb that harms the player in level 1
 */
class Bomb extends TappableObject {


    /**
     * Constructor for a new bomb object
     */
    Bomb(int newX, int newY) {
        super(newX, newY, 50, 50);
    }

    /**
     * Communicates with the presenter to draw a bomb at its x and y location.
     */
    @Override
    void draw(LevelOnePresenterInterface presenter) {
        presenter.drawBomb(getX(), getY());
    }

    /**
     * Generates the 'response' to a bomb getting tapped, i.e. how it affects game stats (lives, coins, points).
     *
     * @return an ArrayList where the 1st element is the change in gold, 2nd change in points, 3rd change in lives.
     */
    ArrayList<Integer> tapResponse() {
        ArrayList<Integer> response = new ArrayList<>();
        response.add(0); //Change in gold associated with touching a bomb.
        response.add(-1000); //Change in points associated with touching a bomb.
        response.add(-1); //Change in lives associated with touching a bomb.
        return response;
    }
}
