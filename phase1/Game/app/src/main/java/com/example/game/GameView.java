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

//    /**
//     * The background of the view
//     */
//    public Bitmap background;

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
//        setWillNotDraw(false); // Allow the background to be drawn
        getHolder().addCallback(this);
        setFocusable(true);
        gameManager = new GameManager((screenHeight), (screenWidth));
    }
    /**
     * What happens when new view is created?
     *  - Create new Game
     *  - Start MainThread
     **/

    /** Draw the Bitmap background*/
//    public void onDraw(Canvas canvas) {
//        canvas.drawBitmap(background, 0, 0, null); // draw the background
//    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        // Create and scale the background
//        Bitmap newBackground = BitmapFactory.decodeResource(getResources(), R.drawable.nightdesert);
//        float scale = (float)newBackground.getHeight()/(float)getHeight();
//        int newWidth = Math.round(newBackground.getWidth()/scale);
//        int newHeight = Math.round(newBackground.getHeight()/scale);
//        background = Bitmap.createScaledBitmap(newBackground, newWidth, newHeight, true);

//        background = BitmapFactory.decodeResource(getResources(), R.drawable.nightdesert);
//        adjustOpacity(background, 100);

        Paint paintText = new Paint();
        paintText.setTextSize(36);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        charWidth = paintText.measureText("W");
        charHeight = -paintText.ascent() + paintText.descent();
        surfaceDestroyed(getHolder());
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
        System.out.println("surface created");
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
            gameManager.tapEvent(e);
        }



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

    public void stop() {
        surfaceDestroyed(getHolder());
    }

    public void resume() {
        surfaceCreated(getHolder());
        System.out.println("starting");

    }

    /** Change the opacity of a Bitmap*/
//    private Bitmap adjustOpacity(Bitmap bitmap, int opacity) {
//        Bitmap mutableBitmap = bitmap.isMutable() ? bitmap : bitmap.copy(Bitmap.Config.ARGB_8888, true);
//        Canvas canvas = new Canvas(mutableBitmap);
//        int colour = (opacity & 0xFF) << 24;
//        canvas.drawColor(colour, PorterDuff.Mode.DST_IN);
//        return mutableBitmap;
//    }


}

