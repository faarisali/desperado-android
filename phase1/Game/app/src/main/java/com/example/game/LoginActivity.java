package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;
    private EditText username;
    private EditText password;
    private Button loginButton;
    private Button signupButton;

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

        presenter = new LoginPresenter(this);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        signupButton = findViewById(R.id.signup_button);

        loginButton.setOnClickListener(loginListener);
        signupButton.setOnClickListener(signupListener);
    }

    @Override
    public void displayError() {

    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainMenu.class));
        finish();
    }

    @Override
    public Context getContext() {
        return this;
    }

    public void login() {
        presenter.login(username.getText().toString(), password.getText().toString());
    }

    public void signUp() {
        presenter.signup(username.getText().toString(), password.getText().toString());
    }
}
