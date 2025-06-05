package com.example.cyberioninnovations;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SolicitarSuporteActivity extends AppCompatActivity {

    EditText edtAssunto, edtDescricao;
    Spinner spinnerChamado;
    Button btnEnviar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_suporte);

        edtAssunto = findViewById(R.id.edtAssunto);
        edtDescricao = findViewById(R.id.edtDescricao);
        spinnerChamado = findViewById(R.id.spinnerChamado);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v -> {
            String assunto = edtAssunto.getText().toString().trim();
            String descricao = edtDescricao.getText().toString().trim();
            String categoria = spinnerChamado.getSelectedItem().toString();

            if (assunto.isEmpty() || descricao.isEmpty()) {
                Toast.makeText(SolicitarSuporteActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {
                Chamado novoChamado = new Chamado(assunto, categoria, descricao);
                AcompanhamentoActivity.getChamados().add(novoChamado);

                Intent intent = new Intent(SolicitarSuporteActivity.this, Activity_etapa_concluida.class);
                startActivity(intent);
            }
        });
    }
}
