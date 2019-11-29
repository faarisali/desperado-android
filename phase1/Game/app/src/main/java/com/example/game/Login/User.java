package com.example.game.Login;

public class User {
    // login info
    private String username;
    private String password;

    // Lifetime stats
    private int totalGold;
    private int totalLivesLost;
    private int totalPoints;

    // settings/preferences
    private int costume;
    private int music;
    private boolean darkTheme;
    private boolean isMusicPlaying;

    /**
     * Constructs a User object
     * @param username this User's username
     * @param password this User's password
     * @param totalGold this User's gold amount
     * @param totalLivesLost this User's total lives lost
     * @param totalPoints this User's total points gained
     * @param costume this User's preferred costume
     * @param darkTheme this User's preferred theme
     * @param isMusicPlaying  if this User likes to keep the music on or not
     */
    public User(String username, String password, int totalGold, int totalLivesLost, int totalPoints, int costume, boolean darkTheme, boolean isMusicPlaying) {
        this.username = username;
        this.password = password;
        this.totalGold = totalGold;
        this.totalLivesLost = totalLivesLost;
        this.totalPoints = totalPoints;
        this.costume = costume;
        this.darkTheme = darkTheme;
        this.isMusicPlaying = isMusicPlaying;
    }

    /**
     * Returns a User object based off of the given string
     * @param userInfoString the string that describes the new user object to be created
     * @return returns the new user object based off of userInfoString
     */
    public User(String userInfoString) {
        String[] userInfo = userInfoString.split("\\$");
        username = userInfo[0];
        password = userInfo[1];
        totalGold = Integer.parseInt(userInfo[2]);
        totalLivesLost = Integer.parseInt(userInfo[3]);
        totalPoints = Integer.parseInt(userInfo[4]);
        costume = Integer.parseInt(userInfo[5]);
        darkTheme = userInfo[6].equals("true");
        isMusicPlaying = userInfo[7].equals("true");
    }

    @Override
    /**
     * Returns a string based on the input User.
     * @param user the user to be converted into a string format
     * @return string that represents the User user
     */
    public String toString() {
        String username = this.getUsername();
        String password = this.getPassword();
        int totalGold = this.getTotalGold();
        int totalLivesLost = this.getTotalLivesLost();
        int totalPoints = this.getTotalPoints();
        int costume = this.getCostume();
        boolean theme = this.isDarkTheme();
        boolean musicPlaying = this.isMusicPlaying();
        return username + "$" + password + "$" + totalGold + "$" + totalLivesLost + "$" + totalPoints + "$" + costume + "$" + theme + "$" + musicPlaying;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCostume() {
        return costume;
    }

    public void setCostume(int costume) {
        this.costume = costume;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public boolean isDarkTheme() {
        return darkTheme;
    }

    public void setDarkTheme(boolean darkTheme) {
        this.darkTheme = darkTheme;
    }

    public boolean isMusicPlaying() {
        return isMusicPlaying;
    }

    public void setMusicIsPlaying(boolean musicIsPlaying) {
        this.isMusicPlaying = musicIsPlaying;
    }

    public int getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(int totalGold) {
        this.totalGold = totalGold;
    }

    public int getTotalLivesLost() {
        return totalLivesLost;
    }

    public void setTotalLivesLost(int totalLivesLost) {
        this.totalLivesLost = totalLivesLost;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
