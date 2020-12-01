package com.merino.safe_and_security;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class Botonpanic extends AppCompatActivity {

    Button btnpanic, btncofiguracion;
    AlertDialog alerta = null;
    MediaPlayer mp;
    private FusedLocationProviderClient fusedLocationClient;
    DatabaseReference mdatabase;
    RecyclerView recyclerUsuarios;
    EditText txtnombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botonpanic);
        btnpanic = findViewById(R.id.btnpanic);
        btncofiguracion = findViewById(R.id.btnconfiguracion);
        txtnombre = findViewById(R.id.txtnombre);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mdatabase = FirebaseDatabase.getInstance().getReference();
        recyclerUsuarios = findViewById(R.id.recyclerUsuarios);

       // permitirubicacion();


        mp = MediaPlayer.create(this, R.raw.sonido);

        btnpanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtnombre.length() <= 2){
                    txtnombre.setError("Escriba su nombre para poder enviar la ubicacion");

                }else {

                    ubicacion();
                    mp.start();
                }

            }
        });
        btncofiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent interoc = new Intent(Botonpanic.this, VerUbicacion.class);
                startActivity(interoc);

            }
        });
    }


    private void ubicacion( ) {
        if (ContextCompat.checkSelfPermission(Botonpanic.this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this, "Tenemos permiso", Toast.LENGTH_LONG).show();
        }else{
            ActivityCompat.requestPermissions(Botonpanic.this,new
                    String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},1);


        }

            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                Log.e("latitud", +location.getLatitude() + "longitud" + location.getLongitude());
                                Map<String, Object> ubicacion = new HashMap<>();
                                ubicacion.put("latitud", location.getLatitude());
                                ubicacion.put("longitud", location.getLongitude());
                                ubicacion.put("nombre",txtnombre);


                                mdatabase.child("usuarios").setValue(ubicacion, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                        Toast.makeText(getApplicationContext(),"Usuario creado",Toast.LENGTH_LONG).show();

                                    }
                                });

                            }
                        }
                    });

    }


}
