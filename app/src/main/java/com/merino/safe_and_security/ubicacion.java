package com.merino.safe_and_security;

public class ubicacion {
    private double latitud;
    private double longitud;
    private  String nombre;


    public ubicacion(double latitud, double longitud,String nombre) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;

    }


    public ubicacion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
