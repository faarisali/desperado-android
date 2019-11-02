package com.example.game.Login;

import java.util.Map;

interface LoginMapDatabase {
    public abstract void save (String username, String password);
    public abstract String load (String key);
    public abstract User getCurrentUser();
    public abstract void setCurrentUser(User user);

    public void addUser(User user);
    public User getUser(String username);
}