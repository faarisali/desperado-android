package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class Heart extends GameObject {

    public Heart(int x, int y, int size, int color) {
        super(x, y, size, color);

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText("<3", x, y, getPaintText());
    }
}
