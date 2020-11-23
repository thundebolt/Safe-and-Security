package com.merino.safe_and_security;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    // Creamos la variable que hara referencia a widget

    Button btninicio, btncancelar, btnregistro;
    EditText email, pass;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Realizar las referencias
        mAuth = FirebaseAuth.getInstance();
        btncancelar = findViewById(R.id.btncancelar);
        btninicio = findViewById(R.id.btninicio);
        btnregistro = findViewById(R.id.btnregistro);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

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
                pass.setText("");
                email.setText("");
            }
        });
        btninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar(view);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void validar(View view) {


        if (email.getText().length() <= 0) {
            email.setError("Ingrese su nombre");
        } else if (pass.getText().length() <= 0) {
            pass.setError("ingrese una contraseña");
        }


        mAuth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            // Log.d(TAG, "signInWithEmail:success");
                            Toast.makeText(MainActivity.this, "Bienvenido " , Toast.LENGTH_LONG).show();
                            Intent interor = new Intent(MainActivity.this, Botonpanic.class);
                            startActivity(interor);

                            FirebaseUser user = mAuth.getCurrentUser();
                            // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //   Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //   updateUI(null);
                        }
                    }

                });

    }


}
