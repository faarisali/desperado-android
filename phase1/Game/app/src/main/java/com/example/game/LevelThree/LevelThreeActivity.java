package com.example.game.LevelThree;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.appcompat.app.ActionBar;

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

    /**
     * The position the cpu will hide at in the next round.
     */
    private int nextCpuPosition;

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
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_level_three);
        buildGameObjects(spriteID);

        view.setId(R.id.target1); //Simulates a tap even so that the initial values (target selected = 1, player position = 1) are shown at level start
        onClick(view);
    }

    /**
     * Creates all the buttons, image views, etc necessary for the level.
     *
     * @param spriteID the ID of the players selected appearence.
     */

    public void buildGameObjects(int spriteID) {
        LevelThreeButtonBuilder builder = new LevelThreeButtonBuilder(this);
        playerPositions = builder.createPositions();
        targetPositions = builder.createTargets();
        builder.buildStartButton();
        playerHearts = builder.buildLifeBar();
        builder.buildCheatButton();
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
            case R.id.cheatButton:
                showCheatView();
                break;
            case R.id.bPause:
                pause();
                break;
            default:
                presenter.recognizeEvent(view.getId());
        }
    }

    /**
     * Makes the CPU's targets invisible so that 'cheat vision' is enabled and the player can see where the CPU hides.
     */
    void showCheatView() {
        MediaPlayer player = MediaPlayer.create(this, R.raw.screech);
        player.start();
        targetPositions.get(nextCpuPosition).getBackground().setAlpha(128);
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
     * Sets the position the CPU will take on the next round. Needed for cheat mode.
     *
     * @param position the target the user wants to target.
     */
    public void setCpuNextPosition(int position) {
        nextCpuPosition = position;
    }

    /**
     * sets the players desired position asn selected and un-selects the other positions.
     *
     * @param target the target the user wants to target.
     */
    public void setTargetSelected(int target) {
        for (int i = 0; i < targetPositions.size(); i++) {
            targetPositions.get(i).getBackground().setAlpha(255); //required to refrain from  making all the buttons translucent when pressed.
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
        super.loseGame(pointsAccumulated, goldAccumulated);
    }

    /**
     * Sends the game to the win screen.
     *
     * @param playerLives the amount of lives remaining.
     */
    public void winGame(int playerLives) {
        super.winGame(pointsAccumulated + 100 * playerLives, goldAccumulated, playerLives);
    }


}

