package com.example.game;

public class ShootingPosition extends TappableObject {
    private boolean selected;

    public ShootingPosition(int newX, int newY, int newLength, int newHeight) {
        super(newX, newY, newLength, newHeight);
        selected = false;
    }

    /**
     * Finds whether the button is targeted
     * @return selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Sets position to selected/unselected
     * @param selected
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
