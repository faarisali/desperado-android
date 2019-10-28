package com.example.game;

import android.graphics.Canvas;
import android.view.MotionEvent;

public class LevelOne extends GenericLevel{

    public LevelOne () {
        super(3);
    }

    public void spawnTappables(){
        double randDouble = Math.random();
        randDouble = randDouble * 1080 + 1;
        int randVertical = (int) randDouble;
        System.out.println(randVertical);
        double rand = Math.random();
        if (rand < 0.5) {
            super.addGameObject(new Coin(50, randVertical));
            System.out.println("Spawned a coin");
        } else if (rand > 0.9) {
            super.addGameObject(new Bomb(randVertical, 50, 0, 0));
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

    }
}
