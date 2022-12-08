package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Banco_lembrete extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "lembrete";
    private static int VERSAO = 3;

    public Banco_lembrete(Context context){
        super(context,NOME_BANCO,null,VERSAO);
        String name = getDatabaseName();
        Log.i("metas",name);

        getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("lembrete","Sendo executado onCreate");

        String sql = "CREATE TABLE lembrete (" +
                "id INTEGER PRIMARY KEY," +
                "lembrete TEXT NOT NULL)";

        sqLiteDatabase.execSQL(sql);

        Log.i("lembrete","Executado onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("lembrete","Executado onUpgrade");
    }
    public void salvarLembrete(Lembrete lembrete){
        ContentValues linha = new ContentValues();
        linha.put("lembrete", lembrete.getTextoLembrete());

        getWritableDatabase()
                .insert("lembrete",null,linha);
    }

    public List<Lembrete> buscaLembretes() {
        List<Lembrete> listaLembrete = new ArrayList<>();
        String sql = "select id,lembrete from lembrete";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            Lembrete lembrete = new Lembrete();
            lembrete.setId(cursor.getInt(0));
            lembrete.setTextoLembrete(cursor.getString(1));
            listaLembrete.add(lembrete);
            cursor.moveToNext();
        }
        cursor.close();
        return listaLembrete;
    }

    public void deletarLembretePorId(Integer id){
        String sql = "delete from lembrete where id = " + id;
        Log.i("lembrete","SQL deletarLembretePorId: " + sql);
        getWritableDatabase().execSQL(sql);
    }
}