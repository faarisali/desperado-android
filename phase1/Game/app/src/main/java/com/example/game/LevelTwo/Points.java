package com.example.game.LevelTwo;

import android.graphics.Canvas;

import com.example.game.GameObject;

import java.util.ArrayList;

public class Points extends GameObject {
    private int points;

    public void setPoints(int points) {
        this.points = points;
    }

    public Points(int x, int y, int size, int color, int points) {
        super(x, y, size, color);
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void draw(Canvas canvas) {
        canvas.drawText("Points: " + Integer.toString(this.points), x, y, getPaintText());
    }

    public ArrayList<Integer> draw() {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(x);
        temp.add(y);
        return temp;
    }
}
