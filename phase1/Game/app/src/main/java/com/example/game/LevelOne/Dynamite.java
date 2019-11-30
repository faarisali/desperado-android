package com.example.game.LevelOne;

import java.util.ArrayList;
import java.util.List;

public class Dynamite extends TappableObject{

    /** Constructor for a new dynamite object*/
    public Dynamite(int newX, int newY) {
        super(newX, newY, 50, 50);
    }

    /** Draw this dynamite*/
    public void draw(LevelOnePresenter presenter) {
        presenter.drawDynamite(x, y);
    }

    @Override
    public ArrayList<Integer> tapResponse() {
        return null;
    }

    public void explode(List<TappableObject> tappables, List<TappableObject> bombs) {
        for (TappableObject tappableObject : tappables) {
            if (tappableObject instanceof Bomb) {
                bombs.add(tappableObject);
            }
        }
    }
}
