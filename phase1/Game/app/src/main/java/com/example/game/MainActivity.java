package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    GameView currView;
    boolean backPress = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       requestWindowFeature(Window.FEATURE_NO_TITLE);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setContentView(R.layout.activity_main);
        currView = new GameView(this);
        setContentView(currView);

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
        currView.resume();

    }


    public void pause() {
        System.out.println("pause");
        Intent pauseMenu = new Intent(this, PauseScreen.class);
        currView.stop();
        startActivityForResult(pauseMenu, 0);

    }

}
