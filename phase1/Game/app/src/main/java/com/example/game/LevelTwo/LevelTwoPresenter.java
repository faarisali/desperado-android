package com.example.game.LevelTwo;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.game.LevelPresenterInterface;

public class LevelTwoPresenter implements LevelPresenterInterface {

    private LevelTwo model;
    private LevelTwoActivity view;
    private boolean gameIsPaused;

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
            model.update();
        }

    }

    @Override
    public void drawGame(Canvas canvas) {

    }

    @Override
    public void tapEvent(MotionEvent event) {
        model.tapEvent(event);
    }
}
