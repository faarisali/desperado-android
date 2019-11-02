package com.example.game.Login;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.game.R;

public class LoginAndroidMapDatabase implements LoginMapDatabase {
    private SharedPreferences sharedPref;
    private final String currentUserKey = "$current_user$";
    private static LoginAndroidMapDatabase loginAndroidMapDatabase = null;

    static void setSingleton(Context context) {
        loginAndroidMapDatabase = new LoginAndroidMapDatabase(context);
    }

    public static LoginAndroidMapDatabase getSingleton() {
        return loginAndroidMapDatabase;
    }

    private LoginAndroidMapDatabase(Context context) {
        sharedPref = context.getSharedPreferences(String.valueOf(R.string.accounts), Context.MODE_PRIVATE);
    }

    @Override
    public void save(String key, String value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    @Override
    public String load(String key) {
        String result = (String) sharedPref.getAll().get(key);
        return result;
    }

    @Override
    public User getCurrentUser() {
        String userInfo = load(currentUserKey);
        return stringToUser(userInfo);
    }

    @Override
    public void setCurrentUser(User user) {
        save(currentUserKey, userToString(user));
    }

    @Override
    public void addUser(User user) {
        String key = userToString(user);
        save(user.getUsername(), key);
    }

    @Override
    public User getUser(String username) {
        String userInfo = load(username);
        return stringToUser(userInfo);
    }

    @Override
    public User addDefaultUser(String username, String password) {
        User newUser = new User(username, password, 0, 0, 0, R.drawable.cowboy_yellow, R.raw.music, 0, false);
        addUser(newUser);
        return newUser;
    }

    public User stringToUser(String userInfoString) {
        if (userInfoString == null || userInfoString.equals("")) {
            return null;
        }

        String[] userInfo = userInfoString.split("\\$");
        String usernameVal = userInfo[0];
        String password = userInfo[1];
        int totalGold = Integer.parseInt(userInfo[2]);
        int totalLivesLost = Integer.parseInt(userInfo[3]);
        int totalPoints = Integer.parseInt(userInfo[4]);
        int costume = Integer.parseInt(userInfo[5]);
        int music = Integer.parseInt(userInfo[6]);
        int theme = Integer.parseInt(userInfo[7]);
        boolean isMusicPlaying = userInfo[8].equals("true");
        return new User(usernameVal, password, totalGold, totalLivesLost, totalPoints, costume, music, theme, isMusicPlaying);
    }

    public String userToString(User user) {
        if (user == null) {
            return "";
        }
        String username = user.getUsername();
        String password = user.getPassword();
        int totalGold = user.getTotalGold();
        int totalLivesLost = user.getTotalLivesLost();
        int totalPoints = user.getTotalPoints();
        int costume = user.getCostume();
        int music = user.getMusic();
        int theme = user.getTheme();
        boolean musicPlaying = user.isMusicPlaying();
        return username + "$" + password + "$" + totalGold + "$" + totalLivesLost + "$" + totalPoints + "$" + costume + "$" + music + "$" + theme + "$" + musicPlaying;
    }
}
