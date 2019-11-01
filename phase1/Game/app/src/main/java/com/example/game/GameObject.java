package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.Image;

public abstract class GameObject {
    public int x;
    public int y;
    private Image image;
    private Paint paintText = new Paint();
    private int size;
    private int color;

    public GameObject(int newX, int newY, int size, int color) {
        x = newX;
        y = newY;
        this.size = size;
        this.color = color;
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        paintText.setTextSize(this.size);
        paintText.setColor(this.color);
    }

    public GameObject(int newX, int newY) {
        x = newX;
        y = newY;
    }

    protected Paint getPaintText() {
        return paintText;
    }

    public abstract void draw(Canvas canvas);

}
