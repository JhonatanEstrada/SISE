package com.iscodem.loginfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BienvenidoActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();

        TextView tvUsuarioBienvenida = (TextView) findViewById(R.id.tvUsuarioBienvenida);
        tvUsuarioBienvenida.setText("Estimado Sr(a): "+nombre+" \n\nUsted se encuentra en la página del Ministerio de Educación, " +
                "a través del cual podrá realizar toda las transacciones propias de la institución.");

    }
}
