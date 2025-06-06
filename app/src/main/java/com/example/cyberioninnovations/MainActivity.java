package com.example.cyberioninnovations;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAbrirChamado, btnAcompanharTickets, btnContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbrirChamado = findViewById(R.id.btnAbrirChamado);
        btnAcompanharTickets = findViewById(R.id.btnAcompanharTickets);
        btnContato = findViewById(R.id.btnContato);

        btnAbrirChamado.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SolicitarSuporteActivity.class);
            startActivity(intent);
        });

        btnAcompanharTickets.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AcompanhamentoActivity.class);
            startActivity(intent);
        });

        btnContato.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ContatoActivity.class);
            startActivity(intent);
        });
    }
}
