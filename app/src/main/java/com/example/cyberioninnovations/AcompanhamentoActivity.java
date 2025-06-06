package com.example.cyberioninnovations;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AcompanhamentoActivity extends AppCompatActivity {

    private ListView listChamados;
    private ChamadoAdapter adapter;
    private ArrayList<Chamado> chamados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acompanhamento);

        listChamados = findViewById(R.id.listChamados);
        Button btnVoltar = findViewById(R.id.btnVoltar); // Botão de voltar

        // Ação do botão
        btnVoltar.setOnClickListener(v -> finish());

        // Pega lista do repositório
        chamados = ChamadoRepository.chamados;

        adapter = new ChamadoAdapter(this, chamados);
        listChamados.setAdapter(adapter);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Tickets em andamento");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
