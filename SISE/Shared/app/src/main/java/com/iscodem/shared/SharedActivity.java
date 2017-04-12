package com.iscodem.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedActivity extends AppCompatActivity {
    private static final String TAG =SharedActivity.class.getName();

    EditText _edtUser,_edtEmail;
    Button _btnAceptar,_btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        Log.d(TAG, "Click en boton onCreate...");

        _edtUser = (EditText) findViewById(R.id.edtUser);
        _edtEmail = (EditText) findViewById(R.id.edtEmail);
        _btnAceptar = (Button) findViewById(R.id.btnGrabar);
        _btnRecuperar = (Button) findViewById(R.id.btnRecuperar);

    }

    public void grabar(View view){
        Log.d(TAG, "Click en boton Aceptar...");
        String edtUser =_edtUser.getText().toString();
        String edtEmail =_edtEmail.getText().toString();

        //misDatos: Es el nombre del archivo de preferencias y Context.MODE_PRIVATE: Es la forma de creación
        SharedPreferences myPrefe=getSharedPreferences("misDatos",Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=myPrefe.edit();
        editor.putString("usuario",edtUser);
        editor.putString("email", edtEmail);

        if(!edtUser.equals("") || !edtEmail.equals("")){
            Toast.makeText(this,"Los datos fueron grabados correctamente",Toast.LENGTH_LONG).show();
            editor.commit();
            //finish();
        }else{
            Toast.makeText(this,"Debe ingresar datos para guardar la información.",Toast.LENGTH_LONG).show();
        }
    }

    public void recuperar(View view){
        Log.d(TAG, "Click en boton Recuperar...");

        SharedPreferences myPrefe = getSharedPreferences("misDatos", Context.MODE_PRIVATE);

        _edtUser.setText(myPrefe.getString("usuario",null));
        _edtEmail.setText(myPrefe.getString("email",null));
    }

    public void reiniciar(View view){
        Log.d(TAG, "Click en boton Reiniciar...");

        SharedPreferences myPrefe=getSharedPreferences("misDatos",MODE_PRIVATE);

        SharedPreferences.Editor editor = myPrefe.edit();
        editor.putString("usuario",null);
        editor.putString("email",null);

        editor.commit();

        _edtUser.setText(myPrefe.getString("usuario",null));
        _edtEmail.setText(myPrefe.getString("email",null));
    }
}