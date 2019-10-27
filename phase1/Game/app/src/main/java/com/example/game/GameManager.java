package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

class GameManager {
    private int gridHeight;
    private int gridWidth;
    int x, y;
    public GameManager(int height, int width) {
        gridHeight = height;
        gridWidth = width;
    }

    public void draw(Canvas canvas) {
        //TODO
//        Paint paintText = new Paint();
//        paintText.setTextSize(50);
//        paintText.setColor(Color.GREEN);
//        paintText.setTypeface(Typeface.DEFAULT_BOLD);
//        canvas.drawText("/", x, 100, paintText);

    }
    public void update() {
        //TODO
//        x += gridWidth/60;

    }
}
