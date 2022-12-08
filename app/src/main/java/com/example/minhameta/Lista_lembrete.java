package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Lista_lembrete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lembrete);

        List<Lembrete> listaLembrete = (List<Lembrete>) getIntent().
                getSerializableExtra("lista");

        TextView textView = findViewById(R.id.listaLembretes);

        StringBuilder mensagem = new StringBuilder();
        for(int i=0; i < listaLembrete.size(); i++) {
            Lembrete lembrete = listaLembrete.get(i);
            mensagem.append("\n");
            mensagem.append("Id do Lembrete: ");
            mensagem.append(lembrete.getId());
            mensagem.append("\n");
            mensagem.append("Lembrete: ");
            mensagem.append(lembrete.getTextoLembrete());
            mensagem.append("\n");
            mensagem.append("-----------------------------------------------");
        }
        textView.setText(mensagem.toString());

    }
}