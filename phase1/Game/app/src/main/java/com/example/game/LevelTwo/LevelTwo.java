package com.example.game.LevelTwo;

import android.graphics.Color;
import android.graphics.Point;

import com.example.game.GenericLevel;

import java.util.ArrayList;


public class LevelTwo extends GenericLevel implements LevelTwoModelInterface {

    private GameRuntimeTimer runtimeTimer = new GameRuntimeTimer(this);
    private ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
    private ArrayList<LevelTwoBackground> backgroundList = new ArrayList<>();
    private int groundY = 500;
    private float defaultObstacleMoveSpeed = 9;
    private final int PLAYER_SIZE = 60;
    private final int HEART_SIZE = 60;
    private final int POINT_SIZE = 50;
    private final int OBSTACLE_SIZE = 90;
    private final int TIMERDISPLAY_SIZE = 50;
    private final int CANVAS_WIDTH = 1080;
    private final int BACKGROUND_BITMAP_WIDTH = 1920;
    private PlayerLevelTwo player = new PlayerLevelTwo(10, groundY, PLAYER_SIZE, Color.BLUE);
    private Points points = new Points(45, 110, POINT_SIZE, Color.WHITE, 0);
    private int lives;
    private TimerDisplay timerDisplay = new TimerDisplay(45, 160, this.secondsLeft);

    private LevelTwoBackground backgroundDisplay = new LevelTwoBackground(0, 0, 10, Color.WHITE);


    private ArrayList<Heart> heartList = new ArrayList<>();
    /**
     * Constructs a LevelTwo
     *
     * @param lives  the number of lives the player starts with on this level.
     */
    public LevelTwo(int lives) {
        isRunning = true;
        this.secondsLeft = 30;
        this.lives = lives;
        runtimeTimer.countDown();
        new SpawnObstacleTask(this).run();
        populateHeartList(this.lives);
    }

    /**
     * Constructs a LevelTwo
     *
     * @param lives
     * @param secondsLeft
     */
    public LevelTwo(int lives, int secondsLeft) {
        isRunning = true;
        this.secondsLeft = secondsLeft;
        this.lives = lives;
        new SpawnObstacleTask(this).run();
        runtimeTimer.countDown();
        populateHeartList(this.lives);
        backgroundList.add(this.backgroundDisplay);
    }

    private void returnToMain() {
    }

    private void populateHeartList(int lives) {
        int xIncrement = 45;
        for (int i = 0; i < lives; i++) {
            heartList.add(new Heart(xIncrement, 55, HEART_SIZE, Color.RED));
            xIncrement += 80;
        }

    }

    /**
     * //returns a RenderData object containing x and y data about all objects that need to drawn
     *
     * @return
     */
    public RenderData draw() {
        RenderData levelTwoData = new RenderData();
        levelTwoData.store("player", player.draw());
        levelTwoData.store("obstacle", drawObstacles());
        levelTwoData.store("lives", drawHearts());
        levelTwoData.store("points", points.draw());
        levelTwoData.store("timerdisplay", timerDisplay.draw());
        levelTwoData.store("backgrounddisplay", drawBackgrounds());

        levelTwoData.store("playerSize", PLAYER_SIZE);
        levelTwoData.store("obstacleSize", OBSTACLE_SIZE);
        levelTwoData.store("livesSize", HEART_SIZE);
        levelTwoData.store("pointsSize", POINT_SIZE);
        levelTwoData.store("timerDisplaySize", TIMERDISPLAY_SIZE);
        levelTwoData.store("numPoints", points.getPoints());
        levelTwoData.store("secondsLeft", this.secondsLeft);
        return levelTwoData;

    }


    /**
     * draws every obstacle in managed in this Level2
     *
     */
    private ArrayList<Integer> drawObstacles() {
        ArrayList<Integer> temp = new ArrayList<>();
        for (Obstacle obstacle :
                obstacleList.toArray(new Obstacle[0])) {
            Point toAdd = obstacle.draw();
            temp.add(toAdd.x);
            temp.add(toAdd.y);
        }
        return temp;

    }

    private ArrayList<Integer> drawBackgrounds() {
        ArrayList<Integer> temp = new ArrayList<>();
        for (LevelTwoBackground bd :
                backgroundList.toArray(new LevelTwoBackground[0])) {
            Point toAdd = bd.draw();
            temp.add(toAdd.x);
            temp.add(toAdd.y);
        }
        return temp;

    }

    private ArrayList<Integer> drawHearts() {
        ArrayList<Integer> temp = new ArrayList<>();
        for (Heart heart :
                heartList.toArray(new Heart[0])) {
            Point toAdd = heart.draw();
            temp.add(toAdd.x);
            temp.add(toAdd.y);
        }
        return temp;

    }

    public void tapEvent() {
        player.jumpUp();
    }

    /**
     * update movement of player (jumps), spawning of obstacles and update
     */
    @Override
    public void update() {
        checkGameOver();
        if (isRunning) {
            player.move();
            updateObstacles();
            detectCollisions();
            updateBackgrounds();
        }
    }

    private boolean needNewBackground = true;

    private void updateBackgrounds() {
        for (LevelTwoBackground background : backgroundList.toArray(new LevelTwoBackground[0])) {
            if (background.x <= -(BACKGROUND_BITMAP_WIDTH - CANVAS_WIDTH) && needNewBackground) {
                backgroundList.add(new LevelTwoBackground(CANVAS_WIDTH - 20, 0, 10, Color.WHITE));
                needNewBackground = false;
            }
            if (background.x < -(BACKGROUND_BITMAP_WIDTH - 5)) {
                backgroundList.remove(background);
                needNewBackground = true;
            }
            background.update(12);

        }
    }

    /**
     * updates every obstacle in managed in this Level2
     */
    private void updateObstacles() {
        for (Obstacle o : obstacleList.toArray(new Obstacle[0])) {
            if (removeOutOfBoundsObstacles(o) && !o.isCollided()) {
                this.points.setPoints(this.points.getPoints() + 100);
            }
            o.move();

        }
    }

    private boolean removeOutOfBoundsObstacles(Obstacle o) {
        if (o.isOutOfBounds()) {
            this.obstacleList.remove(o);
            return true;
        }
        return false;
    }

    private void updateLives() {
        this.lives--;
        heartList.remove(heartList.size() - 1);
        if (this.lives == 0) {
            isRunning = false;
        }
    }

    private void detectCollisions() {
        for (Obstacle obstacle : obstacleList) {
            if (!obstacle.isCollided() && player.y - obstacle.y > -60) {
                if (player.x - obstacle.x > -40 && player.x - obstacle.x < 40) {
                    updateLives();
                    obstacle.setCollided(true);
                }
            }
        }
    }

    @Override
    public int getLives() {
        return this.lives;
    }

    @Override
    public int getPoints(){
        return this.points.getPoints();
    }

    /**
     * Public method to add Obstacle object to Level two's obstacle list
     *
     * @param o
     */
    public void addToObstacleList(Obstacle o) {
        this.obstacleList.add(o);
    }

    public int getGroundY() {
        return groundY;
    }

    public int getobstacleSize() {
        return OBSTACLE_SIZE;
    }

    public float getDefaultObstacleMoveSpeed() {
        return defaultObstacleMoveSpeed;
    }

    /**
     * Return 0 if the model is still running.
     * Return 1 if game is won.
     * Return -1 if game is lost.
     */
    public int getState() {
        if (getLives() > 0 && isRunning()) {
            return 0;
        } else if (!isRunning() && getLives() > 0) {
            return 1;
        } else {
            return -1;
        }
    }


}
