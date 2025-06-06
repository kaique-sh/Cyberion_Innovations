package com.example.cyberioninnovations;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SolicitarSuporteActivity extends AppCompatActivity {

    EditText edtAssunto, edtDescricao;
    Spinner spinnerChamado;
    Button btnEnviar, btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_suporte);

        // Título via ActionBar (opcional)
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.abrir_chamado_title));
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);  // desabilita seta ActionBar, pois temos botão manual
        }

        edtAssunto = findViewById(R.id.etAssunto);
        edtDescricao = findViewById(R.id.etDescricao);
        spinnerChamado = findViewById(R.id.spinnerChamado);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnVoltar = findViewById(R.id.btnVoltar);

        // Adapter para o spinner com layout personalizado (opcional)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.categorias_chamado,
                R.layout.spinner_item // seu layout customizado, se tiver
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChamado.setAdapter(adapter);

        // Botão Voltar funcionando
        btnVoltar.setOnClickListener(v -> finish());

        btnEnviar.setOnClickListener(v -> {
            String assunto = edtAssunto.getText().toString().trim();
            String descricao = edtDescricao.getText().toString().trim();
            String categoria = spinnerChamado.getSelectedItem().toString();

            if (assunto.isEmpty() || descricao.isEmpty()) {
                Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_SHORT).show();
            } else {
                Chamado chamado = new Chamado(assunto, categoria, descricao);
                ChamadoRepository.chamados.add(chamado);

                Toast.makeText(this, getString(R.string.chamado_enviado_sucesso), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SolicitarSuporteActivity.this, AcompanhamentoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
