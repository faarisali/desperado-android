package com.example.game.Login;

/**
 * Interface for a Map based database for the login system.
 */
interface LoginMapDatabase {
    public  void save (String key, String value); // Save a string key pair value
    public  String load (String key); // Load a value from the database given a key
    public  User getCurrentUser(); // return  the currently logged in user
    public  void setCurrentUser(User user); // store the current user

    public void addUser(User user); // add a user account to the database
    public User getUser(String username); //return a user given a username from the database

    public User addDefaultUser(String username, String password); // add a default user to the database

    void updateCurrentUser(User user);
}