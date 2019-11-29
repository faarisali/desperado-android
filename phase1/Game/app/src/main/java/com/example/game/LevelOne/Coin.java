package com.example.game.LevelOne;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.util.ArrayList;

/** A coin in level 1*/
public class Coin extends TappableObject {
    /**
     * TODO: ask should coin class be treated as front end or backend?
     * Using coordinates in a designated coins list versus having coin object?
     * Polymorphic drawing difficulties
     *
     */

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

    @Override
    /** Draw this coin*/
    public void draw(LevelOnePresenter presenter) { // TODO: is it weird to pass in the presenter here?
        presenter.drawCoin(super.x, super.y);
    }

    public ArrayList<Integer> tapResponse(){ // TODO: ask if this should be in the model itself or is fine to be in the class
        ArrayList<Integer> response = new ArrayList<>();
        response.add(1);
        response.add(100);
        response.add(0);
        return response;
    }

}
