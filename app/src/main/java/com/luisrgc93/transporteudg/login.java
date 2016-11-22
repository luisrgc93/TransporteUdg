package com.luisrgc93.transporteudg;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by luisr_000 on 04/11/2016.
 */
public class login extends AppCompatActivity {

    private EditText etCodigo;
    private EditText etNip;
    private Button validar;

    public static final String USER_NAME = "USERNAME";

    String Codigo;
    String NIP;
    String URL = "http://148.202.152.33/iphone.php";
    String parametros = "";


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etCodigo = (EditText) findViewById(R.id.codigo);
        etNip = (EditText) findViewById(R.id.nip);
        validar = (Button) findViewById(R.id.login);

        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if(networkInfo != null && networkInfo.isConnected())
                {
                    Codigo = etCodigo.getText().toString();
                    NIP = etNip.getText().toString();
                    if (Codigo.isEmpty() || NIP.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Uno de los campos esta vacio", Toast.LENGTH_LONG).show();
                        return;
                    }

                    parametros = "codigo=" + Codigo + "&nip=" + NIP;
                    new SolicitudDatos().execute(URL);
                }
                else {
                    Toast.makeText(getApplicationContext(), "No se ha detectado la conexion", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public class SolicitudDatos extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... params)
        {
                return  Conexion.PostDatos(URL, parametros);
        }
        @Override
        protected void onPostExecute(String result)
        {

            Log.d("Resultado", result);
            if(result == "0") {
                Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show();
            }
            else
            {
                ProgressDialog loadingDialog = ProgressDialog.show(login.this, "Ingresando","Cargando");
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);

            }

        }
    }
}
