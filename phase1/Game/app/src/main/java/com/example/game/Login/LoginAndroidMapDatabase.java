package com.example.game.Login;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.game.R;

/**
 * implementation of a LoginMapDatabse in android using the shared preferences mechanism
 */
public class LoginAndroidMapDatabase implements LoginMapDatabase {
    /**
     * Place to store strings
     */
    private SharedPreferences sharedPref;
    /**
     * Constant that acts a placeholder in the database to represent the current user
     */
    private final String currentUserKey = "$current_user$";
    // Singleton database object
    private static LoginAndroidMapDatabase loginAndroidMapDatabase = null;

    /**
     * Returns the database singleton
     *
     * @return the databse singleton
     */
    public static LoginAndroidMapDatabase getSingleton(Context context) {
        if (loginAndroidMapDatabase == null) {
            loginAndroidMapDatabase = new LoginAndroidMapDatabase(context);
        }
        return loginAndroidMapDatabase;
    }

    /**
     * Store the sharedPreferences location in sharedPref with the given context
     *
     * @param context tha context necessary to access sharedPreferences with
     */
    private LoginAndroidMapDatabase(Context context) {
        sharedPref = context.getSharedPreferences(String.valueOf(R.string.accounts), Context.MODE_PRIVATE);
    }

    /**
     * Store a key value string pair inside the database
     *
     * @param key   the key of the key value pair being stored
     * @param value the value of the key value pair being stored
     */
    @Override
    public void save(String key, String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Loads a value given a key from the database. If there is no value, returns null.
     *
     * @param key the key to access a value from the stored key value pairs
     * @return the value that is paired with the key key. If there is no such value, return null
     */
    @Override
    public String load(String key) {
        String result = (String) sharedPref.getAll().get(key);
        return result;
    }

    /**
     * Retunr the current user that is logged in
     *
     * @return a User object that represents the current user logged in
     */
    @Override
    public User getCurrentUser() {
        String userInfo = load(currentUserKey);
        return stringToUser(userInfo);
    }

    /**
     * Change the current user to user
     *
     * @param user the new current user
     */
    @Override
    public void setCurrentUser(User user) {
        save(currentUserKey, userToString(user));
    }

    /**
     * Adds a new user to the database
     *
     * @param user the user to add to the database
     */
    @Override
    public void addUser(User user) {
        String value = userToString(user);
        save(user.getUsername(), value);
    }

    /**
     * Return a user from the database given a username
     *
     * @param username the username for the user object being requested
     * @return the user object that has the username username from the database
     */
    @Override
    public User getUser(String username) {
        String userInfo = load(username);
        return stringToUser(userInfo);
    }

    /**
     * Add a user with no stats recorded to the database
     *
     * @param username the username of the new user
     * @param password the password of the new user
     * @return the new user with username username and password password
     */
    @Override
    public User addDefaultUser(String username, String password) {
        User newUser = new User(username, password, 0, 0, 0, R.drawable.cowboy_yellow, false, false);
        addUser(newUser);
        return newUser;
    }

    /**
     * Updates the current user with the given user
     *
     * @param user the user to update the current user with
     */
    @Override
    public void updateCurrentUser(User user) {
        if (getCurrentUser().getUsername().equals(user.getUsername())) { // if the user passed in is the current user
            addUser(user);
            setCurrentUser(user);
        }
    }

    /**
     * Returns a User object based off of the given string
     *
     * @param userInfoString the string that describes the new user object to be created
     * @return returns the new user object based off of userInfoString
     */
    public User stringToUser(String userInfoString) {
        if (userInfoString == null || userInfoString.equals("")) {
            return null;
        }

        String[] userInfo = userInfoString.split("\\$");
        if (userInfo.length < 8) {
            return null;
        }
        return new User(userInfoString);
    }

    /**
     * Returns a string based on the input User.
     *
     * @param user the user to be converted into a string format
     * @return string that represents the User user
     */
    public String userToString(User user) {
        if (user == null) {
            return "";
        }
        return user.toString();
    }
}
