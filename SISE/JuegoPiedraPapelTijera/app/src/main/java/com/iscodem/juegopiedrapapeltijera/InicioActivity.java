package com.iscodem.juegopiedrapapeltijera;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class InicioActivity extends AppCompatActivity {
    private static final String TAG = InicioActivity.class.getName();
    private static final Random rgenerador = new Random();

    private static final Integer[] imagenesID = {R.drawable.piedra, R.drawable.papel, R.drawable.tijera,};
    //aquí estamos llamando a las 3 imágenes de drawable según corresponda.

    private ImageView imgPiedraMin;
    private ImageView imgPapelMin;
    private ImageView imgTijeraMin;

    private ImageView imgIncognita;

    private ImageView imgUsuario;
    private ImageView imgSistema;
    private Button btnJugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        imgUsuario=(ImageView) findViewById(R.id.imgUsuario);
        imgPiedraMin=(ImageView) findViewById(R.id.imgPiedraMin);
        imgPapelMin=(ImageView) findViewById(R.id.imgPapelMin);
        imgTijeraMin=(ImageView) findViewById(R.id.imgTijeraMin);

        Integer q = imagenesID[rgenerador.nextInt(imagenesID.length)];
        final ImageView imgSistema = (ImageView) findViewById(R.id.imgSistema);

        //Inicio del Juego
        View btnJugar = findViewById(R.id.btnJugar);
        btnJugar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                int resource = imagenesID[rgenerador.nextInt(imagenesID.length)];
                imgSistema.setImageResource(resource);

                Toast.makeText(getApplicationContext(),"Se procedio al juego",Toast.LENGTH_LONG).show();
            }
        });

        //Al hacer click en Piedra
        imgPiedraMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgUsuario.setImageResource(R.drawable.piedra);
            }
        });

        //Al hacer click en Papel
        imgPapelMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgUsuario.setImageResource(R.drawable.papel);
            }
        });

        //Al hacer click en Tijera
        imgTijeraMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgUsuario.setImageResource(R.drawable.tijera);
            }
        });

    }

}
