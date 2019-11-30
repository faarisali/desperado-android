package com.example.game.LevelOne;

public class LevelOneBackground {
    public int backgroundWidth;
    public int backgroundLength;

    public LevelOneBackground(int screenWidth, int screenLength) {
        backgroundWidth = screenWidth;
        backgroundLength = screenLength;
    }

    public void draw(LevelOnePresenterInterface presenter) {
        presenter.drawBackground(backgroundWidth, backgroundLength);
    }
}
