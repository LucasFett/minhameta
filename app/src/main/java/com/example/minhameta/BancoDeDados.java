package com.example.minhameta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

// para visualizar as tabelas, usar a ferramenta no android studio, chamada
// AAPP INSPECTION

public class BancoDeDados extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "medicamento";
    private static int VERSAO = 3;

    public BancoDeDados(Context context){
        super(context,NOME_BANCO,null,VERSAO);
        String name = getDatabaseName();
        Log.i("medicamentos",name);

        getWritableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("medicamento","Sendo executado onCreate");

        String sql = "CREATE TABLE medicamento (" +
                "id INTEGER PRIMARY KEY NOT NULL," +
                "nome TEXT NOT NULL," +
                "tipo TEXT NOT NULL," +
                "preco REAL NOT NULL)";

        sqLiteDatabase.execSQL(sql);

        Log.i("medicamento","Executado onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("medicamento","Executado onUpgrade");
    }

    // salvar por ContentValues
    public void salvarMedicamento(Medicamento medicamento){
        ContentValues linha = new ContentValues();
        linha.put("nome",medicamento.getNome());
        linha.put("tipo",medicamento.getTipo());
        linha.put("preco",medicamento.getPreco());

        getWritableDatabase()
                .insert("medicamento",null,linha);
    }

    public List<Medicamento> buscaTodosMedicamentos(){
        List<Medicamento> listaMedicamento = new ArrayList<>();
        String sql = "select nome,tipo,preco from medicamento";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Medicamento medicamento = new Medicamento();
            medicamento.setNome(cursor.getString(0));
            medicamento.setTipo(cursor.getString(1));
            medicamento.setPreco(cursor.getFloat(2));
            listaMedicamento.add(medicamento);
            cursor.moveToNext();
        }
        cursor.close();
        return listaMedicamento;
    }

    public List<Medicamento> buscaPorId(Integer id){
        List<Medicamento> listaMedicamento = new ArrayList<>();
        String sql = "select id,nome,tipo,preco from medicamento where id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Medicamento medicamento = new Medicamento();
            medicamento.setNome(cursor.getString(0));
            medicamento.setTipo(cursor.getString(1));
            medicamento.setPreco(cursor.getFloat(2));
            listaMedicamento.add(medicamento);
            cursor.moveToNext();
        }
        cursor.close();
        return listaMedicamento;
    }

    public List<Medicamento> buscaPorNome(String nome){
        List<Medicamento> listaMedicamento = new ArrayList<>();
        String sql = "select id,nome,tipo,preco from medicamento where nome == " + nome;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Medicamento medicamento = new Medicamento();
            medicamento.setNome(cursor.getString(0));
            medicamento.setTipo(cursor.getString(1));
            medicamento.setPreco(cursor.getFloat(2));
            listaMedicamento.add(medicamento);
            cursor.moveToNext();
        }
        cursor.close();
        return listaMedicamento;
    }

    public List<Medicamento> buscaPorTipo(String tipo){
        List<Medicamento> listaMedicamento = new ArrayList<>();
        String sql = "select id,nome,tipo,preco from medicamento where tipo == " + tipo;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Medicamento medicamento = new Medicamento();
            medicamento.setNome(cursor.getString(0));
            medicamento.setTipo(cursor.getString(1));
            medicamento.setPreco(cursor.getFloat(2));
            listaMedicamento.add(medicamento);
            cursor.moveToNext();
        }
        cursor.close();
        return listaMedicamento;
    }

    public List<Medicamento> buscaPorPreco(Float preco){
        List<Medicamento> listaMedicamento = new ArrayList<>();
        String sql = "select id,nome,tipo,preco from medicamento where preco = " + preco;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Medicamento medicamento = new Medicamento();
            medicamento.setNome(cursor.getString(0));
            medicamento.setTipo(cursor.getString(1));
            medicamento.setPreco(cursor.getFloat(2));
            listaMedicamento.add(medicamento);
            cursor.moveToNext();
        }
        cursor.close();
        return listaMedicamento;
    }



    public void deletarPorId(Integer id){
        String sql = "delete from medicamento where id = " + id;
        Log.i("medicamento","SQL deletarMedicamentoPorId: " + sql);
        getWritableDatabase().execSQL(sql);
    }

    public void deletarPorNome(String nome){
        String sql = "delete from medicamento where nome == '" + nome + "'";
        Log.i("medicamento","SQL deletarPorNome: " + sql);
        getWritableDatabase().execSQL(sql);
    }

    public void deletarPorTipo(String tipo){
        String sql = "delete from medicamento where tipo == '" + tipo + "'";
        Log.i("medicamento","SQL deletarPorTipo: " + sql);
        getWritableDatabase().execSQL(sql);
    }

    public void deletarPorPreco(Float preco){
        String sql = "delete from medicamento where preco == '" + preco + "'";
        Log.i("medicamento","SQL deletarPorNome: " + sql);
        getWritableDatabase().execSQL(sql);
    }



    public void updatePreco(Integer id, Float novoPreco){
        String sql = "update medicamento set preco = " + novoPreco +" where " +
                " id = " + id ;
        Log.i("medicamento","SQL updatePreco: " + sql);
        getWritableDatabase().execSQL(sql);
    }

    public void updateMedicamento(Integer id, Float novoPreco,String nome, String tipo){
        StringBuilder sql = new StringBuilder();
        sql.append("update preco set ");
        if(novoPreco != null && nome != null){
            sql.append(" preco = ").append(novoPreco).append(",");
            sql.append(" nome = ").append(nome);
            sql.append(" tipo = ").append(tipo);
        }
        sql.append(" where id = ").append(id);
        Log.i("Medicamento","SQL updateMedicamento: " + sql.toString());
        getWritableDatabase().execSQL(sql.toString());
    }

}
