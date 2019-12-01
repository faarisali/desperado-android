package com.example.game.LevelOne;

import java.util.ArrayList;
import java.util.List;

class Dynamite extends TappableObject{

    /** Constructor for a new dynamite object
     * @param newX the x coordinate of the dynamite
     * @param newY the y coordinate of the dynamite
     */
    Dynamite(int newX, int newY) {
        super(newX, newY, 50, 50);
    }

    /** Draw this dynamite
     * @param presenter the presenter where the dynamite is drawn
     */
    void draw(LevelOnePresenterInterface presenter) {
        presenter.drawDynamite(getX(), getY());
    }

    @Override
    ArrayList<Integer> tapResponse() {
        return null;
    }

    /** Delete all bombs in level one when the dynamite is tapped
     * @param bombs a list of bombs in level one
     * @param tappables the tappable objects in level one
     */
    void explode(List<TappableObject> tappables, List<TappableObject> bombs) {
        for (TappableObject tappableObject : tappables) {
            if (tappableObject instanceof Bomb) {
                bombs.add(tappableObject);
            }
        }
    }
}
