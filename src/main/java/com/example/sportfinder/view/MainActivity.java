package com.example.sportfinder.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sportfinder.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Spots(View view) {
        Intent intent = (new Intent(MainActivity.this, PesquisaActivity.class));
        startActivity(intent);
    }

    public void Tutorial(View view) {
        Intent intent = (new Intent(MainActivity.this, tutorialActivity.class));
        startActivity(intent);
    }

}