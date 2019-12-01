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

public class LevelOneActivity extends AbstractCanvasActivity implements LevelOneView{

    private Paint textStyle = new Paint();
    private final int offsetHitbox = 50;

    private Bitmap coin;
    private Bitmap bomb;
    private Bitmap background;
    private Bitmap dynamite;

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
        currView.setLevelPresenter(new LevelOnePresenter(this, new LevelOne(screenWidth, screenLength)));

        defaultBitmaps();
    }

    private void defaultBitmaps() {
        coin = BitmapFactory.decodeResource(getResources(), R.drawable.coin);
        bomb = BitmapFactory.decodeResource(getResources(), R.drawable.bomb);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.wildwesttown);
        dynamite = BitmapFactory.decodeResource(getResources(), R.drawable.dynamite);
    }

    private void setTextStyle(Paint textStyle, int white) {
        textStyle.setTextSize(60);
        textStyle.setTypeface(Typeface.DEFAULT_BOLD);
        textStyle.setColor(white);
    }

    /**
     * Draws a background that fits to a given screen width and height.
     * @param screenWidth the width of the screen to draw to.
     * @param screenHeight the height of the screen to draw to.
     */
    @Override
    public void drawBackground(int screenWidth, int screenHeight) {
        Rect source = new Rect(0, 0, screenWidth, screenHeight);
        super.getCanvas().drawBitmap(background, null, source, null);
    }

    /**
     * Draws a dynamite at a given (x,  y) coordinate.
     * @param x the x-coordinate of the dynamite.
     * @param y the y-coordinate of the dynamite.
     */
    @Override
    public void drawDynamite(int x, int y) {
        Rect source = new Rect(x - offsetHitbox, y - offsetHitbox, x + 100, y + 100);
        super.getCanvas().drawBitmap(dynamite, null, source, null);
    }

    /**
     * Draws a bomb at a given (x,  y) coordinate.
     * @param x the x-coordinate of the dynamite.
     * @param y the y-coordinate of the dynamite.
     */
    @Override
    public void drawBomb(int x, int y) {
        Rect dst = new Rect(x - offsetHitbox, y - offsetHitbox, x + 100, y + 100);
        super.getCanvas().drawBitmap(bomb, null, dst, null);
    }

    /**
     * Draws a coin at a given (x,  y) coordinate.
     * @param x the x-coordinate of the dynamite.
     * @param y the y-coordinate of the dynamite.
     */
    @Override
    public void drawCoin(int x, int y) {
        x -= offsetHitbox;
        y -= offsetHitbox;

        Rect source = new Rect(x, y, x + 200, y + 200);
        super.getCanvas().drawBitmap(coin, null, source, null);
    }

    /**
     * Displays LevelOne game statistics.
     * @param gold the number of gold collected to display.
     * @param lives the number of lives left to display.
     * @param points the number of points gained to display.
     * @param time the amount of time left to display.
     */
    @Override
    public void displayText(int gold, int lives, int points, String time) {
        super.getCanvas().drawText("Coins : " + gold, 0, 50, textStyle);
        super.getCanvas().drawText("Lives : " + lives, 0, 100, textStyle);
        super.getCanvas().drawText("Points : " + points, 0, 150, textStyle);
        super.getCanvas().drawText("Time left : " + time, 0, 200, textStyle);
    }
}
