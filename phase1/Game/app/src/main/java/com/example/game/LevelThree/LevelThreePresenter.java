package com.example.game.LevelThree;

import java.util.Observable;
import java.util.Observer;

public class LevelThreePresenter implements Observer {

    private LevelThreeView levelThreeView; //essentially level three activity with abstraction layer
    private LevelThreeInteractor levelThreeInteractor;

    LevelThreePresenter(LevelThreeView levelThreeView, LevelThreeInteractor levelThreeInteractor) {
        this.levelThreeView = levelThreeView;
        this.levelThreeInteractor = levelThreeInteractor;
        this.levelThreeInteractor.addObserver(this);
    }

    /**
     * Tells the interactor that the user has selected a new position.
     *
     * @param position the new position.
     */
    void setPositionValue(int position) {
        levelThreeInteractor.setPosition(position);
    }

    /**
     * Tells the interactor that the user has selected a new target.
     *
     * @param target the new target.
     */
    void setTargetValue(int target) {
        levelThreeInteractor.setTarget(target);
    }

    /**
     * Tells the interactor that the user wants to run a round.
     */
    void runRound() {
        levelThreeInteractor.runRound();
    }

    /**
     * Observes when the interactor has new information and updates the view accordingly.
     *
     * @param observable the item this object observes (LevelThreeInteractor)
     * @param o          the new data (player position, target, and lives)
     */
    @Override
    public void update(Observable observable, Object o) {
        int newPlayerPosition = (int)(((Object[]) o)[0]); //TODO: get rid of nasty casting
        int newPlayerTarget = (int)(((Object[]) o)[1]);
        int newPlayerLives = (int)(((Object[]) o)[2]);

        int cpuTarget = (int)(((Object[]) o)[3]);
        int cpuPosition = (int)(((Object[]) o)[4]);

        boolean gameFinished = (boolean)(((Object[]) o)[5]);
        boolean animate = (boolean)(((Object[]) o)[5]);

        if (animate) {
            levelThreeView.animateRound(cpuTarget, cpuPosition);
        }

        if (gameFinished) {
            if (newPlayerLives == 0) {
                levelThreeView.loseGame();
            } else {
                levelThreeView.winGame(newPlayerLives);
            }
        } else {
            levelThreeView.setPositionSelected(newPlayerPosition);
            levelThreeView.setTargetSelected(newPlayerTarget);
            levelThreeView.setPlayerLives(newPlayerLives);
        }
    }
}
