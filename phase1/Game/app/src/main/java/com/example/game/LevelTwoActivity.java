package com.example.game;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class LevelTwoActivity extends AbstractActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        currView = new GameView(this);
        GameManager game = currView.gameManager;
        GameManagerObserver observer = new GameManagerObserver(this);
        game.setObserver(observer);
        game.changeLevel(2);
        setContentView(currView);
    }


}
