package com.example.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    public LevelPresenterInterface levelPresenter;
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

    private AbstractCanvasActivity levelActivity;

    private void init() {
        getHolder().addCallback(this);
        setFocusable(true);
    }

    public GameView(AbstractCanvasActivity levelActivity) {
        super(levelActivity);
        this.levelActivity = levelActivity;
        init();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    /**
     * What happens when new view is created?
     *  - Create new Game
     *  - Start MainThread
     **/

    /** Draw the Bitmap background*/

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        surfaceDestroyed(getHolder());
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry && thread != null) {
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
        if (MotionEvent.ACTION_DOWN == e.getAction()) {
            levelPresenter.tapEvent(e.getX(), e.getY());
        }



        return true;
    }

    public void update() {
        if (levelPresenter != null)
            levelPresenter.updateGame();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null && levelPresenter != null) {
            levelPresenter.drawGame();
        }
    }

    public void draw() {
        if (levelPresenter != null) {
            levelPresenter.drawGame();
        }
    }

    public void setLevelPresenter(LevelPresenterInterface levelPresenter) {
        this.levelPresenter = levelPresenter;
    }

    public void stop() {
        surfaceDestroyed(getHolder());
    }

    public void resume() {
        surfaceCreated(getHolder());
    }

    public AbstractCanvasActivity getLevelActivity() {
        return levelActivity;
    }
}

