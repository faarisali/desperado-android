package com.example.game.LevelOne;

interface LevelOneView {
    void drawBackground(int screenWidth, int screenHeight);

    void drawDynamite(int x, int y);

    void drawBomb(int x, int y);

    void drawCoin(int x, int y);

    void displayText(int gold, int lives, int points, String time);

    void winGame(int points, int gold, int lives);

    void loseGame(int points, int gold);
}
