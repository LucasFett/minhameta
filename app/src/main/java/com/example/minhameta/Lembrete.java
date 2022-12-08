package com.example.minhameta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;

public class Lembrete implements Serializable {
    private String textoLembrete;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextoLembrete() {
        return textoLembrete;
    }

    public void setTextoLembrete(String textoLembrete) {
        this.textoLembrete = textoLembrete;
    }
}