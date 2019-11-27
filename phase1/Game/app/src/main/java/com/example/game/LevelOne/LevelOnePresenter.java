package com.example.game.LevelOne;

import android.graphics.Canvas;

import java.util.logging.Level;

/**
 * Presenter for level one.
 */
public class LevelOnePresenter {
    LevelOneActivity levelOneView;
    LevelOne levelOneModel;

    public LevelOnePresenter (LevelOneActivity levelOneActivity, LevelOne levelOne) {
        this.levelOneView = levelOneActivity;
        this.levelOneModel = levelOne;
    }

    public void draw (Canvas canvas) {

    }

    public void drawCoin(int x, int y, Canvas canvas) {
        levelOneView.drawCoin(x, y, canvas);
    }

    public void drawBomb(int x, int y, Canvas canvas) {
        levelOneView.drawBomb(x, y, canvas);
    }
}
