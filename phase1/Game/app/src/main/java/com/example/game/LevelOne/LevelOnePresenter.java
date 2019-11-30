package com.example.game.LevelOne;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.game.LevelPresenterInterface;

import java.util.ArrayList;

/**
 * Presenter for level one.
 */
public class LevelOnePresenter implements LevelPresenterInterface {
    LevelOneActivity levelOneView;
    LevelOne levelOneModel;
    ArrayList<TappableObject> levelOneObjects;
    Canvas canvas;

    public LevelOnePresenter (LevelOneActivity levelOneActivity, LevelOne levelOne) {
        this.levelOneView = levelOneActivity;
        this.levelOneModel = levelOne;
    }

    @Override
    public void pauseGame() {
        levelOneModel.setPaused(true);
    }

    @Override
    public void unpauseGame() {
        levelOneModel.setPaused(false);
    }

    @Override
    public void updateGame() {
        if (levelOneModel.getLives() > 0 && levelOneModel.isRunning()) {
            levelOneModel.update();
        } else if (!levelOneModel.isRunning()) {
            levelOneView.winGame(levelOneModel.getPoints(), levelOneModel.getGold(), levelOneModel.getLives());
        } else {
            levelOneView.loseGame(levelOneModel.getPoints(), levelOneModel.getGold());
        }
    }

    @Override
    public void drawGame (Canvas canvas) {
        // set canvas
        this.canvas = canvas;

        // print level stats to canvas
        displayLevelStats(canvas);

        // draw level objects
        levelOneModel.draw(this);
    }

    @Override
    public void drawGame () {
        // set canvas
        this.canvas = canvas;

        // print level stats to canvas
        displayLevelStats(canvas);

        // draw level objects
        levelOneModel.draw(this);
    }

    @Override
    public void tapEvent(MotionEvent event) {
        levelOneModel.tapEvent(event);
    }

    private void displayLevelStats(Canvas canvas) {
        int gold = levelOneModel.getGold();
        int lives = levelOneModel.getLives();
        int points = levelOneModel.getPoints();
        String time = levelOneModel.getTime().toString();
        levelOneView.displayText(canvas, gold, lives, points, time);
    }

    public void drawCoin(int x, int y) {
        levelOneView.drawCoin(x, y, canvas);
    }

    public void drawBomb(int x, int y) {
        levelOneView.drawBomb(x, y, canvas);
    }
}
