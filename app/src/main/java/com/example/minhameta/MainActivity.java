package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    BancoDeDados bancoDeDados = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bancoDeDados = new BancoDeDados(this);
    }

    public void salvar(View view) {
        EditText nome = findViewById(R.id.nomeMedicamentos);
        EditText tipo = findViewById(R.id.tipoMedicamentos);
        EditText preco = findViewById(R.id.precoMedicamento);

        if (nome.getText().toString().equals("")) {
            Toast.makeText(this, "ERROR, Nome está vazio", Toast.LENGTH_LONG).show();
            return;
        }
        if (tipo.getText().toString().equals("")) {
            Toast.makeText(this, "ERROR, Tipo está vazio", Toast.LENGTH_LONG).show();
            return;
        }
        if (preco.getText().toString().equals("")) {
            Toast.makeText(this, "ERROR, Preço está vazio", Toast.LENGTH_LONG).show();
            return;
        }

        Medicamento medicamento = new Medicamento();
        medicamento.setNome(nome.getText().toString());
        medicamento.setTipo(tipo.getText().toString());
        Float precoFloat = Float.parseFloat(preco.getText().toString());
        medicamento.setPreco(precoFloat);

        bancoDeDados.salvarMedicamento(medicamento);

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) bancoDeDados.buscaTodosMedicamentos());

        Intent intent = new Intent(this, ListagemMedicamentos.class);
        intent.putExtras(bundle);
        startActivity(intent);

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