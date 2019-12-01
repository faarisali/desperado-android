package com.example.game.LevelTwo;

import android.os.Bundle;

import com.example.game.GameView;
import com.example.game.Login.LoginAndroidMapDatabase;

public class LevelTwoReplayActivity extends AbstractLevelTwoView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setCurrView() {
        currView = new GameView(this);
        LoginAndroidMapDatabase db = LoginAndroidMapDatabase.getSingleton(this);
        //Retrieve database info here
        String retrievedData = db.load("$replay");
        currView.setLevelPresenter(new LevelTwoPresenter(this, new ReplayModel(retrievedData), true));
    }
}
