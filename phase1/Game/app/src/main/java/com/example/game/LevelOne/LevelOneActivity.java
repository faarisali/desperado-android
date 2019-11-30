package com.example.game.LevelOne;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.AbstractCanvasActivity;
import com.example.game.GameView;
import com.example.game.R;

public class LevelOneActivity extends AbstractCanvasActivity {

    private Paint textStyle = new Paint();
    private Paint bombPaint = new Paint();
    private Paint coinPaint = new Paint();
    private final int offsetHitbox = 50;

    private Bitmap coin;
    private Bitmap bomb;
    private Bitmap background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        currView = new GameView(this);

        int screenWidth = currView.getScreenWidth();
        int screenLength = currView.getScreenHeight();

        setContentView(currView);

        setTextStyle(textStyle, Color.WHITE);
//        currView = findViewById(R.id.gameView);
        currView.setLevelPresenter(new LevelOnePresenter(this, new LevelOne(screenWidth, screenLength)));

        defaultBitmaps();
//        GameManager game = currView.gameManager;
//        GameManagerObserver observer = new GameManagerObserver(this);
//        game.setObserver(observer);
//        game.changeLevel(1);
    }

    private void defaultBitmaps() {
        coin = BitmapFactory.decodeResource(getResources(), R.drawable.coin);
        bomb = BitmapFactory.decodeResource(getResources(), R.drawable.bomb);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.wildwesttown);
    }

    private void setTextStyle(Paint textStyle, int white) {
        textStyle.setTextSize(60);
        textStyle.setTypeface(Typeface.DEFAULT_BOLD);
        textStyle.setColor(white);
    }

    public void drawBackground(int screenWidth, int screenHeight) {
        Rect source = new Rect(0, 0, screenWidth, screenHeight);
        super.getCanvas().drawBitmap(background, null, source, null);
    }

    public void drawBomb(int x, int y) {
//        bombPaint.setTextSize(size);

        Rect dst = new Rect(x - offsetHitbox, y - offsetHitbox, x + 100, y + 100);
        super.getCanvas().drawBitmap(bomb, null, dst, null);

//        Paint paint = new Paint();
//        setTextStyle(paint, Color.GRAY);
//        canvas.drawCircle(x + 25, y + 25, 25, paint);
    }

    public void drawCoin(int x, int y) {
//        coinPaint.setTextSize(size);
        x -= offsetHitbox;
        y -= offsetHitbox;

        Rect source = new Rect(x, y, x + 200, y + 200);
        super.getCanvas().drawBitmap(coin, null, source, null);

//        Paint paint = new Paint();
//        setTextStyle(paint, Color.YELLOW);
//        canvas.drawCircle(x + 25, y + 25, 25, paint);
    }

    public void displayText(int gold, int lives, int points, String time) {
        super.getCanvas().drawText("Coins : " + gold, 0, 50, textStyle);
        super.getCanvas().drawText("Lives : " + lives, 0, 100, textStyle);
        super.getCanvas().drawText("Points : " + points, 0, 150, textStyle);
        super.getCanvas().drawText("Time left : " + time, 0, 200, textStyle);
    }
}
