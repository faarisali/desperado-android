package com.example.game.Login;

import java.util.Map;

abstract class LoginMapDatabase {
    public abstract void save (String username, String password);
    public abstract Map<String, ?> load ();
    public abstract String getCurrentUser();
    public abstract void setCurrentUser(String username);
    public abstract String getPass (String username);
}