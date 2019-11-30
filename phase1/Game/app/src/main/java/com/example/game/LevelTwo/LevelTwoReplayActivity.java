package com.example.game.LevelTwo;

import android.os.Bundle;

import com.example.game.GameView;

public class LevelTwoReplayActivity extends AbstractLevelTwoView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setCurrView() {
        currView = new GameView(this);
        currView.setLevelPresenter(new LevelTwoPresenter(this, new ReplayModel(), true));
    }
}
