package com.example.game.LevelTwo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

import com.example.game.GenericLevel;

import java.util.ArrayList;
import java.util.Timer;


public class LevelTwo extends GenericLevel {

    private GameRuntimeTimer runtimeTimer = new GameRuntimeTimer(this);
    private ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
    private int groundY = 500;
    private float defaultObstacleMoveSpeed = 9;
    private PlayerLevelTwo player = new PlayerLevelTwo(10, groundY, 60, Color.BLUE);
    private Points points = new Points(45, 110, 50, Color.WHITE, 0);
    private TimerDisplay timerDisplay;
    private int lives;


    private ArrayList<Heart> heartList = new ArrayList<>();
    /**
     * Constructs a LevelTwo
     *
     * @param lives  the number of lives the player starts with on this level.
     */
    public LevelTwo(int lives) {
        isRunning = true;
        this.secondsLeft = 30;
        this.timerDisplay = new TimerDisplay(45, 160, 50, Color.WHITE, this.secondsLeft);
        this.lives = lives;
        runtimeTimer.countDown();
        new SpawnObstacleTask(this).run();
        populateHeartList(this.lives);
    }

    /**
     * Constructs a LevelTwo
     *
     * @param lives
     * @param secondsLeft
     */
    public LevelTwo(int lives, int secondsLeft) {
        isRunning = true;
        this.secondsLeft = secondsLeft;
        this.timerDisplay = new TimerDisplay(45, 165, 50, Color.WHITE, this.secondsLeft);
        this.lives = lives;
        new SpawnObstacleTask(this).run();
        runtimeTimer.countDown();
        populateHeartList(this.lives);
    }



    private void populateHeartList(int lives) {
        int xIncrement = 45;
        for (int i = 0; i < lives; i++) {
            heartList.add(new Heart(xIncrement, 55, 60, Color.RED));
            xIncrement += 80;
        }

    }

    /**
     * Need to draw background, character and obstacles.
     *
     * @param canvas where the img is drawn
     */
    @Override
    public void draw(Canvas canvas) {
        player.draw(canvas);
        points.draw(canvas);
        drawObstacles(canvas);
        drawHearts(canvas);
        timerDisplay.draw(canvas, this.secondsLeft);


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
            checkGameOver();
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
