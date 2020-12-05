package com.merino.safe_and_security;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class olvidaste extends AppCompatActivity {
    Button btnolvidaste;
    EditText txtcorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidaste);
        btnolvidaste = findViewById(R.id.btnrecuperar);
        txtcorreo = findViewById(R.id.txtcorreo);

        btnolvidaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }
    public void validate(){
        String email = txtcorreo.getText().toString().trim();
        if (email.isEmpty()){
            txtcorreo.setError("correo invalido");
        }
        sendEmail(email);
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(olvidaste.this,MainActivity.class);
        startActivity(intent);
    }
    public void sendEmail(String email){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = email;

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(olvidaste.this,"Correo enviado",Toast.LENGTH_LONG).show();
                            Intent intent= new Intent(olvidaste.this,MainActivity.class);
                            startActivity(intent);
                            finish();

                        }else {
                            Toast.makeText(olvidaste.this,"correo invalido",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}