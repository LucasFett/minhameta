package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class Updater extends AppCompatActivity {

    BancoDeDados bancoDeDados = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updater);

        bancoDeDados = new BancoDeDados(this);
    }

    public void Atualizar(View view) {
        EditText nome = findViewById(R.id.editTextNomeMetaUpdate);
        EditText data = findViewById(R.id.editTextDataMetaUpdate);
        EditText descricao = findViewById(R.id.editTextDescricaoMetaUpdate);
        EditText valor = findViewById(R.id.editTextValorMetaUpdate);

        String novoNome = nome.getText().toString();
        String novoData = data.getText().toString();
        String novoDescricao = descricao.getText().toString();
        Float novoValor = Float.parseFloat(valor.getText().toString());


        bancoDeDados.updateNome(id, novoNome);
        bancoDeDados.updateData(id, novoData);
        bancoDeDados.updateDescricao(id, novoDescricao);
        bancoDeDados.updateValor(id, novoValor);

        Bundle bundle   = new Bundle();
        bundle.putSerializable("lista",(Serializable) bancoDeDados.buscaTodasMetas());

        Intent intent= new Intent(this, ListagemMetas.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}