package com.example.game.LevelTwo;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;

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
    public void drawGame(Canvas canvas) {
        RenderData data = model.draw();
        renderInfoForReplay.add(data);
        LevelTwoDataFormatter formatter = new LevelTwoDataFormatter(data);
        drawPoints(canvas, formatter.getPointsLocation(), formatter.getPointsSize(),
                formatter.getPoints());
        drawTimerDisplay(canvas, formatter.getTimerDisplayLocation(), formatter.getTimerDisplaySize(),
                formatter.getSecondsLeft());
        drawHearts(canvas, formatter.getLivesLocation(), formatter.getLivesSize());
        drawPlayer(canvas, formatter.getPlayerLocation(), formatter.getPlayerSize());
        drawObstacles(canvas, formatter.getObstacleLocation(), formatter.getObstacleSize());
        drawPauseButton(canvas);
    }

    @Override
    public void tapEvent(MotionEvent event) {
        if (!gameIsPaused) {
            float x = event.getX();
            float y = event.getY();
            if (1000 <= x && x <= 1070 && 30 <= y && y <= 100) {
                pauseGame();
                view.pause();
            } else {
                model.tapEvent(event);
            }

        }
    }

    private void drawHearts(Canvas canvas, ArrayList<Point> heartInfo, int size) {
        for (Point location : heartInfo) {
            view.drawHeart(canvas, location, size);
        }
    }

    private void drawPoints(Canvas canvas, Point location, int size, int points) {
        view.drawPoints(canvas, location, size, points);

    }

    private void drawTimerDisplay(Canvas canvas, Point location, int size, int secondsLeft) {
        view.drawTimerDisplay(canvas, location, size, secondsLeft);
    }

    private void drawPlayer(Canvas canvas, Point location, int size) {
        view.drawPlayer(canvas, location, size);
    }

    private void drawObstacles(Canvas canvas, ArrayList<Point> obstacleInfo, int size) {
        for (Point location : obstacleInfo) {
            view.drawObstacle(canvas, location, size);
        }
    }

    private void drawPauseButton(Canvas canvas) {
        view.drawPauseButton(canvas);
    }


}
