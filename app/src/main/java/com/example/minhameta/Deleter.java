package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;
//
public class Deleter extends AppCompatActivity {

    BancoDeDados bancoDeDados = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleter);

        bancoDeDados = new BancoDeDados(this);
    }

    public void deletar(View view) {
        EditText id= findViewById(R.id.IdDeleteMeta);
//        EditText data = findViewById(R.id.editTextDataMetaUpdate);
//        EditText descricao = findViewById(R.id.editTextDescricaoMetaUpdate);
//        EditText valor = findViewById(R.id.editTextValorMetaUpdate);

//        String novoNome = nome.getText().toString();
//        String novoData = data.getText().toString();
//        String novoDescricao = descricao.getText().toString();
//        Float novoValor = Float.parseFloat(valor.getText().toString());


        Integer idSelecionado= Integer.parseInt(id.getText().toString());;



        bancoDeDados.deletarMetaPorId(idSelecionado);


        Bundle bundle = new Bundle();
        bundle.putSerializable("lista",(Serializable) bancoDeDados.buscaTodasMetas());

        Intent intent= new Intent(this, Lista.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}