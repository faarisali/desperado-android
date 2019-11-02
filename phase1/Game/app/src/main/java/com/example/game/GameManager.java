package com.example.game;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.game.LevelOne.LevelOne;
import com.example.game.LevelTwo.LevelTwo;


/**
 * Presenter and Controller class for game levels.
 */
public class GameManager {
    /**
     * Height of the screen.
     */
    private int gridHeight;
    /**
     * Width of the screen.
     */
    private int gridWidth;

    public void setObserver(GameManagerObserver observer) {
        this.observer = observer;
    }

    private GameManagerObserver observer;

    /**
     * List of all levels in this GameManager.
     */

    public boolean isPaused;

    public int getTotalLivesLost() {
        return totalLivesLost;
    }

    public int getCurrLives() {
        return currLevel.getLives();
    }

    public int getPoints() {
        return points;
    }

    public int getCurrPoints() {
        return currLevel.getPoints();
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public int getCurrGold() {
        return currLevel.getGold();
    }

    private int totalLivesLost;
    private int points;
    private int goldCoins;

    /**
     * the current level this GameManager is on.
     */
    private GenericLevel currLevel;


    public GameManager(int height, int width) {
        gridHeight = height;
        gridWidth = width;
        isPaused = false;

    }

    /**
     * input the level the number
     *
     * @param level the level to be selected.
     */

    public void changeLevel(int level) {
        switch (level) {
            case 1:
                currLevel = new LevelOne();
                break;
            case 2:
                currLevel = new LevelTwo();
                break;
            default:
                break;
        }
    }

    public boolean isCurrLevelRunning() {
        return currLevel.isRunning;
    }


    public void tapEvent(MotionEvent event) {
        if (!isPaused) {
            currLevel.tapEvent(event);
        }
    }

    public void startCurrLevel() {
        currLevel.isRunning = true;
    }

    public void draw(Canvas canvas) {
        currLevel.draw(canvas);

    }

    public void update() {
        if (!isPaused) {
            currLevel.update();
            observer.update(this);
        }
    }

    public void togglePause() {
        isPaused = !isPaused;
    }

    public void currLevelStop() {
        currLevel.isRunning = false;
    }

    public void updateStats() {
        totalLivesLost -= 3 - currLevel.getLives();
        points += currLevel.getPoints();
        goldCoins += currLevel.getGold();

    }



}
