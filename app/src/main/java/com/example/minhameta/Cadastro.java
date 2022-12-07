package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
//
public class Cadastro extends AppCompatActivity {

    BancoDeDados bancoDeDados = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_meta);

        bancoDeDados = new BancoDeDados(this);
    }

    public void Cadastrar(View view) {
        EditText nome = findViewById(R.id.editTextNomeMetaUpdate);
        EditText ValorNecessario = findViewById(R.id.editTextValorMetaUpdate);
        EditText DataLimite = findViewById(R.id.editTextDataMetaUpdate);
        EditText Descricao = findViewById(R.id.editTextDescricaoMetaUpdate);


       if(nome.getText().toString().equals("")){
        Toast.makeText(this,"ERROR, Nome está vazio",Toast.LENGTH_LONG).show();
        return;
    }
        if (ValorNecessario.getText().toString().equals("")) {
            Toast.makeText(this, "ERROR, Valor está vazio", Toast.LENGTH_LONG).show();
            return;
        }
        if (DataLimite.getText().toString().equals("")) {
            Toast.makeText(this, "ERROR, Data está vazia", Toast.LENGTH_LONG).show();
            return;
        }
        if (Descricao.getText().toString().equals("")) {
            Toast.makeText(this, "ERROR, Descrição está vazia", Toast.LENGTH_LONG).show();
            return;
        }
        try{
            Double.parseDouble(ValorNecessario.getText().toString());
        }catch(Exception e){
            Toast.makeText(this,"ERROR, Valor Necessário deve ser numérico.",
                    Toast.LENGTH_LONG).show();
            return;
        }


        Meta meta = new Meta();
        meta.setNome(nome.getText().toString());
        meta.setData(DataLimite.getText().toString());
        meta.setDescricao(Descricao.getText().toString());
        Float valorFloat = Float.parseFloat(ValorNecessario.getText().toString());
        meta.setValor(valorFloat);
        bancoDeDados.salvarMeta(meta);

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) bancoDeDados.buscaTodasMetas());

        Intent intent = new Intent(this, Lista.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}