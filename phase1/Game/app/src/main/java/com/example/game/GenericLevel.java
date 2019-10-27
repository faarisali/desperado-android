package com.example.game;

import android.graphics.Canvas;
import android.media.Image;

import java.util.ArrayList;

public abstract class GenericLevel {

    private Image backgroundImage;
    private ArrayList<GameObjects> gameObjects;

    public GenericLevel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public abstract void draw(Canvas canvas);
    public abstract void update();

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public ArrayList<GameObjects> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(ArrayList<GameObjects> gameObjects) {
        this.gameObjects = gameObjects;
    }
}
