package com.example.sportfinder.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sportfinder.R;
import com.example.sportfinder.data.localdatabase.Cliente;
import com.example.sportfinder.viewmodel.RegisterViewModel;

public class registerActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtUsername;
    private EditText edtPassword;
    private Button registerButton;
    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        edtNome = findViewById(R.id.et_nome);
        edtUsername = findViewById(R.id.et_username);
        edtPassword = findViewById(R.id.et_password);
        registerButton = findViewById(R.id.btn_registrar);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camposEstaoPreenchidos()) {
                    String nome = edtNome.getText().toString().trim();
                    String username = edtUsername.getText().toString().trim();
                    String password = edtPassword.getText().toString().trim();

                    registerViewModel.registerCliente(nome, username, password);

                    registerViewModel.getClienteLiveData().observe(registerActivity.this, new Observer<Cliente>() {
                        @Override
                        public void onChanged(Cliente cliente) {
                            if (cliente != null) {
                                Toast.makeText(registerActivity.this, "Cliente registrado com sucesso!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(registerActivity.this, loginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                } else {
                    Toast.makeText(registerActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean camposEstaoPreenchidos() {
        return !TextUtils.isEmpty(edtNome.getText().toString()) &&
                !TextUtils.isEmpty(edtUsername.getText().toString()) &&
                !TextUtils.isEmpty(edtPassword.getText().toString());
    }
    public void LoginHere(View view) {
        Intent intent = (new Intent(registerActivity.this, loginActivity.class));
        startActivity(intent);
    }
}