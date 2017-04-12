package com.iscodem.loginfinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.iscodem.loginfinal.bean.UsuarioBean;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getName();

    EditText edtUsuarioLogin, edtUsuarioPassword;
    UsuarioBean usuarioBean =null;
    List<UsuarioBean> lstUsuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (BuildConfig.DEBUG) {
            Log.e(Constants.LOG, "onCreate called");
        }

        Log.d(TAG, "onCreate called");

        crearUsuarios();
        edtUsuarioLogin = (EditText) findViewById(R.id.edtUsuarioLogin);
        edtUsuarioPassword= (EditText) findViewById(R.id.edtUsuarioPassword);

        SharedPreferences myPreferences = getSharedPreferences("misDatos",Context.MODE_PRIVATE);
        edtUsuarioLogin.setText(myPreferences.getString("usuario",null));
        edtUsuarioPassword.setText(myPreferences.getString("password",null));
    }

    public void crearUsuarios(){
        usuarioBean = new UsuarioBean("David Paul Porras Cordova","dporras","dporras");
    }

    public List<UsuarioBean> ontenerUsuarios(){

        return null;
    }


    public boolean validaLogin(String usuario, String password){
        boolean rpta=false;
        String mensaje="";

        SharedPreferences myPreferences = getSharedPreferences("misDatos", Context.MODE_PRIVATE);

        Log.d(TAG,"USUARIO: "+usuario);
        Log.d(TAG,"PASSWORD: "+password);

        if("".equals(usuario)){
            mensaje="Debe ingresar usuario.";
        }else if ("".equals(password)){
            mensaje="Debe ingresar password.";
        }else if (!usuarioBean.getUsuario().equals(usuario) || !usuarioBean.getPassword().equals(password)){
        //else if(!myPreferences.getString("usuario",null).equals(usuario) ||!myPreferences.getString("password",null).equals(password) ){
            mensaje="Los datos son incorrectos (usuario ó password)";
        }else{
            rpta=true;
        }

        if(!rpta){
            Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
        }
        return rpta;
    }

    public void irBienvenida(View view){
        String usuario= edtUsuarioLogin.getText().toString();
        String password= edtUsuarioPassword.getText().toString();

        try {
            if(validaLogin(usuario,password)) {
                SharedPreferences myPreferences = getSharedPreferences("misDatos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myPreferences.edit();

                editor.putString("usuario", usuario);
                editor.putString("password", password);
                editor.commit();

                Intent intent = new Intent(this, BienvenidoActivity.class);
                intent.putExtra("nombre", myPreferences.getString("usuario",null));
                startActivity(intent);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        Log.d(Constants.LOG, "irBienvenida called");
        Log.d(TAG,"Mensaje convenional.(irBienvenida).");
    }

    /**
     * @author: dporrasc
     * @param view
     */
    public void irCrearUsuario(View view){
        Intent intent = new Intent(this, CrearUsuarioActivity.class);
        startActivity(intent);
        Log.d(Constants.LOG, "irCrearUsuario called");
        Log.d(TAG,"Mensaje convenional.(irCrearUsuario).");
    }
}
