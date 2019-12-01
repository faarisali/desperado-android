package com.example.game.LevelTwo;

import android.os.Bundle;

import com.example.game.GameView;
import com.example.game.R;

public class LevelTwoActivity extends AbstractLevelTwoView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setCurrView() {
        currView = new GameView(this);
        if (getIntent().getIntExtra("spriteID", R.drawable.cowboy_yellow) != R.drawable.clown) {
            currView.setLevelPresenter(new LevelTwoPresenter(this, new LevelTwo(3, 31), false));
        } else {
            currView.setLevelPresenter(new LevelTwoPresenter(this, new LevelTwo(3, 31, -35), false));
        }
    }


}
