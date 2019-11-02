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
            currView.gameManager.isPaused = false;
        }

    }

    public void winGame(GameManager game) {
        game.updateStats();
        game.isPaused = true;
        Intent win = new Intent(this, WinActivity.class);
        win.putExtra("Points", game.getPoints());
        win.putExtra("Gold", game.getGoldCoins());
        win.putExtra("Lives", game.getCurrLives());
        win.putExtra("total lives lost", game.getTotalLivesLost());
        startActivity(win);
        finish();
    }

    public void loseGame(GameManager game) {
        game.updateStats();
        game.isPaused = true;
        Intent lose = new Intent(this, LoseActivity.class);
        lose.putExtra("Points", game.getPoints());
        lose.putExtra("Gold", game.getGoldCoins());
        lose.putExtra("Lives", 0);
        lose.putExtra("total lives lost", game.getTotalLivesLost());
        startActivity(lose);
        finish();
    }


    public void pause() {
        Intent pauseMenu = new Intent(this, PauseScreen.class);
        startActivityForResult(pauseMenu, 0);

    }


}
