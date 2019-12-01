package com.example.game.LevelTwo;

import android.graphics.Point;

import com.example.game.LevelPresenterInterface;

import java.util.ArrayList;

public class LevelTwoPresenter implements LevelPresenterInterface {

    private LevelTwoModelInterface model;
    private AbstractLevelTwoView view;
    private boolean gameIsPaused;
    private boolean isReplaying;
    private ArrayList<RenderData> renderInfoForReplay = new ArrayList<>();

    public LevelTwoPresenter(AbstractLevelTwoView viewForOutput, LevelTwoModelInterface modelForLogic, boolean isReplaying) {
        model = modelForLogic;
        view = viewForOutput;
        this.isReplaying = isReplaying;
    }

    @Override
    public void pauseGame() {
        gameIsPaused = true;
    }

    @Override
    public void unpauseGame() {
        gameIsPaused = false;
    }

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
        drawHearts(formatter.getLivesLocation(), formatter.getLivesSize());
        drawPlayer(formatter.getPlayerLocation());
        drawObstacles(formatter.getObstacleLocation(), formatter.getObstacleSize());
        drawPauseButton();
    }

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

    private void drawBackground(ArrayList<Point> backgroundInfo) {
        for (Point location : backgroundInfo) {
            view.drawBackground(location);
        }
    }

    private void drawHearts(ArrayList<Point> heartInfo, int size) {
        for (Point location : heartInfo) {
            view.drawHeart(location, size);
        }
    }

    private void drawPoints(Point location, int size, int points) {
        view.drawPoints(location, size, points);

    }

    private void drawTimerDisplay(Point location, int size, int secondsLeft) {
        view.drawTimerDisplay(location, size, secondsLeft);
    }

    private void drawPlayer(Point location) {
        view.drawPlayer(location);
    }

    private void drawObstacles(ArrayList<Point> obstacleInfo, int size) {
        for (Point location : obstacleInfo) {
            view.drawObstacle(location, size);
        }
    }

    private void drawPauseButton() {
        view.drawPauseButton();
    }

    /**
     * Stores replay information into database.
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
