package com.example.game.LevelTwo;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.graphics.Color;
import com.example.game.GenericLevel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class LevelTwo extends GenericLevel {

    private ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
    private int groundY = 500;
    private float defaultObstacleMoveSpeed = 9;
    private PlayerLevelTwo player = new PlayerLevelTwo(10, groundY, 60, Color.BLUE);
    private int lives;
    private Timer time = new Timer();
    private ArrayList<Heart> heartList = new ArrayList<>();

    /**
     * Constructs a GenericLevel
     *
     * @param lives           the number of lives the player starts with on this level.
     */
    public LevelTwo(int lives) {
        new SpawnObstacleTask(this).run();
        this.lives = lives;
        countDown(5);
        populateHeartList(this.lives);
    }

    public LevelTwo() {
        new SpawnObstacleTask(this).run();
        isRunning = true;
        this.lives = 3;
        countDown(5);
        populateHeartList(this.lives);
    }

    private void returnToMain() {
    }

    private void populateHeartList(int lives) {
        int xIncrement = 45;
        for (int i = 0; i < lives; i++) {
            heartList.add(new Heart(xIncrement, 55, 60, Color.RED));
            xIncrement += 80;
        }

    }

    private void countDown(int seconds) {
        this.time.schedule(new TimerTask() {
            @Override
            public void run() {
//                returnToMain();
//                isRunning = false;
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
        drawHearths(canvas);
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

    private void drawHearths(Canvas canvas) {
        for (Heart h :
                heartList) {
            h.draw(canvas);
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
            removeOutOfBoundsObstacles(o);
            o.move();

        }
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
        heartList.remove(heartList.size() - 1);
        if (this.lives == 0) {
            isRunning = false;
        }
    }

    private void detectCollisions() {
        for(Obstacle item: obstacleList) {
            if (item.isCollided() == false & player.y - item.y > -60) {
                if (player.x - item.x > -40 && player.x - item.x < 40) {
                    updateLives();
                    item.setCollided(true);
                }
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
