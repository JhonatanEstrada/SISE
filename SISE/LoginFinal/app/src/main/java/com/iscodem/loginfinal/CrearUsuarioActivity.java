package com.iscodem.loginfinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iscodem.loginfinal.bean.UsuarioBean;

public class CrearUsuarioActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getName();

    Button btnCrearCuenta;
    EditText edtUsuarioCreateLogin,edtUsuarioCreateEmail,
            edtUsuarioCreateNombres,edtUsuarioCreateApellidos,edtUsuarioCreateDNI,edtUsuarioCreatePassword;

    /**
     * Metodo que crea los componentes inicialmente
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);
        showToolbar(getResources().getString(R.string.tituloToolbarCrearCuenta), true);

        btnCrearCuenta=(Button) findViewById(R.id.btnCrearCuenta);
        edtUsuarioCreateLogin=(EditText) findViewById(R.id.edtUsuarioCreateLogin);
        edtUsuarioCreateEmail=(EditText) findViewById(R.id.edtUsuarioCreateEmail);
        edtUsuarioCreateNombres=(EditText) findViewById(R.id.edtUsuarioCreateNombres);
        edtUsuarioCreateApellidos=(EditText) findViewById(R.id.edtUsuarioCreateApellidos);
        edtUsuarioCreateDNI=(EditText) findViewById(R.id.edtUsuarioCreateDNI);
        edtUsuarioCreatePassword=(EditText) findViewById(R.id.edtUsuarioCreatePassword);
    }

    /**
     * Metodo que muestra un toolbar en el layout
     * @param tittle
     * @param upButton
     */
    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

    /**
     * Metodo que crea una cuenta
     * @param view
     */
    public void crearCuenta(View view){
        Log.d(TAG,"Inicio metodo: crearCuenta()");

        String login,email,nombres,apellidos,dni,password;
        nombres = edtUsuarioCreateNombres.getText().toString();
        login = edtUsuarioCreateLogin.getText().toString();
        email = edtUsuarioCreateEmail.getText().toString();
        password = edtUsuarioCreatePassword.getText().toString();

        UsuarioBean usuarioBean = new UsuarioBean(nombres,login,password);

        Log.d(TAG,"USUARIO: "+usuarioBean.getUsuario());
        Intent intent = new Intent(this, CreadoActivity.class);

        if(usuarioBean.getUsuario().length()>0){
            intent.putExtra("mensaje","El usuario ("+usuarioBean.getUsuario().toUpperCase()+") fue creado con éxito.");
            SharedPreferences myPreference=getSharedPreferences("misDatos", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = myPreference.edit();
            editor.putString("nombres",usuarioBean.getNombre());
            editor.putString("password",usuarioBean.getPassword());
            editor.putString("usuario",usuarioBean.getUsuario());
            editor.commit();
        }else{
            intent.putExtra("mensaje","No ha ingresado usuario");
        }
        startActivity(intent);
    }
}
