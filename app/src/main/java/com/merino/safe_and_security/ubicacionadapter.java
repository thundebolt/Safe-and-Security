package com.merino.safe_and_security;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public  class ubicacionadapter extends RecyclerView.Adapter<ubicacionadapter.ViewHolder> {
    List<ubicacion> ubicacion;
    Context context;

    public ubicacionadapter(Context context , List<ubicacion> ubicacion){
        this.context = context;
        this.ubicacion = ubicacion;
    }

    @NonNull
    @Override
    public ubicacionadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ubicacionadapter.ViewHolder holder, int position) {
        holder.nombre.setText(ubicacion.get(position).getNombre());

    }

    @Override
    public int getItemCount() {

        return ubicacion.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView nombre;
        TextView latitud;
        TextView longitud;
        ImageView eliminar;

        public ViewHolder(@NonNull View view) {

            super(view);
            cardView = (CardView) view.findViewById(R.id.Cardview);
            nombre = (TextView) view.findViewById(R.id.nombre);
            latitud = (TextView) view.findViewById(R.id.latitud);
            longitud = (TextView) view.findViewById(R.id.longitud);
            eliminar = (ImageView) view.findViewById(R.id.eliminar);

        }
    }
}
