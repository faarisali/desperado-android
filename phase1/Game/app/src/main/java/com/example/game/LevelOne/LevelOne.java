package com.example.game.LevelOne;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;

import com.example.game.GenericLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class LevelOne extends GenericLevel {

    public String getTime() {
        return Integer.toString(gameTimer.getSeconds());
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    private boolean isPaused;

    private GameTimer gameTimer;

    private List<TappableObject> tappables = new ArrayList<>();

    public LevelOneBackground background;

    private TappableObject tappableToRemove;


    public LevelOne(int screenWidth, int screenLength) {
        super(3);
        isRunning = true;
        isPaused = false;
        background = new LevelOneBackground(screenWidth, screenLength);
        tappableToRemove = null;
        gameTimer = new GameTimer(31);
    }

    public void spawnTappables() {
        double randDouble = Math.random();
        randDouble = randDouble * 1080 + 1;
        int randHorizontal = (int) randDouble;
        double rand = Math.random();
        if (rand < 0.05) {
            tappables.add(new Coin(randHorizontal, 20));
        } else if (rand > 0.99) {
            tappables.add(new Bomb(randHorizontal, 20));
        }
    }

    public void checkLives() {
        if (getLives() <= 0) {
            isRunning = false;
            System.out.println("Out of lives");
        }
    }

    public void draw(LevelOnePresenter presenter) {
        background.draw(presenter);
        for (TappableObject tappableObject : tappables) {
            tappableObject.draw(presenter);
        }

        if (tappableToRemove != null) {
            tappables.remove(tappableToRemove);
        }
    }

    @Override
    public void update() {
        if (!isPaused) {
            spawnTappables();
            for (int i = 0; i < tappables.size(); i++) {
                tappables.get(i).move();
            }
        }

        if (gameTimer.getSeconds() <= 0) {
            isRunning = false;
        }
    }

    @Override
    public void tapEvent(float x, float y) { // TODO: move motion even to front end Question, should this be in activity (view) or presenter/controller
        ArrayList<TappableObject> remove = new ArrayList<>();
        for (TappableObject tappableObject : tappables) {
            if (tappableObject.tapped(x, y)) {
                remove.add(tappableObject);
                ArrayList<Integer> values = tappableObject.tapResponse();
                super.setGold(super.getGold() + values.get(0));
                super.setPoints(super.getPoints() + values.get(1));
                super.setLives(super.getLives() + values.get(2));
                checkLives();
            }
        }

        // remove single coin per tap
        if (remove.size() > 0) {
            tappableToRemove = remove.get(0);
        }
    }
}
