package com.merino.safe_and_security;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Patterns;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {
    EditText txtusuario, txtpass, txtemail;
    Button btnregistro, btnvolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnvolver = findViewById(R.id.btnvolver);
        btnregistro = findViewById(R.id.btnregistro);
        txtusuario = findViewById(R.id.txtusuario);
        txtpass = findViewById(R.id.txtcontraseña);
        txtemail = findViewById(R.id.txtemail);

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentoo = new Intent(Registro.this, MainActivity.class);
                startActivity(intentoo);
            }
        });

        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validardatos(view);



            }
        });

    }

    public void validardatos(View view) {
        String usuario = txtusuario.getText().toString();
        String password = txtpass.getText().toString();
        String email = txtemail.getText().toString();


        if (usuario.length() == 0){
            Toast.makeText(this, "Debes ingresar un usuario",Toast.LENGTH_LONG).show();
        }
        else if(usuario.length() < 3){
            Toast.makeText(this,"El nombre de usuario debe ser mayor a 3 letras",Toast.LENGTH_LONG).show();
        }
        if (password.length() <8){
            Toast.makeText(this,"La contraseña debe ser mayor a 8 caracteres",Toast.LENGTH_LONG).show();
        }
        else if (email.length() == 0){
            Toast.makeText(this,"El email esta vacio",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"ESTAS REGISTRADO :3",Toast.LENGTH_LONG).show();
            Intent interor = new Intent(Registro.this,Botonpanic.class);
            startActivity(interor);

        }


    }

}
