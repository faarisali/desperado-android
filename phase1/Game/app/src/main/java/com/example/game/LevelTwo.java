package com.example.game;

import android.content.Intent;
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
    private int lives;
    private Timer time = new Timer();

    /**
     * Constructs a GenericLevel
     *
     * @param lives           the number of lives the player starts with on this level.
     */
    public LevelTwo(int lives) {
        new SpawnObstacleTask(this).run();
        this.lives = lives;
        countDown(5);
    }

    public LevelTwo() {
        new SpawnObstacleTask(this).run();
        isRunning = true;
        this.lives = 3;
        countDown(5);
    }

    private void returnToMain() {
    }


    private void countDown(int seconds) {
        this.time.schedule(new TimerTask() {
            @Override
            public void run() {
                returnToMain();
            }
        }, seconds * 1000);//5 second countdown
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
        removeOutOfBoundsObstacles(this.obstacleList.get(0));
    }

    private void removeOutOfBoundsObstacles(Obstacle o) {
        if (o.isOutOfBounds()) {
            this.obstacleList.remove(o);
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

    private void updateLives() {
        this.lives--;
        if (this.lives == 0) {
            returnToMain();
        }
    }

    private void detectCollisions() {
        for(Obstacle item: obstacleList) {
            if (-40 < player.x - item.x && player.x - item.x < 45){
                if (player.y - item.y > - 60)
                    updateLives();
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
