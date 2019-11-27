package com.example.game.LevelThree;

import com.example.game.R;

import java.util.Observable;
import java.util.Observer;

public class LevelThreeInteractor extends Observable implements Observer {
    /**
     * the instance of LevelThree that this interactor interacts with.
     */
    private LevelThree levelThree;

    LevelThreeInteractor(LevelThree levelThree) {
        this.levelThree = levelThree;
        this.levelThree.addObserver(this);
    }

    /**
     * Sets the new position of the player in the level object.
     *
     * @param position the new position.
     */
    void setPosition(int position) {
        levelThree.setPlayerPosition(position);
    }

    /**
     * Sets the new target of the player in the level object.
     *
     * @param target the new target
     */
    void setTarget(int target) {
        levelThree.setPlayerTarget(target);
    }

    /**
     * Runs a new round in the level object.
     */
    void runRound() {
        levelThree.runRound();
    }

    /**
     * recognizes the button pressed and delegates to level three accordingly.
     *
     * @param buttonId the ID of the button pressed.
     */
    void recognizeEvent(int buttonId) {
        switch (buttonId) {
            case R.id.startButton:
                runRound();
                break;
            case R.id.position0:
                setPosition(0);
                break;
            case R.id.position1:
                setPosition(1);
                break;
            case R.id.position2:
                setPosition(2);
                break;
            case R.id.target0:
                setTarget(0);
                break;
            case R.id.target1:
                setTarget(1);
                break;
            case R.id.target2:
                setTarget(2);
                break;
        }
    }

    /**
     * communicates to the observers that the level has changed.
     *
     * @param observable the object this object observes. (LevelThree)
     * @param o          the observed changed info (player position, target and lives)
     */
    @Override
    public void update(Observable observable, Object o) {
        setChanged();
        notifyObservers(o);
    }
}
