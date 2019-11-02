package com.example.game.LevelTwo;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.AbstractActivity;
import com.example.game.GameManager;
import com.example.game.GameManagerObserver;
import com.example.game.GameView;

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
