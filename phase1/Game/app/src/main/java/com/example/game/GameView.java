package com.example.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private GameManager gameManager;
    private MainThread thread;

    /**
     * The width of a character.
     */
    public static float charWidth;
    /**
     * The height of a character.
     */
    public static float charHeight;

    /**
     * Screen width.
     */
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    /**
     * Screen height.
     */
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
        gameManager = new GameManager((screenHeight), (screenWidth));
    }
    /**
     * What happens when new view is created?
     *  - Create new Game
     *  - Start MainThread
     **/
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Paint paintText = new Paint();
        paintText.setTextSize(36);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        charWidth = paintText.measureText("W");
        charHeight = -paintText.ascent() + paintText.descent();

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.
        gameManager.tapEvent(e);

        return true;
    }


    /**
     */
    public void update() {
        gameManager.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            gameManager.draw(canvas);
        }

    }


}

