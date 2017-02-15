package com.iscodem.toastsnackbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = MainActivity.class.getName();

    private String nombre;
    private CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        Button btnSaludarToast =(Button) findViewById(R.id.btnSaludarToast);
        Button btnSnackBarDefault = (Button) findViewById(R.id.btnSnackBarDefault);
        Button btnSnackBarAction = (Button) findViewById(R.id.btnSnackBarAction);
        Button btnSnackBarCustom = (Button) findViewById(R.id.btnSnackBarCustom);

        final EditText edtNombre=(EditText) findViewById(R.id.edtNombre);

        btnSaludarToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = String.valueOf(edtNombre.getText());
                Log.d(TAG, "valor de Nombre Toast: " + nombre);
                if(nombre.equals("")){
                    Toast.makeText(getApplicationContext(),"Usted no ingreso valor alguno." , Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Usted ingreso: "+nombre , Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSnackBarDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = String.valueOf(edtNombre.getText());
                Log.d(TAG, "valor de Nombre Toast: " + nombre);
                if(nombre.equals("")){
                    Snackbar snackbar = Snackbar.make(coordinatorLayout,"Usted no ingreso valor alguno.",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }else{
                    Snackbar snackbar = Snackbar.make(coordinatorLayout,"Usted ingreso: "+nombre ,Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        btnSnackBarAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar =Snackbar.make(coordinatorLayout,"Mensaje de Snackbar con acción",Snackbar.LENGTH_LONG)
                        .setAction("Click Aqui", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(coordinatorLayout,"Gracias por hacer click interno",Snackbar.LENGTH_LONG);
                                snackbar1.show();
                            }
                        });
                snackbar.show();
            }
        });

        btnSnackBarCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Sin conexión de internet!¡", Snackbar.LENGTH_LONG)
                        .setAction("RETROCEDER", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

                // Changing message text color
                snackbar.setActionTextColor(Color.RED);

                // Changing action button text color
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.MAGENTA);

                snackbar.show();
            }
        });
    }

}
