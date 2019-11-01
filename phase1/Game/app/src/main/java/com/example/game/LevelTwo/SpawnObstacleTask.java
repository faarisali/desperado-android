package com.example.game.LevelTwo;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SpawnObstacleTask extends TimerTask {
    private LevelTwo l2;
    private Timer timer = new Timer();

    public SpawnObstacleTask(LevelTwo l2) {
        this.l2 = l2;
    }

    @Override
    public void run() {
        int delay = (1 + new Random().nextInt(2)) * 1000;
        timer.schedule(new SpawnObstacleTask(this.l2), delay);
        Obstacle obstacle = new Obstacle(1000, this.l2.getGroundY(), this.l2.getDefaultObstacleMoveSpeed());
        this.l2.getObstacleList().add(obstacle);
    }
}