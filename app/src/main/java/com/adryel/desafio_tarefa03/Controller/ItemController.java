package com.adryel.desafio_tarefa03.Controller;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.adryel.desafio_tarefa03.DB.BancoHelper;
import com.adryel.desafio_tarefa03.Model.Item;

import java.util.ArrayList;

public class ItemController {
    private SQLiteDatabase db;
    private BancoHelper banco;

    public ItemController(Context context) {
        banco = new BancoHelper(context);
        db = banco.getWritableDatabase();
    }

    public long inserir(Item item) {
        ContentValues valores = new ContentValues();
        valores.put("nome", item.getNome());
        valores.put("categoria", item.getCategoria());
        valores.put("pronto", item.isPronto() ? 1 : 0);
        valores.put("fotoUri", item.getFotoUri());
        return db.insert("item", null, valores);
    }

    public ArrayList<Item> listar() {
        ArrayList<Item> lista = new ArrayList<>();
        Cursor cursor = db.query("item", null, null, null, null, null, "categoria ASC");

        while (cursor.moveToNext()) {
            Item item = new Item();
            item.setId(cursor.getInt(0));
            item.setNome(cursor.getString(1));
            item.setCategoria(cursor.getString(2));
            item.setPronto(cursor.getInt(3) == 1);
            item.setFotoUri(cursor.getString(4));
            lista.add(item);
        }
        return lista;
    }

    public void atualizar(Item item) {
        ContentValues valores = new ContentValues();
        valores.put("nome", item.getNome());
        valores.put("categoria", item.getCategoria());
        valores.put("pronto", item.isPronto() ? 1 : 0);
        valores.put("fotoUri", item.getFotoUri());
        db.update("item", valores, "id=?", new String[]{String.valueOf(item.getId())});
    }

    public void deletar(int id) {
        db.delete("item", "id=?", new String[]{String.valueOf(id)});
    }
}


