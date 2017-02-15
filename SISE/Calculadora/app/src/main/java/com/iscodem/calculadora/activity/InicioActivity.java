package com.iscodem.calculadora.activity;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.TextView;
import com.iscodem.calculadora.R;

public class InicioActivity extends AppCompatActivity {
    private static final String TAG = InicioActivity.class.getSimpleName();

    private String respuesta;
    private TextView tvResultado;
    private EditText etNumero1;
    private EditText etNumero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Inicio - onCreate() event" + this.getClass());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        etNumero1=(EditText)findViewById(R.id.etNumero1);
        etNumero2=(EditText)findViewById(R.id.etNumero2);
        tvResultado=(TextView)findViewById(R.id.tvResultado);

        Log.i(TAG,"(DPORRASC)");
        Log.i(TAG,"getApplicationContext(): "+getApplicationContext());
        Log.i(TAG,"Context ctx = this: "+this);

        //Vincular el Evento Click al método
        Button boton = (Button)findViewById(R.id.btnCalcular);
        boton.setOnClickListener( new View.OnClickListener() {
                                      public void onClick(View v) {
                                          sumar(etNumero1, etNumero2);
                                      }
                                  });

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Bienvenido colegas... " , Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }

    public InicioActivity() {
        super();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sumar(EditText etNumero1,EditText etNumero2){
        try{
            String valor1= etNumero1.getText().toString();
            String valor2= etNumero2.getText().toString();
            int nro1=Integer.parseInt(valor1);
            int nro2=Integer.parseInt(valor2);
            int suma=nro1+nro2;
            String rpta=String.valueOf(suma);
            tvResultado.setText(rpta);
        }catch(NumberFormatException e){
            //e.printStackTrace();
            tvResultado.setText("Se debe ingresar unicamente números...");
        }
   }

}
