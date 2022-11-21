package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    BancoDeDados bancoDeDados = null;
    public Button listagem, cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_meta);

        bancoDeDados = new BancoDeDados(this);
        Button listagem = findViewById(R.id.buttonMostrarLista);
        Button cadastro = findViewById(R.id.buttonCadastrarNovaMeta);
    }


    public void abreTelaAtualizacao(View view) {

        Intent intent = new Intent(this,Updater.class);
        startActivity(intent);
    }

    public void abrir_delete(View view) {

        Intent intent = new Intent(this,Deleter.class);
        startActivity(intent);
    }


}