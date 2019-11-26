package com.example.game.LevelTwo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

import com.example.game.GenericLevel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class LevelTwo extends GenericLevel {

    private ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
    private int groundY = 500;
    private float defaultObstacleMoveSpeed = 9;
    private PlayerLevelTwo player = new PlayerLevelTwo(10, groundY, 60, Color.BLUE);
    private Points points = new Points(45, 110, 50, Color.WHITE, 0);
    private Timer time = new Timer();

    private int lives = 3;
    private ArrayList<Heart> heartList = new ArrayList<>();
    /**
     * Constructs a GenericLevel
     *
     * @param lives  the number of lives the player starts with on this level.
     */
    public LevelTwo(int lives) {
        new SpawnObstacleTask(this).run();
        countDown(30);
        populateHeartList(this.lives);
    }

    public LevelTwo() {
        new SpawnObstacleTask(this).run();
        isRunning = true;
        countDown(30);
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
        int secondsPassed;
        this.time.schedule(new TimerTask() {
            @Override
            public void run() {
                isRunning = false;

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
        drawHearts(canvas);
        points.draw(canvas);
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

    private void drawHearts(Canvas canvas) {
        for (Heart h :
                heartList.toArray(new Heart[0])) {
            h.draw(canvas);
        }

    }

    private void drawSecondsPassed(Canvas canvas, int second) {

    }
    @Override
    public void tapEvent(MotionEvent event) {
        player.jumpUp();
    }

    /**
     * updates every obstacle in managed in this Level2
     */
    private void updateObstacles() {
        for (Obstacle o : obstacleList.toArray(new Obstacle[0])) {
            if (removeOutOfBoundsObstacles(o)) {
                this.points.setPoints(this.points.getPoints() + 100);
            }
            o.move();

        }
    }

    private boolean removeOutOfBoundsObstacles(Obstacle o) {
        if (o.isOutOfBounds()) {
            this.obstacleList.remove(o);
            return true;
        }
        return false;
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

    @Override
    public int getLives() {
        return this.lives;
    }

    @Override
    public int getPoints(){
        return this.points.getPoints();
    }

    /**
     * Public method to add Obstacle object to Level two's obstacle list
     *
     * @param o
     */
    public void addToObstacleList(Obstacle o) {
        this.obstacleList.add(o);
    }

    public int getGroundY() {
        return groundY;
    }

    public float getDefaultObstacleMoveSpeed() {
        return defaultObstacleMoveSpeed;
    }
}
