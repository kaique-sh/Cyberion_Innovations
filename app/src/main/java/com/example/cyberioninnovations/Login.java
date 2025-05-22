package com.example.cyberioninnovations;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText etLogin, etSenha;
    private Button btnEntrar, btnCriarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = findViewById(R.id.etLogin);
        etSenha = findViewById(R.id.etSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCriarConta = findViewById(R.id.btnCriarConta);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = etLogin.getText().toString().trim();
                String senha = etSenha.getText().toString().trim();

                if (login.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(Login.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Aqui vai a lógica de autenticação (API, banco etc.)
                    Toast.makeText(Login.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                    // startActivity(new Intent(LoginActivity.this, TelaPrincipalActivity.class));
                    // finish();
                }
            }
        });

        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Cadastro.class);
                startActivity(intent);
            }
        });
    }
}