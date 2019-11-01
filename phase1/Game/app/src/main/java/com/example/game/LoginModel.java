package com.example.game;


import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

public class LoginModel {
    private LoginPresenter presenter;

    LoginModel(LoginPresenter presenter) {
        this.presenter = presenter;
    }
    public void login(String username, String password) {
        Context context = presenter.getContext();
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.accounts), Context.MODE_PRIVATE);
        Map<String, ?> usersToPasses = sharedPref.getAll();

        String mapPass = (String) usersToPasses.get(username);
        if (!password.equals(mapPass)) {
            presenter.notifyError();
        } else {
            presenter.notifySuccess(username);
        }

    }

    public void signup(String username, String passsword) {
        Context context = presenter.getContext();
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.accounts), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(username, passsword);
        editor.commit();
        presenter.notifySuccess(username);
    }
}
