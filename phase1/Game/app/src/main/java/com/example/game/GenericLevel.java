package com.example.game;

import android.graphics.Canvas;
import android.media.Image;
import android.view.MotionEvent;

import java.util.ArrayList;

public abstract class GenericLevel {

    /**
     * This level's background image
     */
    private Image backgroundImage;
    /**
     * The objects in this level
     */
    private ArrayList<GameObject> gameObjects;
    /**
     * True iff this level is running
     */
    private boolean isRunning;


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
     * Constructs a GenericLevel
     * @param backgroundImage background image for this level.
     * @param lives the number of lives the player starts with.
     */
    public GenericLevel(Image backgroundImage, int lives) {
        this.backgroundImage = backgroundImage;
        gameObjects = new ArrayList<>();
        isRunning = false;
        lives = lives;
        gold = 0;
        points = 0;
    }

    /**
     * Draws the current level onto the canvas.
     * @param canvas the canvas on to draw this level on
     */
    public abstract void draw(Canvas canvas);

    /**
     * Updates this level.
     */
    public abstract void update();

    /**
     * registers a tap even in the level.
     * @param event the tap event registered.
     */
    public abstract void tapEvent(MotionEvent event);

    /**
     * Getter for background image.
     * @return this background image
     */
    public Image getBackgroundImage() {
        return backgroundImage;
    }

    /**
     * Sets this level's background image to backgroundImage
     * @param backgroundImage the new background image
     */
    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    /**
     * Returns gameObjects
     * @return the objects in this level
     */
    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    /**
     * Returns lives
     * @return the lives of the player
     */
    public int getLives() {
        return lives;
    }

    /**
     *
     * @param newLives the new lives value
     */
    public void setLives(int newLives) {
        lives = newLives;
    }

    /**
     * Sets the gameObjects of this level.
     * @param gameObjects the new set of objects for this level
     */
    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    /**
     * Add gameObject to this level.
     * @param gameObject to add to this level
     */
    public void addGameObject(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    /**
     * Remove gameObject from this level.
     * @param gameObject to remove from this level.
     */
    public void removeGameObject(GameObject gameObject) {
        if (gameObject != null) {
            this.gameObjects.remove(gameObject);
        }
    }
}
