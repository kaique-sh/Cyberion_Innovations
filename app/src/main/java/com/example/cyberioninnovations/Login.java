package com.example.cyberioninnovations;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// Import corrigido!


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
        dbHelper = new DBHelper(this);
    }

    private void initViews() {
        etLogin = findViewById(R.id.etLogin);
        etSenha = findViewById(R.id.etSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCriarConta = findViewById(R.id.btnCriarConta);
    }

    private void setupListeners() {
        btnEntrar.setOnClickListener(view -> handleLogin());
        btnCriarConta.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, Cadastro.class);
            startActivity(intent);
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

        boolean autenticado = dbHelper.verificarLogin(login, senha);

        if (autenticado) {
            showToast("Login bem-sucedido!");
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        } else {
            showToast("Usuário ou senha inválidos");
        }
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
