package com.example.game.LevelTwo;

import com.example.game.GameObject;

import java.util.ArrayList;

public class DamageScreen extends GameObject {

    int x, y;
    int shouldDisplay = 0;

    public DamageScreen(int x, int y) {
        super(x, y);
    }

    public void buffer() {
        if (shouldDisplay >= 1) {
            shouldDisplay++;
            if (shouldDisplay == 4) {
                shouldDisplay = 0;
            }
        }
    }

    public ArrayList<Integer> draw() {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(x);
        temp.add(y);
        temp.add(shouldDisplay);
        return temp;
    }

}
