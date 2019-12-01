package com.example.game.LevelTwo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.AbstractCanvasActivity;
import com.example.game.Login.LoginAndroidMapDatabase;
import com.example.game.R;

public abstract class AbstractLevelTwoView extends AbstractCanvasActivity {
    private Paint heartPaint = new Paint();
    private Paint playerPaint = new Paint();
    private Paint obstaclePaint = new Paint();
    private Paint pointPaint = new Paint();
    private Paint pausePaint = new Paint();
    private Paint timerDisplayPaint = new Paint();
    private final int vAdjustment = 600;

    private Bitmap cactus;
    private Bitmap background;
    private Bitmap hearts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setCurrView();
        setContentView(currView);


        //Setting default paint values and bitmaps
        defaultPaintValues();
        defaultBitmaps();
    }

    public abstract void setCurrView();

    private void defaultPaintValues() {
        heartPaint.setTypeface(Typeface.DEFAULT_BOLD);
        playerPaint.setTypeface(Typeface.DEFAULT_BOLD);
        obstaclePaint.setTypeface(Typeface.DEFAULT_BOLD);
        pointPaint.setTypeface(Typeface.DEFAULT_BOLD);

        heartPaint.setColor(Color.RED);
        playerPaint.setColor(Color.BLUE);
        obstaclePaint.setColor(Color.GREEN);
        pointPaint.setColor(Color.WHITE);
        timerDisplayPaint.setColor(Color.WHITE);

        pausePaint.setStrokeWidth(3);

    }

    private void defaultBitmaps() {
        cactus = BitmapFactory.decodeResource(getResources(), R.drawable.cactus_1);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.level_2_bg);
        hearts = BitmapFactory.decodeResource(getResources(), R.drawable.pixelheart);
    }

    void drawHeart(Point location, int size) {
        heartPaint.setTextSize(size);
        Rect dst = new Rect(location.x, location.y - 50, location.x + 50, location.y);
        super.getCanvas().drawBitmap(hearts, null, dst, null);
    }

    void drawPoints(Point location, int size, int numPoints) {
        pointPaint.setTextSize(size);
        super.getCanvas().drawText("Points:" + numPoints, location.x, location.y, pointPaint);
    }

    void drawTimerDisplay(Point location, int size, int secondsLeft) {
        timerDisplayPaint.setTextSize(size);
        super.getCanvas().drawText("Time Left:" + secondsLeft, location.x, location.y, timerDisplayPaint);
    }

    void drawPlayer(Point location, int size) {
        playerPaint.setTextSize(size);
        super.getCanvas().drawText("O", location.x, location.y + vAdjustment, playerPaint);
    }

    void drawObstacle(Point location, int size) {
        obstaclePaint.setTextSize(size);
//        canvas.drawText("{}", location.x, location.y, obstaclePaint);
        Rect source = new Rect(location.x, location.y - 100 + vAdjustment, location.x + 100, location.y + vAdjustment);
        super.getCanvas().drawBitmap(cactus, null, source, null);
    }

    void drawBackground(Point location) {
        Rect source = new Rect(location.x, location.y, location.x + 1920, location.y + 1200);
        super.getCanvas().drawBitmap(background, null, source, null);

    }

    void drawPauseButton() {
        pausePaint.setColor(Color.WHITE);
        super.getCanvas().drawRect(1000, 30, 1070, 100, pausePaint);
        pausePaint.setColor(Color.BLACK);
        super.getCanvas().drawRect(1010, 45, 1030, 85, pausePaint);
        super.getCanvas().drawRect(1040, 45, 1060, 85, pausePaint);
    }

    void storeReplay(String dataToStore) {
        //Store replay info here into database
        LoginAndroidMapDatabase db = LoginAndroidMapDatabase.getSingleton(this);
        db.save("$replay", dataToStore);
    }
}
