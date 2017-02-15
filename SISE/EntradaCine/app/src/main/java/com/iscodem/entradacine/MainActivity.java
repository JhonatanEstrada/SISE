package com.iscodem.entradacine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    EditText edtNombre;
    Spinner spnMovies;
    CheckBox chkPopcorn;
    CheckBox chkGaseosa;
    CheckBox chkCerveza;
    RadioGroup rbOpcionCompra;
    EditText edtCantidad;
    Button btnCalcular;

    String nombre;
    String movieSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        spnMovies = (Spinner) findViewById(R.id.spnMovies);
        chkPopcorn = (CheckBox) findViewById(R.id.chkPopcorn);
        chkGaseosa = (CheckBox) findViewById(R.id.chkGaseosa);
        chkCerveza = (CheckBox) findViewById(R.id.chkCerveza);
        rbOpcionCompra = (RadioGroup) findViewById(R.id.rbOpcion);
        edtCantidad = (EditText) findViewById(R.id.edtCantidad);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        Log.d(TAG,"edtNombre");

        nombre = edtNombre.getText().toString();
        movieSeleccionado = spnMovies.getSelectedItem().toString();
        String cantidad = edtCantidad.getText().toString();
        int opcionSeleccionada = rbOpcionCompra.getCheckedRadioButtonId();


    }

    public void calcular(View view){
        Toast.makeText(this,"Elemento: "+nombre,Toast.LENGTH_LONG);
        Toast.makeText(this,"Elemento: "+movieSeleccionado,Toast.LENGTH_LONG);
    }
}
