package com.example.game;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class AbstractActivity extends AppCompatActivity {
    public GameView currView;
    public boolean backPress = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!backPress) {
            pause();
        }
        backPress = false;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backPress = true;
    }

    @Override
    protected void onResume() {
        System.out.println("Resume");
        super.onResume();
        if (currView != null) {
            currView.resume();
        }

    }


    public void pause() {
        System.out.println("pause");
        Intent pauseMenu = new Intent(this, PauseScreen.class);
        if (currView != null) {
            currView.stop();
        }
        startActivityForResult(pauseMenu, 0);

    }


}
