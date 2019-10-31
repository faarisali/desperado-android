package com.example.game;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class LevelTwo extends GenericLevel {

    private ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
    private int groundY = 500;
    private float defaultObstacleMoveSpeed = 9;
    private PlayerLevelTwo player = new PlayerLevelTwo(groundY);


    /**
     * Constructs a GenericLevel
     *
     * @param lives           the number of lives the player starts with on this level.
     */
    public LevelTwo(int lives) {
        new SpawnObstacleTask(this).run();
    }

    public LevelTwo() {
        new SpawnObstacleTask(this).run();
        isRunning = true;
    }

    /**
     * Need to draw background, character and obstacles.
     *
     * @param canvas where the img is drawn
     */
    @Override
    public void draw(Canvas canvas) {
        player.draw(canvas);
        drawObstacles(canvas);
    }


    /**
     * draws every obstacle in managed in this Level2
     *
     * @param canvas      where obstacles are drawn.
     */
    private void drawObstacles(Canvas canvas) {
        for (Obstacle o :
                obstacleList) {
            o.draw(canvas);
        }

    }

    @Override
    public void tapEvent(MotionEvent event) {
        player.jumpUp();
    }

    /**
     * updates every obstacle in managed in this Level2
     */
    private void updateObstacles() {
        for (Obstacle o :
                obstacleList) {
            o.move();
        }
    }
    /**
     * update movement of player (jumps), spawning of obstacles and update
     */
    @Override
    public void update() {
        if (isRunning) {
            player.move();
            updateObstacles();
            detectCollisions();
        }
    }

    private void detectCollisions() {
        for(Obstacle item: obstacleList) {
            if (-40 < player.x - item.x && player.x - item.x < 45){
                if (player.y - item.y > - 60)
                    isRunning = false;
            }
        }
    }


    public ArrayList<Obstacle> getObstacleList() {
        return obstacleList;
    }

    public int getGroundY() {
        return groundY;
    }

    public float getDefaultObstacleMoveSpeed() {
        return defaultObstacleMoveSpeed;
    }
}
