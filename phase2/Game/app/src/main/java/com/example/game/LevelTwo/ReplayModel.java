package com.example.game.LevelTwo;

import java.util.ArrayList;

public class ReplayModel implements LevelTwoModelInterface {

    private int currOutput;
    private ArrayList<RenderData> dataToPlay;

    /**
     * Precondition: replayString has format:
     * * Format: renderdata0%renderdata1%renderdata2 ...., where each renderData_n has format:
     * * "Name@Key1,item1,item2...!Key2,item1 ... "
     *
     * @param replayString string that contains replay information to be displayed.
     */
    public ReplayModel(String replayString) {
        dataToPlay = retrieveReplay(replayString);
        currOutput = 0;
    }

    /**
     * Update the replay so that the next frame can be drawn.
     */
    @Override
    public void update() {
        if (currOutput + 1 < dataToPlay.size()) {
            currOutput++;
        }
    }

    /**
     * Precondition: replayString has format:
     * Format: renderdata0%renderdata1%renderdata2 ...., where each renderData_n has format:
     * "Name@Key1,item1,item2...!Key2,item1 ... "
     *
     * @param replayString the string containing replay information.
     * @return RenderData ArrayList describing replay information.
     */

    private ArrayList<RenderData> retrieveReplay(String replayString) {
        ArrayList<RenderData> dataArrayList = new ArrayList<>();

        //FormatData
        String[] renderDataEntries = replayString.split("%");
        for (String entry : renderDataEntries) {
            dataArrayList.add(RenderData.toRenderData(entry));
        }
        return dataArrayList;

    }

    /**
     * Generate the drawing information for this frame.
     *
     * @return the RenderData object that contains the replay information.
     */
    @Override
    public RenderData draw() {
        return dataToPlay.get(currOutput);
    }

    /**
     * Upon user tap, fast-forward the replay.
     */
    @Override
    public void tapEvent() {
        if (currOutput + 60 < dataToPlay.size()) {
            currOutput += 60;
        }
    }

    /**
     * Get the current state of the replay.
     * @return 0 iff ReplayModel still has replay frames to show, else return 1.
     */
    @Override
    public int getState() {
        if (currOutput + 1 < dataToPlay.size()) {
            return 0;
        }
        return 1;
    }

    /**
     * Get the number of lives left thus far in the replay.
     * @return the number of lives left at this point in the replay.
     */
    @Override
    public int getLives() {
        //returns the number of hearts
        int lastOutput = dataToPlay.size() - 1;
        return dataToPlay.get(lastOutput).getData("lives").size() % 2;
    }


    /**
     * Returns the gold earned during this replay. Always 0 since you cannot earn gold in Level 2.
     * @return always 0.
     */
    @Override
    public int getGold() {
        return 0;
    }

    /**
     * Return the points earned so far in the replay.
     * @return the number of points earned.
     */
    @Override
    public int getPoints() {
        int lastOutput = dataToPlay.size() - 1;
        return dataToPlay.get(lastOutput).getData("numPoints").get(0);
    }

}
