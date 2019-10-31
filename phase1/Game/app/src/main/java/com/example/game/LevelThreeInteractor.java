package com.example.game;

public class LevelThreeInteractor {
    private LevelThree levelThree;

    LevelThreeInteractor(LevelThree levelThree) {
        this.levelThree = levelThree;
    }

    void setPosition(int position) {
        levelThree.setPlayerPosition(position);
    }

    void setTarget (int target) {
        levelThree.setPlayerTarget(target);
    }
}
