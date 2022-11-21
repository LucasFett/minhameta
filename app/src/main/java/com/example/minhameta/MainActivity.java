package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
//
    BancoDeDados bancoDeDados = null;
    //public Button listagem, cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bancoDeDados = new BancoDeDados(this);
        //Button listagem = findViewById(R.id.buttonMostrarLista);
        //Button cadastro = findViewById(R.id.buttonCadastrarNovaMeta);
    }


//    public void abreTelaAtualizacao(View view) {
//
//        Intent intent = new Intent(this,Updater.class);
//        startActivity(intent);
//    }
//
//    public void abrir_delete(View view) {
//
//        Intent intent = new Intent(this,Deleter.class);
//        startActivity(intent);
//    }


    public void abrir_listView(View view) {Intent intent = new Intent(this,ListagemMetas.class);
        startActivity(intent);    }

    public void abrir_cadastro_activity(View view) {
        Intent intent = new Intent(this,Cadastro.class);
        startActivity(intent);
    }

}