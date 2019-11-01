package com.example.game;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class LoginAndroidMapDatabase implements LoginMapDatabase {
    private SharedPreferences sharedPref;

    LoginAndroidMapDatabase(Context context) {
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
    public String getPass(String username) {
        return (String) load().get(username);
    }
}
