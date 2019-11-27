package com.example.game.LevelTwo;

import com.example.game.GenericLevel;

import java.util.Timer;
import java.util.TimerTask;

public class GameRuntimeTimer {

    private Timer timer = new Timer();
    private GenericLevel level;
    private int seconds;

    public GameRuntimeTimer(GenericLevel level) {
        this.level = level;
        this.seconds = seconds;
    }

    public void countDown(int seconds) {
        timer.schedule(returnTimerTask(this.level), seconds * 1000);
    }

    private TimerTask returnTimerTask(final GenericLevel level) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                level.setIsRunning(false);
            }
        };
        return timerTask;
    }
}
