package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelThreeActivity extends AppCompatActivity implements View.OnClickListener, LevelThreeView {
    private LevelThreePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three);

        presenter = new LevelThreePresenter(this, new LevelThreeInteractor());

        buildGameButtons();
    }

    private void buildGameButtons() {
        Button pos0 = (Button)findViewById(R.id.position0);
        pos0.setOnClickListener(this);

        Button pos1 = (Button)findViewById(R.id.position1);
        pos0.setOnClickListener(this);

        Button pos2 = (Button)findViewById(R.id.position2);
        pos0.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.position0:
                presenter.setPositionValues(1,0,0);
                break;
        }
    }
}
