package com.example.game.LevelTwo;

import com.example.game.GameObject;
import java.util.ArrayList;

public class TimerDisplay extends GameObject {

    private int second;

    public TimerDisplay(int x, int y, int second) {
        super(x, y);
        this.second = second;
    }

    public ArrayList<Integer> draw() {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(x);
        temp.add(y);
        return temp;
    }
}

