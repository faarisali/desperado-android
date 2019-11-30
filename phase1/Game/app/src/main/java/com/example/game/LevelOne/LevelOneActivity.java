package com.example.game.LevelOne;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.AbstractActivity;
import com.example.game.AbstractCanvasActivity;
import com.example.game.GameView;
import com.example.game.R;

public class LevelOneActivity extends AbstractCanvasActivity {

    private Paint textStyle = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        currView = new GameView(this);
        setContentView(currView);

        setTextStyle(textStyle, Color.WHITE);
        currView.setLevelPresenter(new LevelOnePresenter(this, new LevelOne()));

//        GameManager game = currView.gameManager;
//        GameManagerObserver observer = new GameManagerObserver(this);
//        game.setObserver(observer);
//        game.changeLevel(1);
    }

    private void setTextStyle(Paint textStyle, int white) {
        textStyle.setTextSize(60);
        textStyle.setTypeface(Typeface.DEFAULT_BOLD);
        textStyle.setColor(white);
    }

    public void drawBomb(int x, int y, Canvas canvas) {
        Paint paint = new Paint();
        setTextStyle(paint, Color.GRAY);
        super.getCanvas().drawCircle(x + 25, y + 25, 25, paint);
    }

    public void drawCoin(int x, int y, Canvas canvas) {
        Paint paint = new Paint();
        setTextStyle(paint, Color.YELLOW);
        super.getCanvas().drawCircle(x + 25, y + 25, 25, paint);
    }

    public void displayText(Canvas canvas, int gold, int lives, int points, String time) {
        super.getCanvas().drawText("Coins : " + gold, 0, 50, textStyle);
        super.getCanvas().drawText("Lives : " + lives, 0, 100, textStyle);
        super.getCanvas().drawText("Points : " + points, 0, 150, textStyle);
        super.getCanvas().drawText("Time left : " + time, 0, 200, textStyle);
    }
}
