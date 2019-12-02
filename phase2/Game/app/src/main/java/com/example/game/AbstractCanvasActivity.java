package com.example.game;

import android.graphics.Canvas;

public abstract class AbstractCanvasActivity extends AbstractActivity {
    private Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
