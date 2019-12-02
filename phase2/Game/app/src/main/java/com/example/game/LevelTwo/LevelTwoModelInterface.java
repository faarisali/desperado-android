package com.example.game.LevelTwo;

/**
 * An interface to describe a level two model.
 */
public interface LevelTwoModelInterface {
    /**
     * Update the model logic.
     */
    void update();

    /**
     * @return Rendering information that will be used by front-end to display visuals.
     */
    RenderData draw();

    /**
     * Perform logic associated with a screen tap.
     */
    void tapEvent();

    /**
     * Return the state of the model.
     *
     * @return 0 if model is still running, 1 if there is a win, and -1 if there is a loss.
     */
    int getState();

    /**
     * @return the number of lives the player has left during this run.
     */
    int getLives();

    /**
     * @return the gold earned so far during the run (from instantiation of the model object).
     */
    int getGold();

    /**
     * @return the number of points earned so far during the current run.
     */
    int getPoints();
}
