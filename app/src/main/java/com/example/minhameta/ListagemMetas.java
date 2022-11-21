package com.example.minhameta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
//
public class ListagemMetas extends AppCompatActivity {

    BancoDeDados bancoDeDados = null;
//    public Integer idSelecionado;
//    public ListView listViewDados;
//    public ArrayList<Integer> arrayIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_meta);

        bancoDeDados = new BancoDeDados(this);

        Meta meta1 =new Meta();
        meta1.setNome("Nome Meta 1");
        meta1.setData("Data meta 1");
        meta1.setValor(5000f);
        meta1.setDescricao("Descrição meta 1");

        Meta meta2 =new Meta();
        meta2.setNome("Nome Meta 1");
        meta2.setData("Data meta 1");
        meta2.setValor(5000f);
        meta2.setDescricao("Descrição meta 1");

        Meta meta3 =new Meta();
        meta3.setNome("Nome Meta 1");
        meta3.setData("Data meta 1");
        meta3.setValor(1000f);
        meta3.setDescricao("Descrição meta 1");

        Meta meta4 =new Meta();
        meta4.setNome("Nome Meta 1");
        meta4.setData("Data meta 1");
        meta4.setValor(4000f);
        meta4.setDescricao("Descrição meta 1");

        Meta meta5 =new Meta();
        meta5.setNome("Nome Meta 1");
        meta5.setData("Data meta 1");
        meta5.setValor(6000f);
        meta5.setDescricao("Descrição meta 1");

        List<Meta> lista = new ArrayList<>();
        lista.add(meta1);
        lista.add(meta2);
        lista.add(meta3);
        lista.add(meta4);
        lista.add(meta5);

        Adapter adapter = new Adapter(this,lista);
        ListView listview = findViewById(R.id.lista);
        listview.setAdapter(adapter);

    }
}

//    private void listarDados() {
//        try {
//            arrayIds = new ArrayList<>();
//            SQLiteDatabase db = openOrCreateDatabase("meta", MODE_PRIVATE, null);
//            String sql = "select nome,data,descricao,valor from meta";
//            Cursor meuCursor = db.rawQuery(sql,null);
//            ArrayList<String> linhas = new ArrayList<String>();
//            ArrayAdapter meuAdapter = new ArrayAdapter<String>(
//                    this,
//                    android.R.layout.simple_list_item_1,
//                    android.R.id.text1,
//                    linhas
//            );
//            listViewDados.setAdapter(meuAdapter);
//            meuCursor.moveToFirst();
//            while(meuCursor!=null){
//                linhas.add(meuCursor.getString(1));
//                arrayIds.add(meuCursor.getInt(0));
//                meuCursor.moveToNext();
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public void excluir(){
//        //Toast.makeText(this, i.toString(), Toast.LENGTH_SHORT).show();
//        try{
//            SQLiteDatabase db = openOrCreateDatabase("meta", MODE_PRIVATE, null);
//            String sql = "DELETE FROM meta WHERE id =?";
//            SQLiteStatement stmt = db.compileStatement(sql);
//            stmt.bindLong(1, idSelecionado);
//            stmt.executeUpdateDelete();
//            listarDados();
//            db.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public void confirmaExcluir() {
//        AlertDialog.Builder msgBox = new AlertDialog.Builder(ListagemMetas.this);
//        msgBox.setTitle("Excluir");
//        msgBox.setIcon(android.R.drawable.ic_menu_delete);
//        msgBox.setMessage("Você realmente deseja excluir esse registro?");
//        msgBox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                excluir();
//                listarDados();
//            }
//        });
//        msgBox.setNegativeButton("Não", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//            }
//        });
//        msgBox.show();
//    }
//
//    public void abrirTelaAlterar(){
//        Intent intent = new Intent(this, Updater.class);
//        intent.putExtra("id",idSelecionado);
//        startActivity(intent);
//    }
//}