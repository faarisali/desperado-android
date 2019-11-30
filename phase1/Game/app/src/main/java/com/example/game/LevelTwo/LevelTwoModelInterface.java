package com.example.game.LevelTwo;

public interface LevelTwoModelInterface {

    void update();

    RenderData draw();

    void tapEvent();

    int getState();

    int getLives();

    int getGold();

    int getPoints();
}
