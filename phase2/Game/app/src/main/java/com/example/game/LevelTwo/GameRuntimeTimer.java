package com.example.game.LevelTwo;

import com.example.game.GenericLevel;

import java.util.Timer;
import java.util.TimerTask;

public class GameRuntimeTimer {

    private Timer timer = new Timer();
    private GenericLevel level;

    /**
     * Initializes a GameRuntimeTimer object.
     *
     * @param level any GenericLevel (extendable design)
     */
    public GameRuntimeTimer(GenericLevel level) {
        this.level = level;
    }

    /**
     * Performed the task returned by getDecreaseSecondsLeftTask() every second
     */
    public void countDown() {
        timer.scheduleAtFixedRate(getDecreaseSecondsLeftTask(this.level), 0, 1000);
    }

    /**
     * Removes one from secondsLeft attribute of passed in level
     *
     * @param level any GenericLevel
     * @return a TimerTask object
     */
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
