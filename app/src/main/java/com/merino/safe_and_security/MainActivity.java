package com.merino.safe_and_security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Creamos la variable que hara referencia a widget
    private TextView txttitle;
    private Button btnpanic;
    private Button btncon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Realizar las referencias
        txttitle = findViewById(R.id.txttitle);
        btncon = findViewById(R.id.btncon);
        btnpanic = findViewById(R.id.btnpanic);
    }
    public void Saludar(View View ) {
        Toast.makeText(this,"Cambiaste de color",Toast.LENGTH_LONG).show();
        txttitle.setTextColor(Color.BLUE);

    }
    public void configuracion(View View){
        Intent configuracion = new Intent(this,Configuracion.class);
        startActivity(configuracion);
    }
}