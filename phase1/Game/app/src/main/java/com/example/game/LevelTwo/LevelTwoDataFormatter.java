package com.example.game.LevelTwo;

import android.graphics.Point;

import java.util.ArrayList;

/**
 * A class that manipulates renderData and formats to specified output.
 */
class LevelTwoDataFormatter {
    /**
     * The rendering data that will be formatted.
     */
    private RenderData data;

    LevelTwoDataFormatter(RenderData data) {
        this.data = data;
    }

    /**
     * Retrieve the player location from data.
     *
     * @return top left of the player location.
     */
    Point getPlayerLocation() {
        ArrayList<Integer> playerData = data.getData("player");
        if (playerData.size() != 0) {
            return new Point(playerData.get(0), playerData.get(1));
        }
        return new Point();
    }

    /**
     * Return's an integer indicating whether the player is jumping.
     *
     * @return int representing whether player is midair.
     */
    int getPlayerIsJumping() {
        ArrayList<Integer> playerData = data.getData("player");
        if (playerData.size() != 0) {
            return playerData.get(2);
        }
        return 0;
    }

    /**
     * Helper method to generate a list of points.
     * @param input a list of integers in [x1,y1,x2,y2, ..] format.
     * @return an ArrayList of points.
     */
    private ArrayList<Point> generatePoints(ArrayList<Integer> input) {
        ArrayList<Point> temp = new ArrayList<>();
        for (int i = 0; i + 1 < input.size(); i += 2) {
            Point obstacleLocation = new Point(input.get(i), input.get(i + 1));
            temp.add(obstacleLocation);
        }
        return temp;
    }

    /**
     * Retrieve the obstacle locations from data.
     *
     * @return a list top left corner points of obstacle hit-boxes.
     */
    ArrayList<Point> getObstacleLocation() {
        ArrayList<Integer> obstacleData = data.getData("obstacle");
        return generatePoints(obstacleData);

    }

    /**
     * Retrieve the lives' (visual of lives left) locations from data.
     *
     * @return a list points representing lives' locations.
     */
    ArrayList<Point> getLivesLocation() {
        ArrayList<Integer> livesData = data.getData("lives");
        return generatePoints(livesData);
    }

    /**
     * Retrieve the points locations from data.
     *
     * @return a point that represents where the points counter will be drawn.
     */
    Point getPointsLocation() {
        ArrayList<Integer> pointsData = data.getData("points");
        if (pointsData.size() != 0) {
            return new Point(pointsData.get(0), pointsData.get(1));
        }
        return new Point();
    }

    /**
     * Retrieve the font size of the points counter from data.
     * @return point size of points counter.
     */
    int getPointsSize() {
        ArrayList<Integer> pointsSize = data.getData("pointsSize");
        if (pointsSize.size() != 0) {
            return pointsSize.get(0);
        }
        return 0;
    }

    /**
     * Retrieve the number of points amounted.
     * @return a number of points earned thus far in this run.
     */
    int getPoints() {
        return data.getData("numPoints").get(0);
    }

    /**
     * Return countdown display location.
     *
     * @return point that indicates where timer display will be drawn.
     */
    Point getTimerDisplayLocation() {
        ArrayList<Integer> pointsData = data.getData("timerdisplay");
        if (pointsData.size() != 0) {
            return new Point(pointsData.get(0), pointsData.get(1));
        }
        return new Point();
    }

    /**
     * Return the size of the countdown font.
     * @return the size of the countdown font.
     */
    int getTimerDisplaySize() {
        ArrayList<Integer> pointsSize = data.getData("pointsSize");
        if (pointsSize.size() != 0) {
            return pointsSize.get(0);
        }
        return 0;
    }

    /**
     * Return the number of seconds left
     * @return the amount of seconds left to be display on countdown timer.
     */
    int getSecondsLeft() {
        return data.getData("secondsLeft").get(0);
    }

    /**
     * Return locations of the background (it can change since it scrolls as character moves).
     *
     * @return the location of the background bitmaps (and objects).
     */
    ArrayList<Point> getBackgroundLocation() {
        ArrayList<Integer> obstacleData = data.getData("backgrounddisplay");
        return generatePoints(obstacleData);
    }
}
