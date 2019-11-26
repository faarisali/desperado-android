package com.example.game.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.game.MainMenu;
import com.example.game.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    // presenter object for this activity
    private LoginPresenter presenter;

    // refer to the activity_login xml for these UI elements
    private EditText username;
    private EditText password;
    private Button loginButton;
    private Button signupButton;

    // listeners for login and sign up
    View.OnClickListener loginListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            login();
        }
    };
    View.OnClickListener signupListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            signUp();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginAndroidMapDatabase.setSingleton(this); // opens login database file
        LoginMapDatabase db = LoginAndroidMapDatabase.getSingleton();
        // goes to the default activity if already logged in
        if (db.getCurrentUser() != null) {
            navigateToHome();
        }
        // creates the presenter layer between this activity and the login business logic
        presenter = new LoginPresenter(this, LoginAndroidMapDatabase.getSingleton());

        // stores UI elements inside variables
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        signupButton = findViewById(R.id.signup_button);

        // attaches listeners to login and sign up buttons
        loginButton.setOnClickListener(loginListener);
        signupButton.setOnClickListener(signupListener);
    }

    /**
     * Displays an error in this activity when login info is incorrect
     */
    @Override
    public void displayError() {
        Toast.makeText(this, "Incorrect username or password.", Toast.LENGTH_LONG).show();
        password.setText("");
    }

    /**
     * Displays an error in this activity when the user name is invalid upon sign up attempt
     */
    @Override
    public void displayInvalidUser() {
        Toast.makeText(this, "Username cannot be blank or contain $", Toast.LENGTH_LONG).show();
    }

    /**
     * Goes to the default page of the app if the user has logged in or is logged in
     */
    public void navigateToHome() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();
    }

    /**
     * Attempt login with username username and password password
     */
    public void login() {
        presenter.login(username.getText().toString(), password.getText().toString());
    }

    /**
     * Attempt to sign up with username username and password password
     */
    public void signUp() {
        presenter.signup(username.getText().toString(), password.getText().toString());
    }
}