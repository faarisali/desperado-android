package com.example.game;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

class GameManager {
    /**
     * Height of the screen.
     */
    private int gridHeight;
    /**
     * Width of the screen.
     */
    private int gridWidth;

    int x, y;
    /**
     * List of all levels in this GameManager.
     */
    private ArrayList<GenericLevel> levelList;

    /**
     * the current level this GameManager is on.
     */
    private GenericLevel currLevel;

    public GameManager(int height, int width) {
        gridHeight = height;
        gridWidth = width;
        levelList = new ArrayList<>();
       // buildLevelList();
        //currLevel = levelList.get(0);//Curr level is the first one first
        currLevel = new LevelOne();
    }

    public void buildLevelList() { //Probably want builder design pattern here idk
        LevelOne myLevelOne = new LevelOne();
        LevelTwo myLevelTwo = new LevelTwo(null,5);
        //LevelThree myLevelThree = new LevelThree(null,5); //Temporary implementation for rn
        levelList.add(myLevelOne);
        levelList.add(myLevelTwo);
        //levelList.add(myLevelThree);
    }

    public void tapEvent(MotionEvent event) {
        currLevel.tapEvent(event);
    }

    public void draw(Canvas canvas) {
        //TODO
        currLevel.draw(canvas);

    }
    public void update() {
        //TODO
        currLevel.update();
    }
}
