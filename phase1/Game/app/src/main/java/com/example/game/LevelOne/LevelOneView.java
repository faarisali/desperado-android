package com.example.game.LevelOne;

/**
 * The interface that should be implemented by the UI that LevelOnePresenterInterface presents to.
 */
interface LevelOneView {
    /**
     * Draws a background that fits to a given screen width and height.
     * @param screenWidth the width of the screen to draw to.
     * @param screenHeight the height of the screen to draw to.
     */
    void drawBackground(int screenWidth, int screenHeight);

    /**
     * Draws a dynamite at a given (x,  y) coordinate.
     * @param x the x-coordinate of the dynamite.
     * @param y the y-coordinate of the dynamite.
     */
    void drawDynamite(int x, int y);

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
     * Displays LevelOne game statistics.
     * @param gold the number of gold collected to display.
     * @param lives the number of lives left to display.
     * @param points the number of points gained to display.
     * @param time the amount of time left to display.
     */
    void displayText(int gold, int lives, int points, String time);

    /**
     * Instantiate the win game state.
     * @param points the points that the game was lost with.
     * @param gold the gold that was won with.
     * @param lives the lives remaining that were won with.
     */
    void winGame(int points, int gold, int lives);

    /**
     * Instantiate the lose game state.
     * @param points the points that the game was lost with.
     * @param gold the gold that was lost with.
     */
    void loseGame(int points, int gold);
}
