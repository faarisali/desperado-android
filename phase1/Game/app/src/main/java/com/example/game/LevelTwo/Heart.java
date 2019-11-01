package com.example.game.LevelTwo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.example.game.GameObject;

public class Heart extends GameObject {

    public Heart(int x, int y) {
        super(x, y);

    }

    @Override
    public void draw(Canvas canvas) {
        Paint paintText = new Paint();
        paintText.setTextSize(60);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        paintText.setColor(Color.RED);

        canvas.drawText("<3", x, y, paintText);
    }
}
