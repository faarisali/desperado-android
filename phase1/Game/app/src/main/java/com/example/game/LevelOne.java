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
        int randHorizontal = (int) randDouble;
        System.out.println(randHorizontal);
        double rand = Math.random();
        if (rand < 0.5) {
            super.addGameObject(new Coin(randHorizontal, 0));
            System.out.println("Spawned a coin");
        } else if (rand > 0.9) {
            super.addGameObject(new Bomb(randHorizontal, 50, 0, 0));
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
