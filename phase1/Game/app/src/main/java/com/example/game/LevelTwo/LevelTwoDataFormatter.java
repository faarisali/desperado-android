package com.example.game.LevelTwo;

import android.graphics.Point;

import java.util.ArrayList;

public class LevelTwoDataFormatter {

    RenderData data;

    public LevelTwoDataFormatter(RenderData data) {
        this.data = data;
    }

    public Point getPlayerLocation() {
        ArrayList<Integer> playerData = data.getData("player");
        if (playerData.size() != 0) {
            return new Point(playerData.get(0), playerData.get(1));
        }
        return new Point();
    }

    public int getPlayerIsJumping() {
        ArrayList<Integer> playerData = data.getData("player");
        if (playerData.size() != 0) {
            return playerData.get(2);
        }
        return 0;
    }

    private ArrayList<Point> generatePoints(ArrayList<Integer> input) {
        ArrayList<Point> temp = new ArrayList<>();
        for (int i = 0; i + 1 < input.size(); i += 2) {
            Point obstacleLocation = new Point(input.get(i), input.get(i + 1));
            temp.add(obstacleLocation);
        }
        return temp;
    }

    public ArrayList<Point> getObstacleLocation() {
        ArrayList<Integer> obstacleData = data.getData("obstacle");
        return generatePoints(obstacleData);

    }

    public int getObstacleSize() {
        ArrayList<Integer> obstacleData = data.getData("obstacleSize");
        if (obstacleData.size() != 0) {
            return obstacleData.get(0);
        }
        return 0;
    }

    public ArrayList<Point> getLivesLocation() {
        ArrayList<Integer> livesData = data.getData("lives");
        return generatePoints(livesData);
    }

    public int getLivesSize() {
        ArrayList<Integer> livesSize = data.getData("livesSize");
        if (livesSize.size() != 0) {
            return livesSize.get(0);
        }
        return 0;
    }

    public Point getPointsLocation() {
        ArrayList<Integer> pointsData = data.getData("points");
        if (pointsData.size() != 0) {
            return new Point(pointsData.get(0), pointsData.get(1));
        }
        return new Point();
    }

    public int getPointsSize() {
        ArrayList<Integer> pointsSize = data.getData("pointsSize");
        if (pointsSize.size() != 0) {
            return pointsSize.get(0);
        }
        return 0;
    }

    int getPoints() {
        return data.getData("numPoints").get(0);
    }

    public Point getTimerDisplayLocation() {
        ArrayList<Integer> pointsData = data.getData("timerdisplay");
        if (pointsData.size() != 0) {
            return new Point(pointsData.get(0), pointsData.get(1));
        }
        return new Point();
    }

    public int getTimerDisplaySize() {
        ArrayList<Integer> pointsSize = data.getData("pointsSize");
        if (pointsSize.size() != 0) {
            return pointsSize.get(0);
        }
        return 0;
    }

    int getSecondsLeft() {
        return data.getData("secondsLeft").get(0);
    }

    public ArrayList<Point> getBackgroundLocation() {
        ArrayList<Integer> obstacleData = data.getData("backgrounddisplay");
        return generatePoints(obstacleData);
    }
}
