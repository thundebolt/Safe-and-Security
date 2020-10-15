package com.merino.safe_and_security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Configuracion extends AppCompatActivity {
    Button btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        btnvolver = findViewById(R.id.btnvolver);

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Configuracion.this ,MainActivity.class);
                startActivity(intento);
            }
        });

    }


}