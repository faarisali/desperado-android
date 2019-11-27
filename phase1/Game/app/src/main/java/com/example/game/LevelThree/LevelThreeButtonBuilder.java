package com.example.game.LevelThree;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.example.game.R;

import java.util.Arrays;
import java.util.List;

class LevelThreeButtonBuilder {
    private LevelThreeActivity view;

    LevelThreeButtonBuilder(LevelThreeActivity view) {
        this.view = view;
    }

    /**
     * Creates the buttons representing the positions.
     *
     * @return list of position buttons.
     */
    List<ToggleButton> createPositions() {
        ToggleButton pos0 = view.findViewById(R.id.position0);
        pos0.setOnClickListener(view);
        pos0.setBackgroundResource(R.drawable.crate);

        ToggleButton pos1 = view.findViewById(R.id.position1);
        pos1.setOnClickListener(view);
        pos1.setBackgroundResource(R.drawable.crate);

        ToggleButton pos2 = view.findViewById(R.id.position2);
        pos2.setOnClickListener(view);
        pos2.setBackgroundResource(R.drawable.crate);

        return Arrays.asList(pos0, pos1, pos2);
    }

    /**
     * Creates the buttons representing the targets.
     *
     * @return list of target buttons.
     */
    List<ToggleButton> createTargets() {
        ToggleButton tar0 = view.findViewById(R.id.target0);
        tar0.setOnClickListener(view);
        tar0.setBackgroundResource(R.drawable.crate);

        ToggleButton tar1 = view.findViewById(R.id.target1);
        tar1.setOnClickListener(view);
        tar1.setBackgroundResource(R.drawable.crate);

        ToggleButton tar2 = view.findViewById(R.id.target2);
        tar2.setOnClickListener(view);
        tar2.setBackgroundResource(R.drawable.crate);
        return Arrays.asList(tar0, tar1, tar2);
    }

    /**
     * builds the button to start a round.
     */
    void buildStartButton() {
        Button start = view.findViewById(R.id.startButton);
        start.setOnClickListener(view);
    }

    /**
     * builds the button to enable cheats.
     */
    void buildCheatButton() {
        Button cheatButton = view.findViewById(R.id.cheatButton);
        cheatButton.setOnClickListener(view);
    }

    /**
     * Builds the images representing the life bar.
     *
     * @return list of life bar images.
     */
    List<ImageView> buildLifeBar() {
        ImageView heart1 = view.findViewById(R.id.heart1);
        ImageView heart2 = view.findViewById(R.id.heart2);
        ImageView heart3 = view.findViewById(R.id.heart3);
        return Arrays.asList(heart1, heart2, heart3);
    }

    /**
     * Builds the images representing the CPU enemy picture.
     *
     * @return list of enemy images.
     */
    List<ImageView> buildTargetViews() {
        ImageView targetPic0 = view.findViewById(R.id.enemyView0);
        ImageView targetPic1 = view.findViewById(R.id.enemyView1);
        ImageView targetPic2 = view.findViewById(R.id.enemyView2);
        return Arrays.asList(targetPic0, targetPic1, targetPic2);
    }

    /**
     * Builds the images representing the player picture.
     *
     * @return list of enemy images.
     */
    List<ImageView> buildPlayerViews(int spriteID) {
        ImageView targetPic0 = view.findViewById(R.id.playerView0);
        targetPic0.setVisibility(View.INVISIBLE);
        targetPic0.setBackgroundResource(spriteID);

        ImageView targetPic1 = view.findViewById(R.id.playerView1);
        targetPic1.setVisibility(View.VISIBLE);
        targetPic1.setBackgroundResource(spriteID);

        ImageView targetPic2 = view.findViewById(R.id.playerView2);
        targetPic2.setVisibility(View.INVISIBLE);
        targetPic2.setBackgroundResource(spriteID);

        return Arrays.asList(targetPic0, targetPic1, targetPic2);
    }
}
