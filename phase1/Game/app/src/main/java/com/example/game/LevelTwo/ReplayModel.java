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

    @Override
    public RenderData draw() {
        return dataToPlay.get(currOutput);
    }

    @Override
    public void tapEvent() {
        if (currOutput + 60 < dataToPlay.size()) {
            currOutput += 60;
        }
    }

    @Override
    public int getState() {
        if (currOutput + 1 < dataToPlay.size()) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getLives() {
        //returns the number of hearts
        int lastOutput = dataToPlay.size() - 1;
        return dataToPlay.get(lastOutput).getData("lives").size() % 2;
    }

    @Override
    public int getGold() {
        return 0;
    }

    @Override
    public int getPoints() {
        int lastOutput = dataToPlay.size() - 1;
        return dataToPlay.get(lastOutput).getData("numPoints").get(0);
    }

}
