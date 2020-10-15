package com.merino.safe_and_security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    // Creamos la variable que hara referencia a widget

   Button btninicio,btncancelar,btnregistro;
   EditText txtusuario,txtpass;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Realizar las referencias
        btncancelar = findViewById(R.id.btncancelar);
        btninicio = findViewById(R.id.btninicio);
        btnregistro = findViewById(R.id.btnregistro);
        txtusuario = findViewById(R.id.txtusuario);
        txtpass = findViewById(R.id.txtpass);

        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent INTENTOR = new Intent(MainActivity.this, Registro.class);
                startActivity(INTENTOR);
            }
        });
        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtpass.setText("");
                txtusuario.setText("");
            }
        });
        }


    }
