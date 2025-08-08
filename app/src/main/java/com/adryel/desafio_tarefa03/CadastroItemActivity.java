package com.adryel.desafio_tarefa03;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.*;

import com.adryel.desafio_tarefa03.Controller.ItemController;
import com.adryel.desafio_tarefa03.Model.Item;
import com.adryel.desafio_tarefa03.R;

public class CadastroItemActivity extends Activity {
    EditText editNome, editCategoria;
    CheckBox checkPronto;
    ImageView imagePreview;
    String fotoUri = "";
    static final int REQUEST_CAMERA = 1;
    ItemController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_item);

        editNome = findViewById(R.id.editNome);
        editCategoria = findViewById(R.id.editCategoria);
        checkPronto = findViewById(R.id.checkPronto);
        imagePreview = findViewById(R.id.imagePreview);
        Button btnFoto = findViewById(R.id.btnFoto);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        controller = new ItemController(this);

        btnFoto.setOnClickListener(v -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, REQUEST_CAMERA);
        });

        btnSalvar.setOnClickListener(v -> {
            Item item = new Item(
                    editNome.getText().toString(),
                    editCategoria.getText().toString(),
                    checkPronto.isChecked(),
                    fotoUri
            );
            controller.inserir(item);
            Toast.makeText(this, "Item salvo com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
            Bitmap foto = (Bitmap) data.getExtras().get("data");
            imagePreview.setImageBitmap(foto);
            Uri uri = getImageUri(foto);
            fotoUri = uri.toString();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private Uri getImageUri(Bitmap bitmap) {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "Foto_Item");
        values.put(MediaStore.Images.Media.DESCRIPTION, "Foto tirada da câmera");
        return getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
    }
}
