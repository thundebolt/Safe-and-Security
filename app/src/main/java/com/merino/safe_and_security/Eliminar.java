package com.merino.safe_and_security;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class Eliminar extends AppCompatActivity {
RecyclerView recyclerView;
List<ubicacion> destinosList;
FirebaseRecyclerAdapter<ubicacion,ubicacionadapter.ViewHolder> adapter;
DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        recyclerView =(RecyclerView) findViewById(R.id.datoseliminar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new FirebaseRecyclerAdapter<ubicacion, ubicacionadapter.ViewHolder>(
               ubicacion.class,
                R.layout.cardview,
                ubicacionadapter.ViewHolder.class,
                databaseReference.child("usuarios")

                ) {

            @Override
            protected void populateViewHolder(ubicacionadapter.ViewHolder viewHolder, ubicacion ubicacion, final int i) {
            viewHolder.nombre.setText(String.valueOf(ubicacion.getNombre()));
                viewHolder.latitud.setText(String.valueOf(ubicacion.getLatitud()));
                viewHolder.longitud.setText(String.valueOf(ubicacion.getLongitud()));
                
                viewHolder.eliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapter.getRef(i).removeValue();
                }
            });
            }
        };
        recyclerView.setAdapter(adapter);


    }
}