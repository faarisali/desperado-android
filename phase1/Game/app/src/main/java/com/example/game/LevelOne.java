package com.example.game;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

public class LevelOne extends GenericLevel{

    private ArrayList<TappableObject> tappables = new ArrayList<>();

    public LevelOne () {
        super(3);
    }

    public void spawnTappables(){
        double randDouble = Math.random();
        randDouble = randDouble * 1080 + 1;
        int randHorizontal = (int) randDouble;
        System.out.println(randHorizontal);
        double rand = Math.random();
        if (rand < 0.1) {
            tappables.add(new Coin(randHorizontal, 0));
            System.out.println("Spawned a coin");
        } else if (rand > 0.95) {
            super.addGameObject(new Bomb(randHorizontal, 0));
            System.out.println("Spawned a bomb");
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    public void update() {
        spawnTappables();

    }

    @Override
    public void tapEvent(MotionEvent event) {
        for (TappableObject tappableObject : tappables) {
            if (tappableObject.isTapped(event)) {
                if (tappableObject instanceof Coin) {

                }
            }
        }
    }
}
