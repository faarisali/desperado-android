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
import com.example.game.GameView;
import com.example.game.R;

public class LevelTwoActivity extends AbstractCanvasActivity {
    private Paint heartPaint = new Paint();
    private Paint playerPaint = new Paint();
    private Paint obstaclePaint = new Paint();
    private Paint pointPaint = new Paint();
    private Paint pausePaint = new Paint();
    private Paint timerDisplayPaint = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        currView = new GameView(this);
        currView.setLevelPresenter(new LevelTwoPresenter(this, new LevelTwo(3, 31)));
//        LevelTwo newLevel = new LevelTwo();
//        LevelTwoPresenter presenter = new LevelTwoPresenter(this, newLevel);
        setContentView(currView);

        //Setting default paint values
        defaultPaintValues();
    }

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

    void drawHeart(Point location, int size) {
        heartPaint.setTextSize(size);
        super.getCanvas().drawText("<3", location.x, location.y, heartPaint);
//        Bitmap ball = BitmapFactory.decodeResource(getResources(), R.drawable.cowboy_bandit);
//        Rect source = new Rect(0, 0, 1000, 1000);
//        canvas.drawBitmap(ball, null, source,null);
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
        super.getCanvas().drawText("O", location.x, location.y, playerPaint);
    }

    void drawObstacle(Point location, int size) {
        obstaclePaint.setTextSize(size);
//        canvas.drawText("{}", location.x, location.y, obstaclePaint);
        Bitmap cactus = BitmapFactory.decodeResource(getResources(), R.drawable.cactus_1);
        Rect source = new Rect(location.x, location.y, location.x + 250, location.y + 250);
        super.getCanvas().drawBitmap(cactus, null, source, null);
    }

    void drawBackground(Point location) {
        Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.desert_background_level2);
        Rect source = new Rect(location.x, location.y, location.x + background.getWidth(), location.y + background.getHeight());
        super.getCanvas().drawBitmap(background, null, source, null);

    }

    void drawPauseButton() {
        pausePaint.setColor(Color.WHITE);
        super.getCanvas().drawRect(1000, 30, 1070, 100, pausePaint);
        pausePaint.setColor(Color.BLACK);
        super.getCanvas().drawRect(1010, 45, 1030, 85, pausePaint);
        super.getCanvas().drawRect(1040, 45, 1060, 85, pausePaint);
    }


}
