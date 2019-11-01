package com.example.game.Login;

public class LoginPresenter {
    private LoginView loginView;
    private  LoginModel loginModel;

    LoginPresenter(LoginView loginView, LoginMapDatabase loginMapDatabase) {
        this.loginView = loginView;
        this.loginModel = new LoginModel(this, loginMapDatabase);
    }

    public void login(String username, String password) {
        loginModel.login(username, password);
    }

    public void signup(String username, String password) {
        loginModel.signup(username, password);
    }

    public void notifyError() {
        if (loginView != null) {
            loginView.displayError();
        }
    }


    public void notifySuccess(String username) {
        if (loginView != null) {
            loginView.navigateToHome(username);
        }
    }
}
