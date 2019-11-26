package com.example.game.Login;

/**
 * The presenter class for this login system.
 */
public class LoginPresenter {
    // The UI that this object presents to
    private LoginView loginView;
    // The part of the login system that handles logging in and signing up
    private  LoginModel loginModel;

    /**
     * Constructsor for a login presenter
     * @param loginView the UI that this presenter presents to
     * @param loginMapDatabase The database that needs to be provided to the backend
     */
    LoginPresenter(LoginView loginView, LoginMapDatabase loginMapDatabase) {
        this.loginView = loginView;
        this.loginModel = new LoginModel(this, loginMapDatabase);
    }

    /**
     * Attempt a login using the current login model
     * @param username the username used to attempt a login with
     * @param password the password used to attempt a login with
     */
    public void login(String username, String password) {
        loginModel.login(username, password);
    }

    /**
     * Attempt to sign up an account using the current login model
     * @param username the username used to attempt a sign up with
     * @param password the password used to attempt a sign up with
     */
    public void signup(String username, String password) {
        loginModel.signup(username, password);
    }

    /**
     * Display an error in the UI
     */
    public void notifyError() {
        if (loginView != null) {
            loginView.displayError();
        }
    }

    /**
     * Display and invalid user error in the UI
     */
    public void notifyInvalidUser() {
        if (loginView != null) {
            loginView.displayInvalidUser();
        }
    }

    /**
     * Tell the UI to go to the defualt activity
     */
    public void notifySuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }
}
