package com.example.sportfinder.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportfinder.R;

public class tutorialActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_activity);
    }

    public void Spots(View view) {
        Intent intent = (new Intent(tutorialActivity.this, PesquisaActivity.class));
        startActivity(intent);
    }

    public void Home(View view) {
        Intent intent = (new Intent(tutorialActivity.this, MainActivity.class));
        startActivity(intent);
    }

    public void tutorial(View view) {
        Intent intent = new Intent(tutorialActivity.this, VideoActivity.class);
        startActivity(intent);

    }
}