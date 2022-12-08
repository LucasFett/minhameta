package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class deletar_lembrete extends AppCompatActivity {
    Banco_lembrete banco_lembrete = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar_lembrete);
        banco_lembrete = new Banco_lembrete(this);

    }

    public void deletarlembrete(View view) {
        EditText id= findViewById(R.id.idparadeletarlembrete);

        Integer idDoLembrete = Integer.parseInt(id.getText().toString());;

        banco_lembrete.deletarLembretePorId(idDoLembrete);

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) banco_lembrete.buscaLembretes());

        Intent intent = new Intent(this, Lista_lembrete.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}