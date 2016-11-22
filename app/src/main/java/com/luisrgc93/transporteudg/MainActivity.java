package com.luisrgc93.transporteudg;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private Button buttonUsuario;
    private Button buttonTransporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        buttonUsuario = (Button) findViewById(R.id.buttonUsuario);
        buttonTransporte = (Button) findViewById(R.id.buttonTransporte);

        buttonUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VentanaUsurios.class);
                startActivity(intent);
            }
        });

        buttonTransporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTransporte = new Intent(MainActivity.this, VentanaTransporte.class);
                startActivity(intentTransporte);
            }
        });
    }
}
