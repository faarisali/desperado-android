package com.example.game;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class AbstractActivity extends AppCompatActivity {
    public GameView currView;
    public boolean backPress = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (currView != null) {
            currView.stop();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (currView != null) {
            currView.resume();
            currView.levelPresenter.unpauseGame();
        }

    }

    public void winGame(int points, int goldCoins, int lives) {
        if (currView != null) {
            Intent win = new Intent(this, WinActivity.class);
            win.putExtra("Points", points);
            win.putExtra("Gold", goldCoins);
            win.putExtra("Lives", lives);
            startActivity(win);
            finish();
        }
    }

    public void loseGame(int points, int goldCoins) {
        if (currView != null) {
            Intent lose = new Intent(this, LoseActivity.class);
            lose.putExtra("Points", points);
            lose.putExtra("Gold", goldCoins);
            lose.putExtra("Lives", 0);
            startActivity(lose);
            finish();
        }
    }


    public void pause() {
        Intent pauseMenu = new Intent(this, PauseScreen.class);
        startActivityForResult(pauseMenu, 0);

    }


}
