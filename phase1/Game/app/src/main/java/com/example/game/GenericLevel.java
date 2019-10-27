package com.example.game;

import android.graphics.Canvas;
import android.media.Image;

import java.util.ArrayList;

public abstract class GenericLevel {
    private Image backgroundImage;
    private ArrayList<GameObjects> gameObjects;

    public abstract void draw(Canvas canvas);

    public abstract void update();


}
