package com.example.game;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    private SurfaceHolder canvasHolder;
    private GameView gameView;
    private boolean isRunning;

    public MainThread(SurfaceHolder holder, GameView view) {
        this.canvasHolder = holder;
        this.gameView = view;
    }

    public void run() {
        while (isRunning) {
            Canvas canvas = null;
            try {
                canvas = this.canvasHolder.lockCanvas();
                gameView.getLevelActivity().setCanvas(canvas);
                synchronized (canvasHolder) {
                    if (canvas != null) {
                        this.gameView.update();
                        this.gameView.draw(canvas);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        canvasHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                Thread.sleep(1000/60);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }


}
