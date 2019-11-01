package com.example.game;

public class LoginModel {
    private LoginPresenter presenter;
    private LoginMapDatabase loginMapDatabase;

    LoginModel(LoginPresenter presenter, LoginMapDatabase loginMapDatabase) {
        this.presenter = presenter;
        this.loginMapDatabase = loginMapDatabase;
    }
    public void login(String username, String password) {
        if (!password.equals(loginMapDatabase.getPass(username))) {
            presenter.notifyError();
        } else {
            presenter.notifySuccess(username);
        }
    }

    public void signup(String username, String passsword) {
        loginMapDatabase.save(username, passsword);
        presenter.notifySuccess(username);
    }
}
