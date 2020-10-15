package com.merino.safe_and_security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Botonpanic extends AppCompatActivity {
Button btnpanic,btncofiguracion;
        MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botonpanic);
        btnpanic = findViewById(R.id.btnpanic);
        btncofiguracion = findViewById(R.id.btnconfiguracion);

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
    }
});
    }
}