package com.example.game;

public class LoginPresenter {
    private LoginView loginView;
    private  LoginModel loginModel;

    LoginPresenter(LoginView loginView) {
        LoginAndroidMapDatabase.setSingleton(loginView.getContext());
        LoginAndroidMapDatabase loginAndroidMapDatabase = LoginAndroidMapDatabase.getSingleton();
        
        this.loginView = loginView;
        this.loginModel = new LoginModel(this, loginAndroidMapDatabase);
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
