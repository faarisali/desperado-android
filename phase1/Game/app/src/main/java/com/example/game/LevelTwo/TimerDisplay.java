package com.example.game.LevelTwo;

import android.graphics.Canvas;

import com.example.game.GameObject;

import java.util.ArrayList;

public class TimerDisplay extends GameObject {

    private int second;

    public TimerDisplay(int x, int y, int textSize, int textColor, int second) {
        super(x, y, textSize, textColor);
        this.second = second;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText("Time left: " + this.second, x, y, getPaintText());
    }

    public void draw(Canvas canvas, int seconds) {
        canvas.drawText("Time left: " + seconds, x, y, getPaintText());
    }

    public ArrayList<Integer> draw() {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(x);
        temp.add(y);
        return temp;
    }
}

