package com.example.cyberioninnovations;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastro extends AppCompatActivity {

    private EditText etNome, etEmail, etSenha, etConfirmarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        etConfirmarSenha = findViewById(R.id.etConfirmarSenha);
        Button btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(view -> {
            String nome = etNome.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String senha = etSenha.getText().toString().trim();
            String confirmarSenha = etConfirmarSenha.getText().toString().trim();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
                Toast.makeText(Cadastro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else if (!senha.equals(confirmarSenha)) {
                Toast.makeText(Cadastro.this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
            } else {
                // Aqui você pode salvar os dados (local ou remoto)
                Toast.makeText(Cadastro.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                finish(); // Retorna para tela de login
            }
        });
    }
}