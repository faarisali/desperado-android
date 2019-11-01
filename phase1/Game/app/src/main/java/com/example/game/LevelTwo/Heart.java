package com.example.game.LevelTwo;

import android.graphics.Canvas;

import com.example.game.GameObject;

public class Heart extends GameObject {

    public Heart(int x, int y, int size, int color) {
        super(x, y, size, color);

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText("<3", x, y, getPaintText());
    }
}
