package com.example.game;


import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;

public class LoginModel {
    private LoginPresenter presenter;
    private final String SAVE_FILE = "save.txt";

    LoginModel(LoginPresenter presenter) {
        this.presenter = presenter;
    }
    public void login(String username, String password) {

    }

    public void signup(String username, String passsword) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(presenter.getContext().openFileOutput(SAVE_FILE, MODE_PRIVATE));
            outputStreamWriter.write(username + "$" + passsword + "\n");
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        presenter.notifySuccess(username);
    }
}
