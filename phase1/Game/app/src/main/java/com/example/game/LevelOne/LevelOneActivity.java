package com.example.game.LevelOne;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.game.AbstractActivity;
import com.example.game.GameManager;
import com.example.game.GameManagerObserver;
import com.example.game.R;

public class LevelOneActivity extends AbstractActivity {

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
        GameManager game = currView.gameManager;
        GameManagerObserver observer = new GameManagerObserver(this);
        game.setObserver(observer);
        game.changeLevel(1);

    }
}
