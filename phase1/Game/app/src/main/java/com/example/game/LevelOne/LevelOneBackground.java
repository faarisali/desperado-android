package com.example.game.LevelOne;

public class LevelOneBackground {
    public int backgroundWidth;
    public int backgroundLength;

    public LevelOneBackground(int screenWidth, int screenLength) {
        backgroundWidth = screenWidth;
        backgroundLength = screenLength;
    }

    public void draw(LevelOnePresenter presenter) { // TODO: is it weird to pass in the presenter here?
        presenter.drawBackground(backgroundWidth, backgroundLength);
    }
}
