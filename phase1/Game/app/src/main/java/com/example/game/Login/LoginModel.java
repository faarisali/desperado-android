package com.example.game.Login;

public class LoginModel {
    private LoginPresenter presenter;
    private LoginMapDatabase loginMapDatabase;

    LoginModel(LoginPresenter presenter, LoginMapDatabase loginMapDatabase) {
        this.presenter = presenter;
        this.loginMapDatabase = loginMapDatabase;
    }
    public void login(String username, String password) {
        User nonValidatedUser = loginMapDatabase.getUser(username);
        if (nonValidatedUser == null) {
            presenter.notifyError();
        } else if (!password.equals(nonValidatedUser.getPassword())) {
            presenter.notifyError();
        } else {
            presenter.notifySuccess();
            loginMapDatabase.setCurrentUser(nonValidatedUser);
        }
    }

    public void signup(String username, String password) {
        if (username.equals("") || username.contains("$") || password.contains("$")) {
            presenter.notifyInvalidUser();
            return;
        }
        User newUser = loginMapDatabase.addDefaultUser(username, password);
        presenter.notifySuccess();
        loginMapDatabase.setCurrentUser(newUser);
    }
}
