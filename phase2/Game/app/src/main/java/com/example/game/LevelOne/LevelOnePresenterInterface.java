package com.example.game.LevelOne;

/**
 * The interface for a presenter used by LevelOne
 */
interface LevelOnePresenterInterface {
    /**
     * Draws a background with backgroundWidth width and backgroundLength length
     * @param backgroundWidth the width of the background.
     * @param backgroundLength the length of the background.
     */
    void drawBackground(int backgroundWidth, int backgroundLength);

    /**
     * Draws a bomb at a given (x,  y) coordinate.
     * @param x the x-coordinate of the dynamite.
     * @param y the y-coordinate of the dynamite.
     */
    void drawBomb(int x, int y);

    /**
     * Draws a coin at a given (x,  y) coordinate.
     * @param x the x-coordinate of the dynamite.
     * @param y the y-coordinate of the dynamite.
     */
    void drawCoin(int x, int y);

    /**
     * Draws a dynamite at a given (x,  y) coordinate.
     * @param x the x-coordinate of the dynamite.
     * @param y the y-coordinate of the dynamite.
     */
    void drawDynamite(int x, int y);
}
