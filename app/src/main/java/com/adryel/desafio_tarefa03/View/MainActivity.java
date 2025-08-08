package com.adryel.desafio_tarefa03.View;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.adryel.desafio_tarefa03.CadastroItemActivity;
import com.adryel.desafio_tarefa03.ListaItemActivity;
import com.adryel.desafio_tarefa03.R;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCadastro = findViewById(R.id.btnCadastro);
        Button btnLista = findViewById(R.id.btnLista);

        btnCadastro.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, CadastroItemActivity.class)));

        btnLista.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ListaItemActivity.class)));
    }
}
