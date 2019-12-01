package com.example.game.LevelOne;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A timer that tracks how much time is remaining.
 */
public class GameTimer {

    /**
     * A java timer.
     */
    private Timer timer = new Timer();

    /**
     * Number of seconds remaining.
     * Not negative.
     */
    private int seconds;

    /**
     * Constructs a GameTimer object, that counts down starting from seconds seconds.
     *
     * @param seconds the number of seconds to count down.
     */
    public GameTimer(int seconds) {
        this.seconds = seconds;
        this.countDown();
    }

    /**
     * Starts the timer countdown sequence.
     */
    private void countDown() {
        timer.scheduleAtFixedRate(getDecreaseSecondsLeftTask(this), 0, 1000);
    }

    /**
     * Decreases the number of seconds left.
     *
     * @param gm The GameTimer object that will have its seconds decreased.
     *
     * @return TimeTask object that the java timer uses every second to decrease the GameTimer
     * seconds.
     */
    private TimerTask getDecreaseSecondsLeftTask(final GameTimer gm) {
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                gm.decreaseSeconds();
            }
        };
        return timerTask;
    }

    /**
     * Decreases this seconds integer by 1.
     */
    private void decreaseSeconds() {
        this.seconds -= 1;
        if (seconds < 0) {
            seconds = 0;
        }
    }

    /**
     * Returns the number of seconds remaining.
     * @return an integer representing the number of seconds left.
     */
    public int getSeconds() {
        return seconds;
    }
}