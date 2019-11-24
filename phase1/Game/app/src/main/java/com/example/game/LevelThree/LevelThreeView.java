package com.example.game.LevelThree;

public interface LevelThreeView {

    /**
     * Creates all the buttons, image views, etc necessary for the level.
     */
    void buildGameObjects(int spriteID);

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

    /**
     * Animates the round played, moving elements cpuPosition and targeting cpuTarget.
     *
     * @param cpuTarget   the position the CPU is targeting.
     * @param cpuPosition the position the CPU is currently at.
     */
    void animateRound(int cpuTarget, int cpuPosition);

    /**
     * Sets an indicator for where the CPU targeted in the last round so user can see outcome of
     * previous round.
     *
     * @param cpuTarget where the CPU targeted.
     */
    void setPreviousComputerTarget(int cpuTarget);
}