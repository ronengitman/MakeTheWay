package com.example.maketheway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout myLayout = findViewById(R.id.framelayout_game);
        GameView myGame = new GameView(this);
        myLayout.addView(myGame);
        SharedPreferences sp;
        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
    }
}