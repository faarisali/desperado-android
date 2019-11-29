package com.example.game;

public class GameManagerObserver {
    AbstractActivity activity;

    public GameManagerObserver(AbstractActivity a) {
        activity = a;

    }

    public void update(GameManager game) {
        if (!game.isCurrLevelRunning() && !game.isPaused) {
            if (game.getCurrLives() == 0) {
                activity.loseGame(0, 0);
            } else {
                System.out.println(game.getCurrLives());
                activity.winGame(0, 0, 0);
            }
        } else if (game.isPaused) {
            activity.pause();
        }
    }
}
