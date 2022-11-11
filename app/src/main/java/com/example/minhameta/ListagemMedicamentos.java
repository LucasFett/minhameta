package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ListagemMedicamentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_medicamentos);
        List<Medicamento> listaMedicamento = (List<Medicamento>) getIntent().
                getSerializableExtra("lista");

        TextView textView = findViewById(R.id.lista);

        StringBuilder mensagem = new StringBuilder();
        for(int i=0; i < listaMedicamento.size(); i++){
            Medicamento medicamento = listaMedicamento.get(i);
            mensagem.append(medicamento.getNome());
            mensagem.append("\n");
            mensagem.append(medicamento.getTipo());
            mensagem.append("\n");
            mensagem.append(" R$ ");
            mensagem.append(medicamento.getPreco());
            mensagem.append("\n");
            mensagem.append("---------------------------------");
            mensagem.append("\n");

        }

        textView.setText(mensagem.toString());


    }
}