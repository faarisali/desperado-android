package com.example.game.LevelTwo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.AbstractActivity;
import com.example.game.GameView;

public class LevelTwoActivity extends AbstractActivity {
    private Paint heartPaint = new Paint();
    private Paint playerPaint = new Paint();
    private Paint obstaclePaint = new Paint();
    private Paint pointPaint = new Paint();
    private Paint pausePaint = new Paint();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        currView = new GameView(this);
        currView.setLevelPresenter(new LevelTwoPresenter(this, new LevelTwo()));

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

        pausePaint.setStrokeWidth(3);

    }

    void drawHeart(Canvas canvas, Point location, int size) {
        heartPaint.setTextSize(size);
        canvas.drawText("<3", location.x, location.y, heartPaint);

    }

    void drawPoints(Canvas canvas, Point location, int size, int numPoints) {
        pointPaint.setTextSize(size);
        canvas.drawText("Points:" + numPoints, location.x, location.y, pointPaint);
    }

    void drawPlayer(Canvas canvas, Point location, int size) {
        playerPaint.setTextSize(size);
        canvas.drawText("O", location.x, location.y, playerPaint);
    }

    void drawObstacle(Canvas canvas, Point location, int size) {
        obstaclePaint.setTextSize(size);
        canvas.drawText("{}", location.x, location.y, obstaclePaint);
    }

    void drawPauseButton(Canvas canvas) {
        pausePaint.setColor(Color.WHITE);
        canvas.drawRect(1000, 30, 1070, 100, pausePaint);
        pausePaint.setColor(Color.BLACK);
        canvas.drawRect(1010, 45, 1030, 85, pausePaint);
        canvas.drawRect(1040, 45, 1060, 85, pausePaint);
    }


}
