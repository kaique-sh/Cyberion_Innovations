package com.example.cyberioninnovations;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ContatoActivity extends AppCompatActivity {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(v -> {
            // Finaliza a activity atual e volta para a anterior (MainActivity)
            finish();
        });
    }
}
