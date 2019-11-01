package com.example.game;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class LoginAndroidMapDatabase extends LoginMapDatabase {
    private SharedPreferences sharedPref;
    private final String currentUser = "$current_user$";
    private static LoginAndroidMapDatabase loginAndroidMapDatabase;

    static void setSingleton(Context context) {
        loginAndroidMapDatabase = new LoginAndroidMapDatabase(context);
    }

    static LoginAndroidMapDatabase getSingleton() {
        return loginAndroidMapDatabase;
    }

    private LoginAndroidMapDatabase(Context context) {
        sharedPref = context.getSharedPreferences(String.valueOf(R.string.accounts), Context.MODE_PRIVATE);
        save(currentUser, "");
    }
    @Override
    public void save(String username, String password) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(username, password);
        editor.commit();
    }

    @Override
    public Map<String, ?> load() {
        return sharedPref.getAll();
    }

    @Override
    public String getCurrentUser() {
        return getPass(currentUser);
    }

    @Override
    public void setCurrentUser(String username) {
        save(currentUser, username);
    }


    @Override
    public String getPass(String username) {
        return (String) load().get(username);
    }
}
