package com.example.ev_final_app_moviles;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent intent = getIntent();

        Double lat = intent.getDoubleExtra("Latitud",0);
        Double lon = intent.getDoubleExtra("Longitud",0);
        String nombre = intent.getStringExtra("Descripcion");

        //Recibir datos de una clase con Gson:
        String clase = intent.getStringExtra("clase");
        //transformar esa lista recibida Gson:
        /*Contacto contacto = new Gson().fromJson(clase,Contacto.class);
        Double Latitud = Double.valueOf(contacto.getAddress().getLatitud());
        Double Longitud = Double.valueOf(contacto.getAddress().getLongitud());
        String direccion = contacto.getAddress().getDescripcion();*/

        Log.i("MY_APP","La latitud es: " + lat);
        Log.i("MY_APP","La longitud es: " + lon);
        Log.i("MY_APP","La direccion es: " + nombre);

        // Add a marker in Sydney and move the camera
        LatLng ubicacion = new LatLng(lat, lon);
        //LatLng sydney = new LatLng(Latitud, Longitud);
        mMap.addMarker(new MarkerOptions().position(ubicacion).title(nombre));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion,15f));
    }
}