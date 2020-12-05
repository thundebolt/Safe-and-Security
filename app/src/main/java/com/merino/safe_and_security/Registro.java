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
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;

        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseAuthUserCollisionException;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;


public class Registro extends AppCompatActivity {
    EditText txtconfirmar, txtpass, txtemail;
    Button btnregistro, btnvolver;
    private FirebaseAuth mAuth;
    DatabaseReference database;
    ImageView logo,logo2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_registro);

        btnvolver = findViewById(R.id.btnvolver);
        btnregistro = findViewById(R.id.btnrecuperar);
        txtconfirmar = findViewById(R.id.txtconfirmar);
        txtpass = findViewById(R.id.txtcontraseña);
        txtemail = findViewById(R.id.email);
        logo = findViewById(R.id.logo);
        logo2 = findViewById(R.id.logo2);
        database = FirebaseDatabase.getInstance().getReference();




        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          transicion();
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
    public void onBackPressed(){
        transicion();
    }
    public void transicion() {
        Intent intent = new Intent(Registro.this, MainActivity.class);
        Pair[] pairs = new Pair[7];
        pairs[0] = new Pair<View, String>(logo, "ImageTransition");
        pairs[1] = new Pair<View, String>(logo2, "logoImageTransition");
        pairs[2] = new Pair<View, String>(txtemail, "email");
        pairs[3] = new Pair<View, String>(txtpass, "confirmarTransition");
        pairs[4] = new Pair<View, String>(txtconfirmar, "contraseña");
        pairs[5] = new Pair<View, String>(btnregistro, "btnrTransition");
        pairs[6] = new Pair<View, String>(btnvolver, "btnvTransition");
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Registro.this, pairs);
            startActivity(intent, options.toBundle());
        }else{
            startActivity(intent);
            finish();

        }


    }
    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

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
        else if(txtpass.getText()!= txtconfirmar.getText()) {
            txtconfirmar.setError("Las contraseñas no son iguales");
        }else{

            mAuth.createUserWithEmailAndPassword( txtemail.getText().toString(),txtpass.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Registro.this,"ESTAS REGISTRADO :3",Toast.LENGTH_LONG).show();
                                Intent interor = new Intent(Registro.this,MainActivity.class);
                                startActivity(interor);

                            } else {
                                if(task.getException() instanceof FirebaseAuthUserCollisionException){

                                    Toast.makeText(Registro.this, "Ese usuario ya existe",
                                            Toast.LENGTH_SHORT).show();

                                }


                                Toast.makeText(Registro.this, "No se pudo registrar",
                                        Toast.LENGTH_SHORT).show();

                            }

                        }
                    });


        }



    }


}

