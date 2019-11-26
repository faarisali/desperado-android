package com.example.game.LevelOne;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;

import com.example.game.GenericLevel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class LevelOne extends GenericLevel {

  private Paint textStyle = new Paint();

  private Timer time = new Timer();

  private ArrayList<TappableObject> tappables = new ArrayList<>();

  public LevelOne() {
    super(3);
    countDown(60);
    textStyle.setTextSize(60);
    textStyle.setTypeface(Typeface.DEFAULT_BOLD);
    textStyle.setColor(Color.WHITE);
    isRunning = true;
  }

    private void countDown(int seconds) {
        this.time.schedule(new TimerTask() {
            @Override
            public void run() {
              isRunning = false;
            }
        }, seconds * 1000);//5 second countdown
    }

  public void spawnTappables() {
    double randDouble = Math.random();
    randDouble = randDouble * 1080 + 1;
    int randHorizontal = (int) randDouble;
    double rand = Math.random();
    if (rand < 0.05) {
      tappables.add(new Coin(randHorizontal, 20));
    } else if (rand > 0.99) {
      tappables.add(new Bomb(randHorizontal, 20));
    }
  }

  public void textDisplay(Canvas canvas) {
    canvas.drawText("Coins : " + getGold(), 0, 50, textStyle);
    canvas.drawText("Lives : " + getLives(), 0, 100, textStyle);
    canvas.drawText("Points : " + getPoints(), 0, 150, textStyle);
    canvas.drawText("Time left : " + time.toString(), 0, 200, textStyle);
  }

  public void checkLives() {
    if (getLives() <= 0) {
      isRunning = false;
      System.out.println("Out of lives");
    }
  }

  @Override
  public void draw(Canvas canvas) {
    super.draw(canvas);
    textDisplay(canvas);
    for (TappableObject tappableObject : tappables) {
      tappableObject.draw(canvas);
    }
  }

  @Override
  public void update() {
    spawnTappables();
    for (int i = 0; i < tappables.size(); i++) {
      tappables.get(i).move();
    }
  }

  @Override
  public void tapEvent(MotionEvent event) {
    ArrayList<TappableObject> remove = new ArrayList<>();
    for (TappableObject tappableObject : tappables) {
      if (tappableObject.tapped((int) event.getX(), (int) event.getY())) {
        remove.add(tappableObject);
        ArrayList<Integer> values = tappableObject.tapResponse();
        super.setGold(super.getGold() + values.get(0));
        super.setPoints(super.getPoints() + values.get(1));
        super.setLives(super.getLives() + values.get(2));
        checkLives();
        }
      }

      // remove single coin per tap
      if (remove.size() > 0) {
        tappables.remove(remove.get(0));
    }
  }
}
