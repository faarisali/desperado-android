package com.example.game.Login;

/**
 * The class that the presenter uses to interact with the database data
 */
public class LoginInteractor {
    /**
     * The presenter of this interactor
     */
    private LoginPresenter presenter;
    /**
     * The database used to access user data
     */
    private LoginMapDatabase loginMapDatabase;

    /**
     * Constructs a LoginInteractor
     *
     * @param presenter        the presenter that presents the model to the view
     * @param loginMapDatabase the database used for the login logic
     */
    LoginInteractor(LoginPresenter presenter, LoginMapDatabase loginMapDatabase) {
        this.presenter = presenter;
        this.loginMapDatabase = loginMapDatabase;
    }

    /**
     * Processes a login attempt for a give username and password
     *
     * @param username the username given for a login attempt
     * @param password the password given for a login attempt
     */
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

    /**
     * Processes a sign up attempt for a give username and password
     *
     * @param username the username given for a sign up attempt
     * @param password the password given for a sign up attempt
     */
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
