package com.example.game;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

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
}
