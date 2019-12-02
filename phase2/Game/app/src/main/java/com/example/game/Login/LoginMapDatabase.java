package com.example.game.Login;

/**
 * Interface for a Map based database for the login system.
 */
interface LoginMapDatabase {
    /**
     * Store a key value string pair inside the database
     *
     * @param key   the key of the key value pair being stored
     * @param value the value of the key value pair being stored
     */
    void save(String key, String value);

    /**
     * Loads a value given a key from the database. If there is no value, returns null.
     *
     * @param key the key to access a value from the stored key value pairs
     * @return the value that is paired with the key key. If there is no such value, return null
     */
    String load(String key);

    /**
     * Retunr the current user that is logged in
     *
     * @return a User object that represents the current user logged in
     */
    User getCurrentUser();

    /**
     * Change the current user to user
     *
     * @param user the new current user
     */
    void setCurrentUser(User user);

    /**
     * Adds a new user to the database
     *
     * @param user the user to add to the database
     */
    void addUser(User user);

    /**
     * Return a user from the database given a username
     *
     * @param username the username for the user object being requested
     * @return the user object that has the username username from the database
     */
    User getUser(String username);

    /**
     * Add a user with no stats recorded to the database
     *
     * @param username the username of the new user
     * @param password the password of the new user
     * @return the new user with username username and password password
     */
    User addDefaultUser(String username, String password);

    /**
     * Updates the current user with the given user
     *
     * @param user the user to update the current user with
     */
    void updateCurrentUser(User user);
}