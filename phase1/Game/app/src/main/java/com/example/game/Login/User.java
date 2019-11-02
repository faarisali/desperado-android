package com.example.game.Login;

public class User {
    private String username;
    private String password;

    private int totalGold;
    private int totalLivesLost;
    private int totalPoints;

    private int costume;
    private int music;
    private int theme;
    private boolean isMusicPlaying;

    public User(String username, String password, int totalGold, int totalLivesLost, int totalPoints, int costume, int music, int theme, boolean isMusicPlaying) {
        this.username = username;
        this.password = password;
        this.totalGold = totalGold;
        this.totalLivesLost = totalLivesLost;
        this.totalPoints = totalPoints;
        this.costume = costume;
        this.music = music;
        this.theme = theme;
        this.isMusicPlaying = isMusicPlaying;
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

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
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
