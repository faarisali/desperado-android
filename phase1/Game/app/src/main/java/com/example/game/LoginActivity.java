package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        Toast.makeText(this, "Incorrect username or password.", Toast.LENGTH_LONG).show();
        username.setText("");
        password.setText("");
    }

    public void navigateToHome(String username) {
        Intent intent = new Intent(this, MainMenu.class);
        intent.putExtra(MainMenu.USERNAME, username);
        startActivity(intent);
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
