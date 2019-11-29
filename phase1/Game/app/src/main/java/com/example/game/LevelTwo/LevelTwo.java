package com.example.game.LevelTwo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.view.MotionEvent;

import com.example.game.GenericLevel;

import java.util.ArrayList;
import java.util.Timer;

public class LevelTwo extends GenericLevel {

    private GameRuntimeTimer runtimeTimer = new GameRuntimeTimer(this);
    private ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
    private int groundY = 500;
    private float defaultObstacleMoveSpeed = 9;
    private final int PLAYER_SIZE = 60;
    private final int HEART_SIZE = 60;
    private final int POINT_SIZE = 50;
    private final int OBSTACLE_SIZE = 90;
    private final int TIMERDISPLAY_SIZE = 50;
    private PlayerLevelTwo player = new PlayerLevelTwo(10, groundY, PLAYER_SIZE, Color.BLUE);
    private Points points = new Points(45, 110, POINT_SIZE, Color.WHITE, 0);
    private int lives = 3;
    private TimerDisplay timerDisplay = new TimerDisplay(45, 160, 50, Color.WHITE, this.secondsLeft);


    private ArrayList<Heart> heartList = new ArrayList<>();
    /**
     * Constructs a LevelTwo
     *
     * @param lives  the number of lives the player starts with on this level.
     */
    public LevelTwo(int lives) {
        isRunning = true;
        this.secondsLeft = 30;
        this.lives = lives;
        runtimeTimer.countDown();
        new SpawnObstacleTask(this).run();
        runtimeTimer.countDown();
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
        this.lives = lives;
        new SpawnObstacleTask(this).run();
        runtimeTimer.countDown();
        populateHeartList(this.lives);
    }

    private void returnToMain() {
    }

    private void populateHeartList(int lives) {
        int xIncrement = 45;
        for (int i = 0; i < lives; i++) {
            heartList.add(new Heart(xIncrement, 55, HEART_SIZE, Color.RED));
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
//        player.draw(canvas);
//        points.draw(canvas);
//        drawObstacles(canvas);
//        drawHearts(canvas);
//        timerDisplay.draw(canvas, this.secondsLeft);


    }


    public RenderData draw() {
        RenderData levelTwoData = new RenderData();
        levelTwoData.store("player", player.draw());
        levelTwoData.store("obstacle", drawObstacles());
        levelTwoData.store("lives", drawHearts());
        levelTwoData.store("points", points.draw());
        levelTwoData.store("timerdisplay", timerDisplay.draw());
        levelTwoData.store("playerSize", PLAYER_SIZE);
        levelTwoData.store("obstacleSize", OBSTACLE_SIZE);
        levelTwoData.store("livesSize", HEART_SIZE);
        levelTwoData.store("pointsSize", POINT_SIZE);
        levelTwoData.store("timerDisplaySize", TIMERDISPLAY_SIZE);
        levelTwoData.store("numPoints", points.getPoints());
        levelTwoData.store("secondsLeft", this.secondsLeft);
        return levelTwoData;

    }


    /**
     * draws every obstacle in managed in this Level2
     *
     */
    private ArrayList<Integer> drawObstacles() {
        ArrayList<Integer> temp = new ArrayList<>();
        for (Obstacle obstacle :
                obstacleList.toArray(new Obstacle[0])) {
            Point toAdd = obstacle.draw();
            temp.add(toAdd.x);
            temp.add(toAdd.y);
        }
        return temp;

    }

    private ArrayList<Integer> drawHearts() {
        ArrayList<Integer> temp = new ArrayList<>();
        for (Heart heart :
                heartList.toArray(new Heart[0])) {
            Point toAdd = heart.draw();
            temp.add(toAdd.x);
            temp.add(toAdd.y);
        }
        return temp;

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
        checkGameOver();
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
            if (!item.isCollided() && player.y - item.y > -60) {
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

    public int getobstacleSize() {
        return OBSTACLE_SIZE;
    }

    public float getDefaultObstacleMoveSpeed() {
        return defaultObstacleMoveSpeed;
    }


}
