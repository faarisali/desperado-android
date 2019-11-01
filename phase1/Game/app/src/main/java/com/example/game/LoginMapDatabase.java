package com.example.game;

import java.util.Map;

interface LoginMapDatabase {
    public void save (String username, String password);
    public Map<String, ?> load ();
    public String getPass (String username);
}