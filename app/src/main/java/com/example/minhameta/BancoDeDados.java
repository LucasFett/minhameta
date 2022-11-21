package com.example.minhameta;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

// para visualizar as tabelas, usar a ferramenta no android studio, chamada
// AAPP INSPECTION

public class BancoDeDados extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "meta";
    private static int VERSAO = 3;

    public BancoDeDados(Context context){
        super(context,NOME_BANCO,null,VERSAO);
        String name = getDatabaseName();
        Log.i("metas",name);

        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("meta","Sendo executado onCreate");

        String sql = "CREATE TABLE meta (" +
                "id INTEGER PRIMARY KEY," +
                "nome TEXT NOT NULL," +
                "data TEXT NOT NULL," +
                "descricao TEXT NOT NULL," +
                "valor REAL NOT NULL)";

        sqLiteDatabase.execSQL(sql);

        Log.i("meta","Executado onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("meta","Executado onUpgrade");
    }


    // salvar por ContentValues
    public void salvarMeta(Meta meta){
        ContentValues linha = new ContentValues();
        linha.put("nome", meta.getNome());
        linha.put("data", meta.getData());
        linha.put("descricao", meta.getDescricao());
        linha.put("valor", meta.getValor());

        getWritableDatabase()
                .insert("meta",null,linha);
    }

    public List<Meta> buscaPorId(Integer id){
        List<Meta> listaMeta = new ArrayList<>();
        String sql = "select id from meta where id == " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Meta meta = new Meta();
            meta.setNome(cursor.getString(0));
            meta.setData(cursor.getString(1));
            meta.setValor(cursor.getFloat(2));
            meta.setDescricao(cursor.getString(3));
            listaMeta.add(meta);
            cursor.moveToNext();
        }
        cursor.close();
        return listaMeta;
    }

    public List<Meta> buscaTodasMetas(){
        List<Meta> listaMeta = new ArrayList<>();
        String sql = "select nome,data,descricao,valor from meta";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Meta meta = new Meta();
            meta.setNome(cursor.getString(0));
            meta.setData(cursor.getString(1));
            meta.setValor(cursor.getFloat(2));
            meta.setDescricao(cursor.getString(3));
            listaMeta.add(meta);
            cursor.moveToNext();
        }
        cursor.close();
        return listaMeta;
    }

    public List<Meta> buscaPorNome(String nome){
        List<Meta> listaMeta = new ArrayList<>();
        String sql = "select nome from meta where nome == " + nome;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Meta meta = new Meta();
            meta.setNome(cursor.getString(0));
            listaMeta.add(meta);
            cursor.moveToNext();
        }
        cursor.close();
        return listaMeta;
    }

    public List<Meta> buscaPorData(String data){
        List<Meta> listaMeta = new ArrayList<>();
        String sql = "select data from meta where data = " + data;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Meta meta = new Meta();
            meta.setData(cursor.getString(0));
            listaMeta.add(meta);
            cursor.moveToNext();
        }
        cursor.close();
        return listaMeta;
    }

    public List<Meta> buscaPorDescricao(String descricao){
        List<Meta> listaMeta = new ArrayList<>();
        String sql = "select descricao from meta where descricao == " + descricao;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Meta meta = new Meta();
            meta.setDescricao(cursor.getString(0));
            listaMeta.add(meta);
            cursor.moveToNext();
        }
        cursor.close();
        return listaMeta;
    }

    public List<Meta> buscaPorValor(Float valor){
        List<Meta> listaMeta = new ArrayList<>();
        String sql = "select valor from meta where valor = " + valor;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Meta meta = new Meta();
            meta.setValor(cursor.getFloat(0));
            listaMeta.add(meta);
            cursor.moveToNext();
        }
        cursor.close();
        return listaMeta;
    }



    public void deletarPorNome(String nome){
        String sql = "delete from meta where nome == '" + nome + "'";
        Log.i("meta","SQL deletarPorNome: " + sql);
        getWritableDatabase().execSQL(sql);
    }

    public void deletarPorData(String data){
        String sql = "delete from meta where data == '" + data + "'";
        Log.i("meta","SQL deletarPorData: " + sql);
        getWritableDatabase().execSQL(sql);
    }

    public void deletarPorDescricao(String descricao){
        String sql = "delete from meta where descricao == '" + descricao + "'";
        Log.i("meta","SQL deletarPorDescricao: " + sql);
        getWritableDatabase().execSQL(sql);
    }

    public void deletarPorValor(Float valor){
        String sql = "delete from meta where valor == '" + valor + "'";
        Log.i("meta","SQL deletarPorValor: " + sql);
        getWritableDatabase().execSQL(sql);
    }



    public void updateNome(Integer id, String novoNome){
        String sql = "update meta set nome = " + novoNome +" where " +
                " id = " + id ;
        Log.i("meta","SQL updateNome: " + sql);
        getWritableDatabase().execSQL(sql);
    }

    public void updateData(Integer id, String novoData){
        String sql = "update meta set data = " + novoData +" where " +
                " id = " + id ;
        Log.i("meta","SQL updateData: " + sql);
        getWritableDatabase().execSQL(sql);
    }

    public void updateDescricao(Integer id, String novoDescricao){
        String sql = "update meta set descricao = " + novoDescricao +" where " +
                " id = " + id ;
        Log.i("meta","SQL updateDescricao: " + sql);
        getWritableDatabase().execSQL(sql);
    }

    public void updateValor(Integer id, Float novoValor){
        String sql = "update meta set valor = " + novoValor +" where " +
                " id = " + id ;
        Log.i("meta","SQL updateValor: " + sql);
        getWritableDatabase().execSQL(sql);
    }


    public void updateMeta(Integer id, String novoNome, String novoData,String novoDescricao, Float novoValor){
        StringBuilder sql = new StringBuilder();
        sql.append("update meta set ");
        if(novoNome != null && novoData != null && novoDescricao != null && novoValor != null){
            sql.append(" nome = ").append(novoNome).append(",");
            sql.append(" data = ").append(novoData).append(",");
            sql.append(" descricao = ").append(novoDescricao).append(",");
            sql.append(" valor = ").append(novoValor);
        }
        sql.append(" where id = ").append(id);
        Log.i("meta","SQL updateMeta: " + sql.toString());
        getWritableDatabase().execSQL(sql.toString());
    }
}
