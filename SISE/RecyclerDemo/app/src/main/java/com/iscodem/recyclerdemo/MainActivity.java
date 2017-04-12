package com.iscodem.recyclerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iscodem.recyclerdemo.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);

    }

    public void iniciar(View view){
        Toast.makeText(MainActivity.this, "Estoy aqui", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ContainerActivity.class);
        Toast.makeText(MainActivity.this, "Termine aqui", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }
}
