package com.example.game.LevelOne;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.AbstractActivity;
import com.example.game.GameManager;
import com.example.game.GameManagerObserver;
import com.example.game.R;

public class LevelOneActivity extends AbstractActivity {

    private Paint textStyle = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level_one);
        currView = findViewById(R.id.gameView);
//        currView.setZOrderOnTop(true);    // necessary
//        SurfaceHolder holder = currView.getHolder();
//        holder.setFormat(PixelFormat.TRANSPARENT);

        setTextStyle(textStyle, Color.WHITE);

        GameManager game = currView.gameManager;
        GameManagerObserver observer = new GameManagerObserver(this);
        game.setObserver(observer);
        game.changeLevel(1);
        LevelOnePresenter presenter = new LevelOnePresenter(this, new LevelOne());
    }

    private void setTextStyle(Paint textStyle, int white) {
        textStyle.setTextSize(60);
        textStyle.setTypeface(Typeface.DEFAULT_BOLD);
        textStyle.setColor(white);
    }

    public void drawBomb(int x, int y, Canvas canvas) {
        Paint paint = new Paint();
        setTextStyle(paint, Color.GRAY);
        canvas.drawCircle(x + 25, y + 25, 25, paint);
    }

    public void drawCoin(int x, int y, Canvas canvas) {
        Paint paint = new Paint();
        setTextStyle(paint, Color.YELLOW);
        canvas.drawCircle(x + 25, y + 25, 25, paint);
    }

    public void displayText(Canvas canvas, int gold, int lives, int points, String time) {
        canvas.drawText("Coins : " + gold, 0, 50, textStyle);
        canvas.drawText("Lives : " + lives, 0, 100, textStyle);
        canvas.drawText("Points : " + points, 0, 150, textStyle);
        canvas.drawText("Time left : " + time, 0, 200, textStyle);
    }
}
