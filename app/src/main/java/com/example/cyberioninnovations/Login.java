package com.example.cyberioninnovations;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText etLogin, etSenha;
    private Button btnEntrar, btnCriarConta;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        setupListeners();

        dbHelper = new DBHelper(this); // Inicializa o banco
    }

    private void initViews() {
        etLogin = findViewById(R.id.etLogin);
        etSenha = findViewById(R.id.etSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCriarConta = findViewById(R.id.btnCriarConta);
    }

    private void setupListeners() {
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleLogin();
            }
        });

        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Cadastro.class));
            }
        });
    }

    private void handleLogin() {
        String login = etLogin.getText().toString().trim();
        String senha = etSenha.getText().toString();

        if (TextUtils.isEmpty(login) || TextUtils.isEmpty(senha)) {
            showToast("Preencha todos os campos");
            return;
        }

        if (!isValidEmail(login)) {
            showToast("Digite um e-mail válido");
            return;
        }

        // Verifica login no banco de dados
        boolean autenticado = dbHelper.verificarLogin(login, senha);

        if (autenticado) {
            showToast("Login bem-sucedido!");
            startActivity(new Intent(Login.this, MainActivity.class));
            finish(); // Fecha a tela de login

        } else {
            showToast("Usuário ou senha inválidos");
        }
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void showToast(String message) {
        Toast.makeText(Login.this, message, Toast.LENGTH_SHORT).show();
    }
}
