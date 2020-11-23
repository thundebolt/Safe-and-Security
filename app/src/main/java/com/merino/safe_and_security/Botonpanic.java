package com.merino.safe_and_security;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Botonpanic extends AppCompatActivity {
Button btnpanic,btncofiguracion;
AlertDialog alerta = null;
        MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botonpanic);
        btnpanic = findViewById(R.id.btnpanic);
        btncofiguracion = findViewById(R.id.btnconfiguracion);
        permitirubicacion();


        mp = MediaPlayer.create(this,R.raw.sonido);

        btnpanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mp.start();
            }
        });
btncofiguracion.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent interoc = new Intent(Botonpanic.this,Configuracion.class);
        startActivity(interoc);
    }
});
    }

    private void permitirubicacion() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Porfavor encienda el Gps. Desea Activarlo")
                .setCancelable(false)
                .setTitle("GPS")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                dialog.cancel();

            }
        });
        alerta = builder.create();
        alerta.show();

    }
}