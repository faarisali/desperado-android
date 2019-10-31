package com.example.game;

public class LevelThreePresenter {

    private LevelThreeView levelThreeView;
    private LevelThreeInteractor levelThreeInteractor;
    private LevelThree levelThree;

    LevelThreePresenter(LevelThreeView levelThreeView, LevelThreeInteractor levelThreeInteractor, LevelThree levelThree) {
        this.levelThreeView = levelThreeView;
        this.levelThreeInteractor = levelThreeInteractor;
        this.levelThree = levelThree;
    }

    void setPositionValue(int position) {
        levelThreeInteractor.setPosition(position);
    }

}
