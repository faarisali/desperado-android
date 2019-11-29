package com.example.game.LevelTwo;

import com.example.game.GenericLevel;

import java.util.Timer;
import java.util.TimerTask;

public class GameRuntimeTimer {

    private Timer timer = new Timer();
    private GenericLevel level;

    public GameRuntimeTimer(GenericLevel level) {
        this.level = level;
    }

    public void countDown() {
        timer.scheduleAtFixedRate(getDecreaseSecondsLeftTask(this.level), 0, 1000);
    }

    private TimerTask getDecreaseSecondsLeftTask(final GenericLevel level) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                level.setSecondsLeft(level.getSecondsLeft() - 1);
            }
        };
        return timerTask;
    }


}
