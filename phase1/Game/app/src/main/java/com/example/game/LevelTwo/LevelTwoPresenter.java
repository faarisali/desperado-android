package com.example.game.LevelTwo;

import android.graphics.Point;

import com.example.game.LevelPresenterInterface;

import java.util.ArrayList;

/**
 * The presenter class which communicates between LevelTwoModel classes and LevelTwoViews.
 */
public class LevelTwoPresenter implements LevelPresenterInterface {
    /**
     * The model that performs the game logic for level two.
     */
    private LevelTwoModelInterface model;
    /**
     * The view that determines the front-end for level two.
     */
    private AbstractLevelTwoView view;
    /**
     * Represents whether the game has been paused. True iff if level two is paused.
     */
    private boolean gameIsPaused;
    /**
     * Represents whether replay information is being displayed.
     */
    private boolean isReplaying;
    /**
     * The replay information that will be used to show a replay. It is stored in the database
     * after player is finished playing.
     */
    private ArrayList<RenderData> renderInfoForReplay = new ArrayList<>();

    public LevelTwoPresenter(AbstractLevelTwoView viewForOutput, LevelTwoModelInterface modelForLogic, boolean isReplaying) {
        model = modelForLogic;
        view = viewForOutput;
        this.isReplaying = isReplaying;
    }

    /**
     * Pause the current game from updating.
     */
    @Override
    public void pauseGame() {
        gameIsPaused = true;
    }

    /**
     * Unpause the current game so it may update.
     */
    @Override
    public void unpauseGame() {
        gameIsPaused = false;
    }

    /**
     * Update the model so that it may perform logic. If the model is finished executing
     * update view to the end state (for ex. Win-game, Lose-game, etc.).
     */
    @Override
    public void updateGame() {
        if (!gameIsPaused) {
            int state = model.getState();
            if (state == 0) {
                model.update();
            } else if (state == 1 && !isReplaying) {
                storeReplay();
                view.winGame(model.getPoints(), model.getGold(), model.getLives());
            } else if (state == 1) {
                view.finish();
            } else {
                storeReplay();
                view.loseGame(model.getPoints(), model.getGold());
            }
        }

    }

    /**
     * Draw the objects of the level two model through the view.
     */
    @Override
    public void drawGame() {
        RenderData data = model.draw();
        renderInfoForReplay.add(data);
        LevelTwoDataFormatter formatter = new LevelTwoDataFormatter(data);
        drawBackground(formatter.getBackgroundLocation());
        drawPoints(formatter.getPointsLocation(), formatter.getPointsSize(),
                formatter.getPoints());
        drawTimerDisplay(formatter.getTimerDisplayLocation(), formatter.getTimerDisplaySize(),
                formatter.getSecondsLeft());
        drawHearts(formatter.getLivesLocation());
        drawGround();
        drawPlayer(formatter.getPlayerLocation(), formatter.getPlayerIsJumping());
        drawObstacles(formatter.getObstacleLocation());
        drawPauseButton();
        drawDamageScreen(formatter.getDamageScreenLocation(), formatter.getDamageScreenShouldDisplay());
    }

    /**
     * Tell the view to draw ground.
     */
    private void drawGround() {
        view.drawGround();
    }

    /**
     * Tell the model that a screen tap has occurred. If the tap is on the pause button, pause the game.
     *
     * @param x is the x-coordinate of the tap.
     * @param y is the y-coordinate of the tap.
     */
    @Override
    public void tapEvent(float x, float y) {
        if (!gameIsPaused) {
            if (1000 <= x && x <= 1070 && 30 <= y && y <= 100) {
                pauseGame();
                view.pause();
            } else {
                model.tapEvent();
            }

        }
    }

    /**
     * Tell the view to draw the background items.
     * @param backgroundInfo the information the view needs to draw backgrounds.
     */
    private void drawBackground(ArrayList<Point> backgroundInfo) {
        for (Point location : backgroundInfo) {
            view.drawBackground(location);
        }
    }

    /**
     * Tell the view to draw hears which represent lives.
     * @param heartInfo the information the view needs to draw hearts (heart locations).
     */
    private void drawHearts(ArrayList<Point> heartInfo) {
        for (Point location : heartInfo) {
            view.drawHeart(location);
        }
    }

    /**
     * Tell the view to draw the points counter on the screen.
     * @param location the location of the points counter.
     * @param size the size of the font of the points counter.
     * @param points the number of points to display.
     */
    private void drawPoints(Point location, int size, int points) {
        view.drawPoints(location, size, points);

    }

    /**
     * Tell the view to draw the timer display.
     * @param location the location of the timer display.
     * @param size the size of the timer display's font.
     * @param secondsLeft the number of seconds left in the countdown.
     */
    private void drawTimerDisplay(Point location, int size, int secondsLeft) {
        view.drawTimerDisplay(location, size, secondsLeft);
    }

    /**
     * Tell the view to draw the player model.
     * @param location is the location of the player hit-box.
     * @param isJumping is 1 iff the player is currently jumping, else its 0.
     */
    private void drawPlayer(Point location, int isJumping) {
        view.drawPlayer(location, isJumping);
    }

    /**
     * Tell the view to draw all the obstacle objects.
     * @param obstacleInfo the locations of the obstacles.
     */
    private void drawObstacles(ArrayList<Point> obstacleInfo) {
        for (Point location : obstacleInfo) {
            view.drawObstacle(location);
        }
    }

    /**
     * Tell the view to draw the pause button.
     */
    private void drawPauseButton() {
        view.drawPauseButton();
    }

    /**
     * Tell the view to tint the screen as a collision has occurred.
     * @param location the location where the tint originates.
     * @param shouldDisplay whether or not the screen should be tinted during this moment.
     *                      1 iff screen should be tinted, else its 0.
     */
    private void drawDamageScreen(Point location, int shouldDisplay) {
        view.drawDamageScreen(location, shouldDisplay);
    }

    /**
     * Stores replay information into database.
     * Generates a string representation of ArrayList<RenderData>
     * Format: renderdata0%renderdata1%renderdata2 ....
     */
    private void storeReplay() {
        StringBuilder dataToStore = new StringBuilder();
        int i = 0;
        for (RenderData entry : renderInfoForReplay) {
            dataToStore.append(entry.generateStorable(String.valueOf(i)));
            dataToStore.append("%");
            i++;
        }
        dataToStore.deleteCharAt(dataToStore.length() - 1);
        view.storeReplay(dataToStore.toString());
    }


}
