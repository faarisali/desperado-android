package com.example.game.LevelTwo;

import java.util.ArrayList;

public class ReplayModel implements LevelTwoModelInterface {

    private int currOutput;
    private ArrayList<RenderData> dataToPlay;

    public ReplayModel() {
        dataToPlay = retrieveReplay();
        currOutput = 0;
    }

    @Override
    public void update() {
        if (currOutput + 1 < dataToPlay.size()) {
            currOutput++;
        }
    }

    private ArrayList<RenderData> retrieveReplay() {
        ArrayList<RenderData> dataArrayList = new ArrayList<>();
        //Get data from database
        String replayString = new String();
        //FormatData
        String[] renderDataEntries = replayString.split("%");
        for (String entry : renderDataEntries) {
            dataArrayList.add(RenderData.toRenderData(entry));
        }
        return dataArrayList;

    }

    @Override
    public RenderData draw() {
        return null;
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
