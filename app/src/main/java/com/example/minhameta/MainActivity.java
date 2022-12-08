package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
//
    BancoDeDados bancoDeDados = null;
    Banco_lembrete banco_lembrete = null;

    //public Button listagem, cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bancoDeDados = new BancoDeDados(this);
        banco_lembrete = new Banco_lembrete(this);
        //Button listagem = findViewById(R.id.buttonMostrarLista);
        //Button cadastro = findViewById(R.id.buttonCadastrarNovaMeta);
    }



    public void abrir_listView(View view) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) bancoDeDados.buscaTodasMetas());

        Intent intent = new Intent(this, Lista.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void abrir_cadastro_activity(View view) {
        Intent intent = new Intent(this,Cadastro.class);
        startActivity(intent);
    }

    public void ir_tela_delete(View view) {
        Intent intent = new Intent(this,Deleter.class);
        startActivity(intent);
    }

    public void ir_tela_update(View view) {
        Intent intent = new Intent(this,Updater.class);
        startActivity(intent);
    }

    public void irLembrete(View view) {
        Intent intent = new Intent(this,Cadastro_lembrete.class);
        startActivity(intent);

    }

    public void ir_tela_delete_lembrete(View view) {
        Intent intent = new Intent(this,deletar_lembrete.class);
        startActivity(intent);
    }

    public void listar_lembretes(View view) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) banco_lembrete.buscaLembretes());

        Intent intent = new Intent(this, Lista_lembrete.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}