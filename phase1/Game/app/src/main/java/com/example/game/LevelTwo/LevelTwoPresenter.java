package com.example.game.LevelTwo;

import android.graphics.Point;

import com.example.game.LevelPresenterInterface;

import java.util.ArrayList;

public class LevelTwoPresenter implements LevelPresenterInterface {

    private LevelTwo model;
    private LevelTwoActivity view;
    private boolean gameIsPaused;
    private ArrayList<RenderData> renderInfoForReplay = new ArrayList<>();

    public LevelTwoPresenter(LevelTwoActivity viewForOutput, LevelTwo modelForLogic) {
        model = modelForLogic;
        view = viewForOutput;
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
            if (model.getLives() > 0 && model.isRunning()) {
                model.update();
            } else if (!model.isRunning() && model.getLives() > 0) {
                view.winGame(model.getPoints(), model.getGold(), model.getLives());
            } else {
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
        drawPlayer(formatter.getPlayerLocation(), formatter.getPlayerSize());
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

    private void drawPlayer(Point location, int size) {
        view.drawPlayer(location, size);
    }

    private void drawObstacles(ArrayList<Point> obstacleInfo, int size) {
        for (Point location : obstacleInfo) {
            view.drawObstacle(location, size);
        }
    }

    private void drawPauseButton() {
        view.drawPauseButton();
    }


}
