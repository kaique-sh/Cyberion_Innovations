package com.example.cyberioninnovations;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity responsável por exibir a lista de chamados em andamento.
 */
public class AcompanhamentoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChamadoAdapter adapter;
    private static final List<Chamado> chamados = new ArrayList<>();

    public static List<Chamado> getChamados() {
        return chamados;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acompanhamento);

        // Inicializa o RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Simula chamados de exemplo (só adiciona se a lista estiver vazia)
        if (chamados.isEmpty()) {
            chamados.add(new Chamado("Erro ao fazer login", "Autenticação", "Usuário não consegue acessar o sistema com credenciais corretas."));
            chamados.add(new Chamado("Tela inicial travando", "Interface", "Aplicativo congela ao carregar a tela principal."));
        }

        // Configura o adapter com a lista
        adapter = new ChamadoAdapter(chamados);
        recyclerView.setAdapter(adapter);
    }
}
