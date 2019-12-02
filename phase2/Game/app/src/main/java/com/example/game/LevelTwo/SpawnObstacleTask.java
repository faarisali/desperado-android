package com.example.game.LevelTwo;

import android.graphics.Color;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SpawnObstacleTask extends TimerTask {
    private LevelTwo l2;
    private Timer timer = new Timer();

    /**
     * Initializes a SpawnObstacleTask object that controls obstacle spawning for a passed in level 2
     *
     * @param l2 a LevelTwo object
     */
    public SpawnObstacleTask(LevelTwo l2) {
        this.l2 = l2;
    }

    @Override
    /**
     * Overrides the run method of the TimerTask object to add obstacles at random intervals to
     * this SpawnObstacleTask's LevelTwo instance attribute.
     */
    public void run() {
        int delay = (2 + new Random().nextInt(2)) * 1000;
        timer.schedule(new SpawnObstacleTask(this.l2), delay);
        Obstacle obstacle = new Obstacle(this.l2.getCANVAS_WIDTH(), this.l2.getGroundY(), this.l2.getDefaultObstacleMoveSpeed());
        this.l2.addToObstacleList(obstacle);
    }
}
