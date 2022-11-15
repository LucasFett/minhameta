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
        setContentView(R.layout.activity_updater_medicamento);

        bancoDeDados = new BancoDeDados(this);
    }

    public void Atualizar(View view) {
        EditText id = findViewById(R.id.id_fruta);
        EditText novoPreco = findViewById(R.id.novo_preco);

        Integer idInteiro = Integer.parseInt(id.getText().toString());
        Float precoFrutaFloat = Float.parseFloat(novoPreco.getText().toString());

        bancoDeDados.updatePreco(idInteiro,precoFrutaFloat);

        Bundle bundle   = new Bundle();
        bundle.putSerializable("lista",(Serializable) bancoDeDados.buscaTodosMedicamentos());

        Intent intent= new Intent(this,ListagemMedicamentos.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}