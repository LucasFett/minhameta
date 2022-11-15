package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class Deleter extends AppCompatActivity {

    BancoDeDados bancoDeDados = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleter_medicamento);

        bancoDeDados = new BancoDeDados(this);
    }

    public void deletar(View view) {
        EditText id = findViewById(R.id.deletar_por_id);
        Integer idInteiro = Integer.parseInt(id.getText().toString());

        bancoDeDados.deletarPorId(idInteiro);


        Bundle bundle = new Bundle();
        bundle.putSerializable("lista",(Serializable) bancoDeDados.buscaTodosMedicamentos());

        Intent intent= new Intent(this,ListagemMedicamentos.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}