package com.adryel.desafio_tarefa03;


import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

import com.adryel.desafio_tarefa03.Controller.ItemController;
import com.adryel.desafio_tarefa03.Model.Item;

import java.util.ArrayList;

public class ListaItemActivity extends Activity {
    ListView listView;
    ItemController controller;
    ArrayAdapter<String> adapter;
    ArrayList<Item> itens;
    ArrayList<String> titulos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_item);

        listView = findViewById(R.id.listViewItens);
        controller = new ItemController(this);
        atualizarLista();

        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            Item item = itens.get(i);
            controller.deletar(item.getId());
            Toast.makeText(this, "Item removido!", Toast.LENGTH_SHORT).show();
            atualizarLista();
            return false;
        });
    }


    private void atualizarLista() {
        itens = controller.listar();
        titulos = new ArrayList<>();
        for (Item item : itens) {
            titulos.add(item.getNome() + ": " + item.getNome() + (item.isPronto() ? " ✔️" : " ❌"));
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titulos);
        listView.setAdapter(adapter);
    }
}
