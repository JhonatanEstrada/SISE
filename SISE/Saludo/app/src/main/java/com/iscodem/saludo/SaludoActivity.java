package com.iscodem.saludo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SaludoActivity extends AppCompatActivity {
    private static final String TAG =SaludoActivity.class.getSimpleName();
    EditText edtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"Inicio - "+this.getClass().getName());
        Log.d(TAG,"TAG - "+SaludoActivity.class.getSimpleName());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        //String valorNombre = edtNombre.toString();

        Log.i(TAG, "valorNombre: "+ edtNombre.getText());
    }

    public void saludar(View view){
        Toast.makeText(this,"Bienvenido: "+edtNombre.getText(),Toast.LENGTH_LONG).show();
    }
}
