package com.luisrgc93.transporteudg;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.luisrgc93.transporteudg.lib.getRutas;

import java.util.ArrayList;

/**
 * Created by luisr_000 on 15/11/2016.
 */

public class VentanaTransporte extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener,GoogleMap.OnMarkerClickListener
{
    ListView lista;
    ArrayList<getRutas> list = new ArrayList<getRutas>();
    getRutas rutas;

    GoogleMap map;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa_usuario);

        LinearLayout listaUsuarios = (LinearLayout)findViewById(R.id.listaUsuarios);

        lista = (ListView) findViewById(R.id.lista_puntos);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapTransporte);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        map.setMyLocationEnabled(true);
        map.setOnMarkerClickListener(this);
        map.setOnMapLongClickListener(this);
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    @Override
    public void onMapLongClick(LatLng puntoPulsado) {
        map.addMarker(new MarkerOptions().title("Marcador").position(puntoPulsado).
                icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));


    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        return true;
    }
}
