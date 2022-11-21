package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class Cadastro extends AppCompatActivity {

    BancoDeDados bancoDeDados = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_meta);

        bancoDeDados = new BancoDeDados(this);
    }

    public void salvar(View view) {
        EditText nome = findViewById(R.id.editTextNomeMetaUpdate);
        EditText valor = findViewById(R.id.editTextValorMetaUpdate);
        EditText data = findViewById(R.id.editTextDataMetaUpdate);
        EditText descricao = findViewById(R.id.editTextDescricaoMetaUpdate);

        if (nome.getText().toString().equals("")) {
            Toast.makeText(this, "ERROR, Nome está vazio", Toast.LENGTH_LONG).show();
            return;
        }
        if (valor.getText().toString().equals("")) {
            Toast.makeText(this, "ERROR, Valor está vazio", Toast.LENGTH_LONG).show();
            return;
        }
        if (data.getText().toString().equals("")) {
            Toast.makeText(this, "ERROR, Data está vazia", Toast.LENGTH_LONG).show();
            return;
        }
        if (descricao.getText().toString().equals("")) {
            Toast.makeText(this, "ERROR, Descrição está vazia", Toast.LENGTH_LONG).show();
            return;
        }

        Meta meta = new Meta();
        meta.setNome(nome.getText().toString());
        meta.setData(data.getText().toString());
        meta.setDescricao(descricao.getText().toString());

        Float valorFloat = Float.parseFloat(valor.getText().toString());
        meta.setValor(valorFloat);

        bancoDeDados.salvarMeta(meta);

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) bancoDeDados.buscaTodasMetas());

        Intent intent = new Intent(this, ListagemMetas.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}