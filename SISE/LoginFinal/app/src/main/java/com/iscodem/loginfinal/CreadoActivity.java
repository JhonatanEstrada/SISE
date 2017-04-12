package com.iscodem.loginfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CreadoActivity extends AppCompatActivity {
    TextView tvMensajeExito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creado);
        tvMensajeExito =(TextView) findViewById(R.id.tvMensajeExito);
        Intent intent=getIntent();
        tvMensajeExito.setText(intent.getStringExtra("mensaje"));
    }
}
