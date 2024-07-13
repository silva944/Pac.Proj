package com.example.sportfinder.view;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.sportfinder.R;

import com.example.sportfinder.viewmodel.LoginViewModel;


public class loginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        usernameEditText = findViewById(R.id.et_username);
        passwordEditText = findViewById(R.id.et_password);
        loginButton = findViewById(R.id.btn_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (!username.isEmpty() && !password.isEmpty()) {

                    loginViewModel.login(username, password);

                    loginViewModel.getLoginSuccess().observe(loginActivity.this, new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean loginSuccess) {
                            if (loginSuccess) {
                                Intent intent = new Intent(loginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {

                                Toast.makeText(loginActivity.this, "Username ou Password incorretos", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(loginActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Search(View view) {
        Intent intent = (new Intent(loginActivity.this, PesquisaActivity.class));
        startActivity(intent);
    }

    public void Home(View view) {
        Intent intent = (new Intent(loginActivity.this, MainActivity.class));
        startActivity(intent);
    }

    public void Tutorial(View view) {
        Intent intent = (new Intent(loginActivity.this, tutorialActivity.class));
        startActivity(intent);
    }

    public void RegisterHere(View view) {
        Intent intent = new Intent(loginActivity.this, registerActivity.class);
        startActivity(intent);
    }
}
