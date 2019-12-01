package com.example.game.LevelOne;

import com.example.game.GenericLevel;

import java.util.ArrayList;
import java.util.List;

/**
 Class containing backend and logic for level one
 */
public class LevelOne extends GenericLevel {

    /** Whether this level is paused or not*/
    private boolean isPaused;
    /** A timer that keeps the game running*/
    private GameTimer gameTimer;
    /** The tappable objects in level one*/
    private List<TappableObject> tappables = new ArrayList<>();
    /** The background of level one*/
    public LevelOneBackground background;
    /** The tappable object being removed*/
    private TappableObject tappableToRemove;
    /** The dynamite object in the level (hidden feature)*/
    private Dynamite dynamite;
    /** The bombs removed bu the dynamite*/
    private List<TappableObject> bombsRemoved = new ArrayList<>();
    /** Whether the dynamite has been used*/
    private boolean dynamiteExploded = false;

    /** Construct a new level one object
     * @param screenWidth the width of the screen
     * @param screenLength the length of the screen
     */
    public LevelOne(int screenWidth, int screenLength) {
        super(3);
        isRunning = true;
        isPaused = false;
        background = new LevelOneBackground(screenWidth, screenLength);
        dynamite = new Dynamite(400, 1700);
        tappableToRemove = null;
        gameTimer = new GameTimer(31);
    }

    /** Spawn tappables randomly in level one*/
    public void spawnTappables() {
        double randDouble = Math.random();
        randDouble = randDouble * 1080 + 1;
        int randHorizontal = (int) randDouble;
        double rand = Math.random();
        if (rand < 0.05) {
            tappables.add(new Coin(randHorizontal, 20));
        } else if (rand > 0.99) {
            tappables.add(new Bomb(randHorizontal, 20));
        }
    }

    /** Check the number of lives left*/
    public void checkLives() {
        if (getLives() <= 0) {
            isRunning = false;
            System.out.println("Out of lives");
        }
    }

    /** Draw the objects in level one
     * @param presenter the presenter where the objects are drawn
     */
    public void draw(LevelOnePresenterInterface presenter) {
        background.draw(presenter);
        for (TappableObject tappableObject : tappables) {
            tappableObject.draw(presenter);
        }

        if (tappableToRemove != null) {
            tappables.remove(tappableToRemove);
            tappableToRemove = null;
        }
        if (dynamiteExploded) {
            for (TappableObject bomb: bombsRemoved) {
                tappables.remove(bomb);
            }
        }else{
            dynamite.draw(presenter);
        }
    }

    @Override
    public void update() {
        if (!isPaused) {
            spawnTappables();
            for (int i = 0; i < tappables.size(); i++) {
                tappables.get(i).move();
            }
        }

        if (gameTimer.getSeconds() <= 0) {
            isRunning = false;
        }
    }

    @Override
    public void tapEvent(float x, float y) {
        ArrayList<TappableObject> remove = new ArrayList<>();
        if (!dynamiteExploded && dynamite.tapped(x, y)) {
            dynamite.explode(tappables, bombsRemoved);
            dynamite = null;
            dynamiteExploded = true;
        }
        for (TappableObject tappableObject : tappables) {
            if (tappableObject.tapped(x, y)) {
                remove.add(tappableObject);
                ArrayList<Integer> values = tappableObject.tapResponse();
                super.setGold(super.getGold() + values.get(0));
                super.setPoints(super.getPoints() + values.get(1));
                super.setLives(super.getLives() + values.get(2));
                checkLives();
            }
        }

        // remove single coin per tap
        if (remove.size() > 0) {
            tappableToRemove = remove.get(0);
        }
    }

    /** Getter for the time running
     * @return the time left
     */
    public String getTime() {
        return Integer.toString(gameTimer.getSeconds());
    }
    /** Setter for the time running
     * @param paused boolean that determines if level one is paused
     */
    public void setPaused(boolean paused) {
        isPaused = paused;
    }
}
