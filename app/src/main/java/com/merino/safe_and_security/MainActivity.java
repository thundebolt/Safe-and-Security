package com.merino.safe_and_security;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;

import android.os.Build;
import android.os.Bundle;

import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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
    ImageView imagen1,imagen2;
    TextView olvidastecontraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Realizar las referencias
        mAuth = FirebaseAuth.getInstance();
        btncancelar = findViewById(R.id.btncancelar);
        btninicio = findViewById(R.id.btninicio);
        btnregistro = findViewById(R.id.btnrecuperar);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        imagen1 = findViewById(R.id.logo2);
        imagen2 =findViewById(R.id.logo3);
        olvidastecontraseña = findViewById(R.id.txtolvidar);

        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              transicion();
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

        olvidastecontraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, olvidaste.class);
                startActivity(intent);
                finish();
            }
        });
    }



    public void transicion() {
        Intent intent = new Intent(MainActivity.this, Registro.class);
        Pair[] pairs = new Pair[7];
        pairs[0] = new Pair<View, String>(imagen1, "ImageTransition");
        pairs[1] = new Pair<View, String>(imagen2, "logoImageTransition");
        pairs[2] = new Pair<View, String>(email, "email");
        pairs[3] = new Pair<View, String>(pass, "confirmarTransition");
        pairs[4] = new Pair<View, String>(btninicio, "contraseña");
        pairs[5] = new Pair<View, String>(btnregistro, "btnrTransition");
        pairs[6] = new Pair<View, String>(btncancelar, "btnvTransition");
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
            startActivity(intent, options.toBundle());
        }else{
            startActivity(intent);
            finish();

        }


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
            email.setError("Ingrese su Correo electronico");
        } else if (pass.getText().length() <= 0) {
            pass.setError("ingrese una contraseña");
        } else {
            mAuth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                // Log.d(TAG, "signInWithEmail:success");
                                Toast.makeText(MainActivity.this, "Bienvenido ", Toast.LENGTH_LONG).show();
                                Intent interor = new Intent(MainActivity.this, Botonpanic.class);
                                startActivity(interor);

                                FirebaseUser user = mAuth.getCurrentUser();
                                // updateUI(user);
                            } else {

                                Toast.makeText(MainActivity.this, "Inicio sesion fallado",
                                        Toast.LENGTH_SHORT).show();
                                //   updateUI(null);
                            }
                        }

                    });

        }
    }

}
