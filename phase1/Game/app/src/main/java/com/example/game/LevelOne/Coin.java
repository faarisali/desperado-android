package com.example.game.LevelOne;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.util.ArrayList;

/** A coin in level 1*/
public class Coin extends TappableObject {

    /** The style of this coin*/
    private Paint paint;

    /** Constructor for a new coin object*/
    public Coin(int newX, int newY) {
        super(newX, newY, 50, 50);
        this.paint = new Paint();
        paint.setTextSize(60);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setColor(Color.YELLOW);
    }

    /** Draw this coin*/
    public void draw(Canvas canvas) {
        canvas.drawCircle(super.x + 25, super.y + 25, 25, paint);
    }

    public ArrayList<Integer> tapResponse(){
        ArrayList<Integer> response = new ArrayList<>();
        response.add(1);
        response.add(100);
        response.add(0);
        return response;
    }

}
