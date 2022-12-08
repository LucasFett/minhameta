package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class Cadastro_lembrete extends AppCompatActivity {
    Banco_lembrete banco_lembrete = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_lembrete);
        banco_lembrete = new Banco_lembrete(this);

    }

    public void salvarLembrete(View view) {
        EditText texto = findViewById(R.id.EscreverLembrete);

        Lembrete lembrete = new Lembrete();
        lembrete.setTextoLembrete(texto.getText().toString());
        banco_lembrete.salvarLembrete(lembrete);

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) banco_lembrete.buscaLembretes());

        Intent intent = new Intent(this, Lista_lembrete.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}