package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Lista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        List<Meta> listaMeta = (List<Meta>) getIntent().
                getSerializableExtra("lista");

        TextView textView = findViewById(R.id.Lista);

        StringBuilder mensagem = new StringBuilder();
        for(int i=0; i < listaMeta.size(); i++){
            Meta meta = listaMeta.get(i);
            mensagem.append("Id da Meta: ");
            mensagem.append(meta.getId());
            mensagem.append("\n");
            mensagem.append("Nome da Meta: ");
            mensagem.append(meta.getNome());
            mensagem.append("\n");
            mensagem.append("Data Limite: ");
            mensagem.append(meta.getData());
            mensagem.append("\n");
            mensagem.append("Descrição da Meta: ");
            mensagem.append(meta.getDescricao());
            mensagem.append("\n");
            mensagem.append("Valor necessário: R$ ");
            mensagem.append(meta.getValor());
            mensagem.append("\n");
            mensagem.append("----------------------------------------------------------");
            mensagem.append("\n");

        }

        textView.setText(mensagem.toString());




    }
}
