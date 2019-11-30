package com.example.game.LevelOne;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {

    private Timer timer = new Timer();
    private int seconds;

    public GameTimer(int seconds) {
        this.seconds = seconds;
        this.countDown();
    }

    private void countDown() {
        timer.scheduleAtFixedRate(getDecreaseSecondsLeftTask(this), 0, 1000);
    }

    private TimerTask getDecreaseSecondsLeftTask(final GameTimer gm) {
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                gm.decreaseSeconds(1);
            }
        };
        return timerTask;
    }

    private void decreaseSeconds(int secondsDelta) {
        this.seconds -= secondsDelta;
        if (seconds < 0) {
            seconds = 0;
        }
    }

    public int getSeconds() {
        return seconds;
    }
}