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
            loginMapDatabase.setCurrentUser(username);
        }
    }

    public void signup(String username, String password) {
        loginMapDatabase.save(username, password);
        presenter.notifySuccess(username);
        loginMapDatabase.setCurrentUser(username);
    }
}
