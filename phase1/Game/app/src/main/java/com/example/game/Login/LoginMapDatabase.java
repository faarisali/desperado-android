package com.example.game.Login;

interface LoginMapDatabase {
    public  void save (String username, String password);
    public  String load (String key);
    public  User getCurrentUser();
    public  void setCurrentUser(User user);

    public void addUser(User user);
    public User getUser(String username);

    public User addDefaultUser(String username, String password);
}