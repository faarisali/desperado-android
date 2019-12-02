package com.example.game.LevelOne;

import com.example.game.LevelPresenterInterface;

/**
 * Presenter for level one.
 */
public class LevelOnePresenter implements LevelPresenterInterface, LevelOnePresenterInterface{
    /**
     * the view that this presenter presents to.
     */
    LevelOneView levelOneView;

    /**
     * the model that this presenter updates and draws.
     */
    LevelOne levelOneModel;

    /**
     * Constructs a LevelOnePresenter object.
     * @param levelOneView the view that this presenter presents to.
     * @param levelOne the model that this presenter updates and draws.
     */
    public LevelOnePresenter (LevelOneView levelOneView, LevelOne levelOne) {
        this.levelOneView = levelOneView;
        this.levelOneModel = levelOne;
    }

    /**
     * Pause the current level.
     */
    @Override
    public void pauseGame() {
        levelOneModel.setPaused(true);
    }

    /**
     * Unpause the current level.
     */
    @Override
    public void unpauseGame() {
        levelOneModel.setPaused(false);
    }

    /**
     * Update the current level (move/create objects, etc.)
     */
    @Override
    public void updateGame() {
        if (levelOneModel.getLives() > 0 && levelOneModel.isRunning()) {
            levelOneModel.update();
        } else if (!levelOneModel.isRunning() && levelOneModel.getLives() > 0) {
            levelOneView.winGame(levelOneModel.getPoints(), levelOneModel.getGold(), levelOneModel.getLives());
        } else {
            levelOneView.loseGame(levelOneModel.getPoints(), levelOneModel.getGold());
        }
    }

    /**
     * Draw the objects of the level.
     */
    @Override
    public void drawGame () {
        // draw level objects
        levelOneModel.draw(this);

        // print level stats to canvas
        displayLevelStats();
    }

    /**
     * Displays LevelOne statistics in LevelOneView
     */
    private void displayLevelStats() {
        int gold = levelOneModel.getGold();
        int lives = levelOneModel.getLives();
        int points = levelOneModel.getPoints();
        String time = levelOneModel.getTime();
        levelOneView.displayText(gold, lives, points, time);
    }

    /**
     * Tell the level what to do when a tap is detected.
     */
    public void tapEvent(float x, float y) {
        levelOneModel.tapEvent(x, y);
    }


    /**
     * Draws a background with backgroundWidth width and backgroundLength length
     * @param x the width of the background.
     * @param y the height of the background.
     */
    public void drawBackground(int x, int y) {
        levelOneView.drawBackground(x, y);
    }

    /**
     * Draws a dynamite at a given (x,  y) coordinate.
     * @param x the x-coordinate of the dynamite.
     * @param y the y-coordinate of the dynamite.
     */
    public void drawDynamite(int x, int y) {
        levelOneView.drawDynamite(x, y);
    }

    /**
     * Draws a coin at a given (x,  y) coordinate.
     * @param x the x-coordinate of the dynamite.
     * @param y the y-coordinate of the dynamite.
     */
    public void drawCoin(int x, int y) {
        levelOneView.drawCoin(x, y);
    }

    /**
     * Draws a bomb at a given (x,  y) coordinate.
     * @param x the x-coordinate of the dynamite.
     * @param y the y-coordinate of the dynamite.
     */
    public void drawBomb(int x, int y) {
        levelOneView.drawBomb(x, y);
    }
}
