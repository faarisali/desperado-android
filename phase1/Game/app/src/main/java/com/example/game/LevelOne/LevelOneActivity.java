package com.example.game.LevelOne;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.AbstractActivity;
import com.example.game.GameManager;
import com.example.game.GameView;

public class LevelOneActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        currView = new GameView(this);
        GameManager game = currView.gameManager;
        game.changeLevel(1);
        setContentView(currView);
    }
}
