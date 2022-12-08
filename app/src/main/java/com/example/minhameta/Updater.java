package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class Updater extends AppCompatActivity {
//
    BancoDeDados bancoDeDados = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updater);

        bancoDeDados = new BancoDeDados(this);
    }

    public void atualizarMeta(View view) {
        EditText id = findViewById(R.id.Seleciona_id);
//        EditText nome = findViewById(R.id.editTextNomeMetaUpdate);
//        EditText data = findViewById(R.id.editTextDataMetaUpdate);
//        EditText descricao = findViewById(R.id.editTextDescricaoMetaUpdate);
        EditText valor = findViewById(R.id.editTextValorMetaUpdate);

        Integer novoid= Integer.parseInt(id.getText().toString());;
//        String novoNome = (nome.getText().toString());
//        String novoData = String.valueOf(data);
//        String novoDescricao = String.valueOf(descricao);
        Float novoValor = Float.parseFloat(valor.getText().toString());


        //bancoDeDados.updateMeta(idInteiro,novoNome,novoData,novoDescricao,novoValor);
//        bancoDeDados.updateNome(novoid,novoNome);
//        bancoDeDados.updateData(novoid,novoData);
//        bancoDeDados.updateDescricao(novoid,novoDescricao);
        bancoDeDados.updateValor(novoid,novoValor);


        Bundle bundle   = new Bundle();
        bundle.putSerializable("lista",(Serializable) bancoDeDados.buscaTodasMetas());

        Intent intent= new Intent(this, Lista.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}