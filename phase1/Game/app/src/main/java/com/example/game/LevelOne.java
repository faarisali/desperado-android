package com.example.game;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

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
        if (rand < 0.05) {
            tappables.add(new Coin(randHorizontal, 20));
            System.out.println("Spawned a coin");
        } else if (rand > 0.95) {
            super.addGameObject(new Bomb(randHorizontal, 0));
            System.out.println("Spawned a bomb");
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        for (TappableObject tappableObject : tappables) {
            tappableObject.draw(canvas);
        }
    }

    @Override
    public void update() {
        spawnTappables();
        for (int i = 0; i < tappables.size(); i++) {
            tappables.get(i).move();
        }

    }

    @Override
    public void tapEvent(MotionEvent event) {
        ArrayList<TappableObject> remove = new ArrayList<>();
        for (TappableObject tappableObject : tappables) {
            if (tappableObject.tapped((int) event.getX(), (int) event.getY())) {
                remove.add(tappableObject);
                if (tappableObject instanceof Coin) {
                    super.setGold(super.getGold() + 1);
                } else if (tappableObject instanceof Bomb) {
                    super.setLives(super.getLives() - 1);
                }
            }
        }
        // remove multiple coins per tap
//        for (TappableObject tappableObject : remove) {
//            tappables.remove(tappableObject);
//        }
        // remove single coin per tap
        if (remove.size() > 0) {
            tappables.remove(remove.get(0));
        }
    }
}
