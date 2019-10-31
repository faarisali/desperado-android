package com.example.game;

import java.util.Observable;
import java.util.Observer;

public class LevelThreePresenter implements Observer {

    private LevelThreeView levelThreeView; //essentially level three activity with abstraction layer
    private LevelThreeInteractor levelThreeInteractor;

    LevelThreePresenter(LevelThreeView levelThreeView, LevelThreeInteractor levelThreeInteractor) {
        this.levelThreeView = levelThreeView;
        this.levelThreeInteractor = levelThreeInteractor;
        levelThreeInteractor.addObserver(this);
    }

    void setPositionValue(int position) {
        levelThreeInteractor.setPosition(position);
    }
    void setTargetValue(int target) {
        levelThreeInteractor.setTarget(target);
    }

    void runRound() {
        levelThreeInteractor.runRound();
    }

    @Override
    public void update(Observable observable, Object o) {
        int newPlayerPosition = ((int[]) o)[0];
        int newPlayerTarget = ((int[]) o)[1];
        levelThreeView.setPositionSelected(newPlayerPosition);
        levelThreeView.setTargetSelected(newPlayerTarget);

    }
}
