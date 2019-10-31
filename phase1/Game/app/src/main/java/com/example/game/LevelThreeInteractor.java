package com.example.game;

import java.util.Observable;
import java.util.Observer;

public class LevelThreeInteractor extends Observable implements Observer {
    private LevelThree levelThree;

    LevelThreeInteractor(LevelThree levelThree) {
        this.levelThree = levelThree;
        levelThree.addObserver(this);
    }

    void setPosition(int position) {
        levelThree.setPlayerPosition(position);
    }

    void setTarget (int target) {
        levelThree.setPlayerTarget(target);
    }

    void runRound() {
        levelThree.runRound();
    }

    @Override
    public void update(Observable observable, Object o) {
        setChanged();
        notifyObservers(o);
    }
}
