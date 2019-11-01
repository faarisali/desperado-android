package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PauseScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause_screen);
    }

    public void resumeActivity(View v) {
        super.onBackPressed();
    }

    public void exitToMenu(View v) {
        Intent backToMenu = new Intent(this.getBaseContext(), MainMenu.class);
        backToMenu.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(backToMenu);
    }
}
