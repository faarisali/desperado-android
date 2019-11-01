package com.example.game.LevelThree;

public interface LevelThreeView {

    /**
     * Creates all the buttons, image views, etc necessary for the level.
     */
    void buildGameObjects();

    /**
     * sets the players targeted position as selected and the un-selects the other positions.
     *
     * @param target the target position that the user wants to be at.
     */
    void setPositionSelected(int target);

    /**
     * sets the players desired position asn selected and un-selects the other positions.
     *
     * @param target the target the user wants to target.
     */
    void setTargetSelected(int target);

    /**
     * Sets the visible life bar of the player to the appropriate amount.
     *
     * @param newLives the new amount of lives to be displayed.
     */
    void setPlayerLives(int newLives);

    /**
     * Wins the game with playerLives remaining.
     *
     * @param playerLives the amount of lives remaining.
     */
    void winGame(int playerLives);

    /**
     * Loses the game.
     */
    void loseGame();


}