package com.example.game;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class LevelTwo extends GenericLevel {

    private float movementSpeed;
    private PlayerLevelTwo player = new PlayerLevelTwo();
    private ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
    private int groundY = 500;
    private float defaultObstacleMoveSpeed = 9;

    //TimerTask subclass, deals with random spawning of obstacles
    private class SpawnObstacleTask extends TimerTask {
        private LevelTwo l2;
        private Timer timer = new Timer();

        public SpawnObstacleTask(LevelTwo l2) {
            this.l2 = l2;
        }

        @Override
        public void run() {
            int delay = (1 + new Random().nextInt(2)) * 1000;
            timer.schedule(new SpawnObstacleTask(this.l2), delay);
            Obstacle obstacle = new Obstacle(1000, groundY, defaultObstacleMoveSpeed);
            this.l2.obstacleList.add(obstacle);
        }
    }

    /**
     * Constructs a GenericLevel
     *
     * @param backgroundImage background image for this level.
     * @param lives           the number of lives the player starts with on this level.
     */
    public LevelTwo(Drawable backgroundImage, int lives) {
        new SpawnObstacleTask(this).run();
    }

    public LevelTwo() {
        new SpawnObstacleTask(this).run();
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
     * @param canvas
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
        player.move();
        updateObstacles();
    }


}
