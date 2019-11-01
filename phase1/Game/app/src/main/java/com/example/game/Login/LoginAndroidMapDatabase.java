package com.example.game.Login;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.game.R;

import java.util.Map;

public class LoginAndroidMapDatabase extends LoginMapDatabase {
    private SharedPreferences sharedPref;
    private final String currentUser = "$current_user$";
    private static LoginAndroidMapDatabase loginAndroidMapDatabase = null;

    static void setSingleton(Context context) {
            loginAndroidMapDatabase = new LoginAndroidMapDatabase(context);
        if (loginAndroidMapDatabase.getCurrentUser() == null) {
            loginAndroidMapDatabase.setCurrentUser("");
        }
    }

    public static LoginAndroidMapDatabase getSingleton() {
        return loginAndroidMapDatabase;
    }

    private LoginAndroidMapDatabase(Context context) {
        sharedPref = context.getSharedPreferences(String.valueOf(R.string.accounts), Context.MODE_PRIVATE);
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
