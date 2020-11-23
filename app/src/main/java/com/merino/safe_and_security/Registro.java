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



public class Registro extends AppCompatActivity {
    EditText txtusuario, txtpass, txtemail;
    Button btnregistro, btnvolver;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_registro);

        btnvolver = findViewById(R.id.btnvolver);
        btnregistro = findViewById(R.id.btnregistro);
        txtusuario = findViewById(R.id.email);
        txtpass = findViewById(R.id.txtcontraseña);
        txtemail = findViewById(R.id.email);

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

                registrarse(view);



            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser)
    }

    public  void registrarse(View view){


        if (txtpass.getText().length() <=0){
            txtpass.setError("Ingrese su contraseña");
        }else if (txtpass.getText().length() <=8){
            txtpass.setError("la contraseña debe ser mayor a 8 letras");

        }
        else if (txtemail.getText().length() <= 0 ){
            txtemail.setError("Ingrese su email");
        }
        else {

            mAuth.createUserWithEmailAndPassword( txtemail.getText().toString(),txtpass.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(Registro.this,"ESTAS REGISTRADO :3",Toast.LENGTH_LONG).show();
                                Intent interor = new Intent(Registro.this,MainActivity.class);
                                startActivity(interor);
                              //  updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                            //    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Registro.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                               // updateUI(null);
                            }

                            // ...
                        }
                    });


        }



    }
    public void validardatos(View view) {
        String usuario = txtusuario.getText().toString();
        String password = txtpass.getText().toString();
        String email = txtemail.getText().toString();




    }


}

