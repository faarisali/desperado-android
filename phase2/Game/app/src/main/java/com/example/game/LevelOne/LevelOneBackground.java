package com.example.game.LevelOne;

/**
 The background for level one
 */
class LevelOneBackground {
    /** The background width */
    private int backgroundWidth;
    /** The background height */
    private int backgroundLength;
    /** Create a new background for level one
     * @param screenWidth the width of the screen
     * @param screenLength the length of the screen
     */
    LevelOneBackground(int screenWidth, int screenLength) {
        backgroundWidth = screenWidth;
        backgroundLength = screenLength;
    }

    /** Draw the background in level one
     * @param presenter the presenter where the background is drawn
     */
    void draw(LevelOnePresenterInterface presenter) {
        presenter.drawBackground(backgroundWidth, backgroundLength);
    }
}
