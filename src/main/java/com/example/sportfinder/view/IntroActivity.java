package com.example.sportfinder.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportfinder.R;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    public void Iniciar(View view) {
        Intent intent = (new Intent(IntroActivity.this, loginActivity.class));
        startActivity(intent);
    }
}
