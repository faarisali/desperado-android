package com.example.game.LevelThree;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.example.game.AbstractActivity;
import com.example.game.LoseActivity;
import com.example.game.R;
import com.example.game.WinActivity;

import java.util.List;


public class LevelThreeActivity extends AbstractActivity implements View.OnClickListener, LevelThreeView {
    /**
     * The presenter responsible for this activity.
     */
    private LevelThreePresenter presenter;
    /**
     * The list of buttons representing the players position.
     */
    private List<ToggleButton> playerPositions;
    /**
     * The list of buttons representing the players target.
     */
    private List<ToggleButton> targetPositions;
    /**
     * The list of images representing the players lives remaining.
     */
    private List<ImageView> playerHearts;

    /**
     * The list of images representing the CPU enemy in their position.
     */
    private List<ImageView> targetViews;

    /**
     * The list of images representing the player in their position.
     */
    private List<ImageView> playerViews;

    /**
     * the gold collected in previous levels.
     */
    private int goldAccumulated;
    /**
     * the points accumulated in previous levels.
     */
    private int pointsAccumulated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent(); //get the data from sender
        int lives = intent.getIntExtra("Lives", 3);
        goldAccumulated = intent.getIntExtra("Gold", 0);
        pointsAccumulated = intent.getIntExtra("Points", 0);
        int spriteID = intent.getIntExtra("spriteID", R.drawable.cowboy_yellow);

        presenter = new LevelThreePresenter(this, new LevelThreeInteractor(new LevelThree(lives)));

        View view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.drawable.levelthreebg);
        setContentView(R.layout.activity_level_three);


        buildGameObjects(spriteID);
    }

    /**
     * Creates all the buttons, image views, etc necessary for the level.
     * @param spriteID the ID of the players selected appearence.
     */

    public void buildGameObjects(int spriteID) {
        LevelThreeButtonBuilder builder = new LevelThreeButtonBuilder(this);
        playerPositions = builder.createPositions();
        targetPositions = builder.createTargets();
        builder.buildStartButton();
        playerHearts = builder.buildLifeBar();

        targetViews = builder.buildTargetViews();
        playerViews = builder.buildPlayerViews(spriteID);
    }

    /**
     * Detects when a button was clicked and determines what to do.
     *
     * @param view the view in which the button was pressed.
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startButton:
                presenter.runRound();
                break;
            case R.id.position0:
                presenter.setPositionValue(0);
                break;
            case R.id.position1:
                presenter.setPositionValue(1);
                break;
            case R.id.position2:
                presenter.setPositionValue(2);
                break;
            case R.id.target0:
                presenter.setTargetValue(0);
                break;
            case R.id.target1:
                presenter.setTargetValue(1);
                break;
            case R.id.target2:
                presenter.setTargetValue(2);
                break;
            case R.id.bPause:
                pause();
        }
    }

    /**
     * Animates the round played, moving elements cpuPosition and targeting cpuTarget.
     *
     * @param cpuTarget   the position the CPU is targeting.
     * @param cpuPosition the position the CPU is currently at.
     */
    public void animateRound(int cpuTarget, int cpuPosition) {
        ImageView animatedPosition = targetViews.get(cpuPosition);

        ObjectAnimator moveUp = ObjectAnimator.ofFloat(animatedPosition, "translationY", -175f);
        moveUp.setDuration(500);

        ObjectAnimator stay = ObjectAnimator.ofFloat(animatedPosition, "translationY", 0);
        stay.setDuration(2000);

        ObjectAnimator moveDown = ObjectAnimator.ofFloat(animatedPosition, "translationY", 25f);
        moveDown.setDuration(500);

        AnimatorSet enemyAppear = new AnimatorSet();
        enemyAppear.playSequentially(moveUp, stay, moveDown);
        enemyAppear.start();
        setPreviousComputerTarget(cpuTarget); //Informs the player where the CPU targeted
    }

    /**
     * sets the players targeted position as selected and the un-selects the other positions.
     *
     * @param target the target position that the user wants to be at.
     */
    public void setPositionSelected(int target) {
        for (int i = 0; i < playerViews.size(); i++) {
            if (i == target) {
                playerViews.get(i).setVisibility(View.VISIBLE);
            } else {
                playerViews.get(i).setVisibility(View.INVISIBLE);
            }
        }
    }

    /**
     * sets the players desired position asn selected and un-selects the other positions.
     *
     * @param target the target the user wants to target.
     */
    public void setTargetSelected(int target) {
        for (int i = 0; i < targetPositions.size(); i++) {
            if (i == target) {
                targetPositions.get(i).setChecked(true);
                targetPositions.get(i).setBackgroundResource(R.drawable.crateselected);
            } else {
                targetPositions.get(i).setChecked(false);
                targetPositions.get(i).setBackgroundResource(R.drawable.crate);
            }
        }
    }

    /**
     * Sets an indicator for where the CPU targeted in the last round so user can see outcome of
     * previous round.
     *
     * @param cpuTarget where the CPU targeted.
     */
    public void setPreviousComputerTarget(int cpuTarget) {
        for (int i = 0; i < playerPositions.size(); i++) {
            if (i == cpuTarget) {
                playerPositions.get(i).setChecked(true);
                playerPositions.get(i).setBackgroundResource(R.drawable.crateselected);
            } else {
                playerPositions.get(i).setChecked(false);
                playerPositions.get(i).setBackgroundResource(R.drawable.crate);
            }
        }
    }

    /**
     * Sets the visible life bar of the player to the appropriate amount.
     *
     * @param newLives the new amount of lives to be displayed.
     */
    @Override
    public void setPlayerLives(int newLives) {
        for (int i = 0; i < playerHearts.size(); i++) {
            if (i >= newLives) {
                playerHearts.get(i).setVisibility(View.GONE);
            }
        }
    }

    /**
     * Sends the game to the lose screen.
     */
    public void loseGame() {
        Intent intent = new Intent(this, LoseActivity.class);
        intent.putExtra("Points", pointsAccumulated);
        intent.putExtra("Gold", goldAccumulated);
        intent.putExtra("Lives", 0);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();
    }

    /**
     * Sends the game to the win screen.
     *
     * @param playerLives the amount of lives remaining.
     */
    public void winGame(int playerLives) {
        Intent intent = new Intent(this, WinActivity.class);
        intent.putExtra("Points", pointsAccumulated);
        intent.putExtra("Gold", goldAccumulated);
        intent.putExtra("Lives", playerLives);
        intent.putExtra("total lives lost", 3 - playerLives);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        finish();

    }


}

