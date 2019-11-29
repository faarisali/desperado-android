package com.example.game;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

import java.util.ArrayList;

public abstract class GenericLevel {

    /**
     * The objects in this level
     */
    private ArrayList<GameObject> gameObjects;
    /**
     * True iff this level is running
     */
    protected boolean isRunning;

    /**
     * Number of lives left in this level
     */
    private int lives;
    /**
     * Number of gold collected in this level
     */
    private int gold;
    /**
     * Number of points collected in this level.
     */
    private int points;
    /**
     * Number of seconds left in the game.
     */
    protected int secondsLeft;

    /**
     * Constructs a GenericLevel
     *
     * @param lives the number of lives the player starts with.
     */

    public GenericLevel(int lives) {
        gameObjects = new ArrayList<>();
        isRunning = false;
        this.lives = lives;
        gold = 0;
        points = 0;
    }

    public GenericLevel() {
        gameObjects = new ArrayList<>();
        isRunning = false;
        lives = 3;
        gold = 0;
        points = 0;
    }

    /**
     * Draws the current level onto the canvas.
     *
     * @param canvas the canvas on to draw this level on
     */
    public void draw(Canvas canvas) {
        for (GameObject gameObject : gameObjects) {
            gameObject.draw(canvas);
        }
    }

    /**
     * Stops the level from running (brings to win screen) once time is up
     */
    public void checkGameOver() {
        if (this.secondsLeft == 0) {
            this.isRunning = false;
        }
    }
    /**
     * Updates this level.
     */
    public abstract void update();

    /**
     * registers a tap even in the level.
     *
     * @param event the tap event registered.
     */
    public abstract void tapEvent(MotionEvent event);

    /**
     * Returns gameObjects
     *
     * @return the objects in this level
     */
    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    /**
     * Returns lives
     *
     * @return the lives of the player
     */
    public int getLives() {
        return lives;
    }

    /**
     * @param newLives the new lives value
     */
    public void setLives(int newLives) {
        lives = newLives;
    }

    /**
     * Sets the gameObjects of this level.
     *
     * @param gameObjects the new set of objects for this level
     */
    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }


    /**
     * Add gameObject to this level.
     *
     * @param gameObject to add to this level
     */
    public void addGameObject(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    /**
     * Remove gameObject from this level.
     *
     * @param gameObject to remove from this level.
     */
    public void removeGameObject(GameObject gameObject) {
        if (gameObject != null) {
            this.gameObjects.remove(gameObject);
        }
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setIsRunning(boolean b) {
        this.isRunning = b;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void setSecondsLeft(int secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

}
